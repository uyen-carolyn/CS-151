package hw2;

import java.util.ArrayList;

/**
 * A system of voice mail boxes.
 */
public class MailSystem {
	/**
	 * Constructs a mail system with a given number of mailboxes
	 * 
	 * @param mailboxCount the number of mailboxes
	 */
	public MailSystem(int mailboxCount) {
		mailboxes = new ArrayList<>();

		// Initialize mail boxes.

		for (int i = 0; i < mailboxCount; i++) {
			String passcode = "" + (i + 1);
			String greeting = "You have reached mailbox " + (i + 1) + "."; 
			mailboxes.add(new Mailbox(passcode, greeting));
		}
	}

	/**
	 * Locate a mailbox.
	 * Edit: altered method to handle exceptions by adding a "try-catch block" so that
	 * any invalid inputs are simply caught instead of thrown an exception
	 * 
	 * @param ext the extension number
	 * @return the mailbox or null if not found
	 */
	public Mailbox findMailbox(String ext) {
		try {
			int i = Integer.parseInt(ext);
			if (1 <= i && i <= mailboxes.size())
				return mailboxes.get(i - 1);
		}
		catch (NumberFormatException e) {
			return null; // used to determine if mailbox is valid in Connection method 'connect(key)' 
		}
			return null;
	}

	private ArrayList<Mailbox> mailboxes;
}
