package hw2;

/**
 * Connects a phone to the mail system. The purpose of this class is to keep
 * track of the state of a connection, since the phone itself is just a source
 * of individual key presses.
 */
public class Connection {
	/**
	 * Construct a Connection object.
	 * 
	 * @param s a MailSystem object
	 * @param p a Telephone object
	 */
	public Connection(MailSystem s, Telephone p) {
		system = s;
		phone = p;
		resetConnection();
	}

	/**
	 * Respond to the user's pressing a key on the phone touchpad
	 * Edit: added two conditional statements for two new states
	 * 
	 * @param key the phone key pressed by the user
	 */
	public void dial(String key) {
		if (state == CONNECTED)
			connect(key);
		else if (state == RECORDING)
			login(key);
		else if (state == CHANGE_PASSCODE)
			changePasscode(key);
		else if (state == CHANGE_GREETING)
			changeGreeting(key);
		else if (state == MAILBOX_MENU)
			mailboxMenu(key);
		else if (state == MESSAGE_MENU)
			messageMenu(key);
		else if (state == START_MENU)
			startMenu(key); 
	}

	/**
	 * Record voice.
	 * 
	 * @param voice voice spoken by the user
	 */
	public void record(String voice) {
		if (state == RECORDING || state == CHANGE_GREETING)
			currentRecording += voice;
	}

	/**
	 * The user hangs up the phone.
	 */
	public void hangup() {
		if (state == RECORDING)
			currentMailbox.addMessage(new Message(currentRecording));
		resetConnection();
	}

	/**
	 * Reset the connection to the initial state and prompt for mailbox number
	 */
	private void resetConnection() {
		currentRecording = "";
		accumulatedKeys = "";
		state = CONNECTED;
		phone.speak(INITIAL_PROMPT);
	}

	/**
	 * Try to connect the user with the specified mailbox.
	 * Edit: altered if-else conditional statement to run start menu that 
	 * gives options to either leave a message or access mail box, 
	 * and run error message if incorrect mailbox is inputed until 
	 * a proper input is inputed. 
	 * 
	 * @param key the phone key pressed by the user
	 */
	private void connect(String key) {
		if (key.equals("#")) {
			currentMailbox = system.findMailbox(accumulatedKeys);
			
			if (currentMailbox != null)
	         {
				state = START_MENU; 			// shows start menu where user can either leave message or access mailbox
				phone.speak(START_MENU_TEXT); 
			} 
			else {
					phone.speak("Incorrect mailbox number. Try again!");
				    accumulatedKeys = "";
				    connect(accumulatedKeys); // repeats method until valid input is inputed
			}
		}
		else 
			accumulatedKeys += key;
	}
	
	/**
	 * New method: Ask user whether they want to leave a message or access that mailbox
	 * 
	 * @param key the phone key pressed by the user
	 */
	private void startMenu(String key) {  
		accumulatedKeys = ""; 
		if(key.equals("1")) {
			state = RECORDING; 
			phone.speak(currentMailbox.getGreeting());
			phone.speak("Please enter your message and then press H");
		}
		else if (key.equals("2")){
			state = RECORDING; 
			phone.speak("Please enter your password and then press #"); 
		}
		else {
			phone.speak(START_MENU_TEXT);
		}
	}
	
	/**
	 * Try to log in the user.
	 * 
	 * @param key the phone key pressed by the user
	 */
	private void login(String key) {
		if (key.equals("#")) {
			if (currentMailbox.checkPasscode(accumulatedKeys)) {
				state = MAILBOX_MENU;
				phone.speak(MAILBOX_MENU_TEXT);
			} 
			else
				phone.speak("Incorrect passcode. Try again!");
				accumulatedKeys = "";
			
		} 
		else
			accumulatedKeys += key;
	}

	/**
	 * Change passcode.
	 * 
	 * @param key the phone key pressed by the user
	 */
	private void changePasscode(String key) {
		if (key.equals("#")) {
			currentMailbox.setPasscode(accumulatedKeys);
			state = MAILBOX_MENU;
			phone.speak(MAILBOX_MENU_TEXT);
			accumulatedKeys = "";
		} else
			accumulatedKeys += key;
	}

	/**
	 * Change greeting.
	 * 
	 * @param key the phone key pressed by the user
	 */
	private void changeGreeting(String key) {
		if (key.equals("#")) {
			currentMailbox.setGreeting(currentRecording);
			currentRecording = "";
			state = MAILBOX_MENU;
			phone.speak(MAILBOX_MENU_TEXT);
		}
	}

	/**
	 * Respond to the user's selection from mailbox menu.
	 * Edit: added conditional statement that repeats menu if input is invalid. 
	 * 
	 * @param key the phone key pressed by the user
	 */
	private void mailboxMenu(String key) {
		if (key.equals("1")) {
			state = MESSAGE_MENU;
			phone.speak(MESSAGE_MENU_TEXT);
		} else if (key.equals("2")) {
			state = CHANGE_PASSCODE;
			phone.speak("Enter new passcode followed by the # key");
		} else if (key.equals("3")) {
			state = CHANGE_GREETING;
			phone.speak("Record your greeting, then press the # key");
		}
		else {
			phone.speak(MAILBOX_MENU_TEXT);
		}
	}

	/**
	 * Respond to the user's selection from message menu.
	 * Edit: added conditional statement that repeats menu if input is invalid. 
	 * 
	 * @param key the phone key pressed by the user
	 */
	private void messageMenu(String key) {
		if (key.equals("1")) {
			String output = "";
			Message m = currentMailbox.getCurrentMessage();
			if (m == null)
				output += "No messages." + "\n";
			else
				output += m.getText() + "\n";
			output += MESSAGE_MENU_TEXT;
			phone.speak(output);
		} else if (key.equals("2")) {
			currentMailbox.saveCurrentMessage();
			phone.speak(MESSAGE_MENU_TEXT);
		} else if (key.equals("3")) {
			currentMailbox.removeCurrentMessage();
			phone.speak(MESSAGE_MENU_TEXT);
		} else if (key.equals("4")) {
			state = MAILBOX_MENU;
			phone.speak(MAILBOX_MENU_TEXT);
		}
		else {
			phone.speak(MESSAGE_MENU_TEXT);
		}		
	}

	private MailSystem system;
	private Mailbox currentMailbox;
	private String currentRecording;
	private String accumulatedKeys;
	private Telephone phone;
	private int state;

	private static final int DISCONNECTED = 0;
	private static final int CONNECTED = 1;
	private static final int RECORDING = 2;
	private static final int MAILBOX_MENU = 3;
	private static final int MESSAGE_MENU = 4;
	private static final int CHANGE_PASSCODE = 5;
	private static final int CHANGE_GREETING = 6;
	private static final int START_MENU = 7; // new state

	private static final String INITIAL_PROMPT = "Enter mailbox number followed by #";
	private static final String MAILBOX_MENU_TEXT = "Enter 1 to listen to your messages\n"
			+ "Enter 2 to change your passcode\n" + "Enter 3 to change your greeting";
	private static final String MESSAGE_MENU_TEXT = "Enter 1 to listen to the current message\n"
			+ "Enter 2 to save the current message\n" + "Enter 3 to delete the current message\n"
			+ "Enter 4 to return to the main menu";
	private static final String START_MENU_TEXT  ="Enter 1 to leave a message\n"
			+ "Enter 2 to access this mailbox";		// new state message
}