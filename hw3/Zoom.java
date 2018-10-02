import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Program that zooms in on a 2D image of a car with a push of a button
 */
public class Zoom extends JPanel implements ActionListener {
	private JButton in = new JButton("Zoom In");
	private JButton out = new JButton("Zoom Out");
	
	private int heightR;
	private int widthR;
	private int heightW;
	private int widthW;  
	
	

	public Zoom() {
		add(in);
		add(out);

		in.addActionListener(this);
		out.addActionListener(this);
		
		widthR = 100; 
		heightR = 50; 
		
		widthW = 20;
		heightW = 20;  
	}

	/**
	 * Creates the car and initializes its dimensions
	 * 
	 * @param g the graphics that will be the car
	 */
	public void paint(Graphics g) {
		
		
		super.paint(g);
		
		int xCenter = getWidth() / 2;
	    int yCenter = getHeight() / 2;
		
		// body of car
		g.setColor(Color.red);
		g.fillRect(xCenter - widthR/2, yCenter - heightR/2, widthR, heightR);
		
		// front tire
		g.setColor(Color.black); 
		g.fillOval(xCenter - widthR/2, yCenter + heightR/2, widthW, heightW);

		// back tire
		g.setColor(Color.black);
		g.fillOval(xCenter + widthR/4, yCenter + heightR/2, widthW, heightW);
	}

	/**
	 * Determines which color the circle changes depending on what button is pressed
	 * 
	 * @param evt the action of which button is pressed
	 */
	public void actionPerformed(ActionEvent evt) {
		Object source = evt.getSource();
		if (source == in) { 
			widthR = widthR + 40; 
			heightR = heightR + 20;
 
			widthW = widthW + 10; 
			heightW = heightW + 10;
		}
		else if (source == out) {
			widthR = widthR - 40; 
			heightR = heightR - 20;
			
			widthW = widthW - 10; 
			heightW = heightW - 10;
		}
		repaint();
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Change The Circle!");
		frame.setSize(500, 500);

		// Creates window where program will run
		// Closes program when exited and restarts when run again
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		// adds program into the window
		Container contentPane = frame.getContentPane();
		contentPane.add(new Zoom());

		frame.show();
	}
}
