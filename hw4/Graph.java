import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Graph extends JPanel implements ActionListener {

	JFrame frame = new JFrame();
	JPanel pane1 = new JPanel();
	JPanel pane2 = new JPanel();
	
	JLabel blue = new JLabel("Blue Bar");
	JLabel green = new JLabel("Green Bar");
	JLabel red = new JLabel("Red Bar"); 
	
	JLabel barB = new JLabel("");
	JLabel barR = new JLabel("");
	JLabel barG = new JLabel("");
	
	JTextField b = new JTextField(" 2 "); 
	JTextField g = new JTextField(" 7 "); 
	JTextField r = new JTextField(" 3 "); 
	
	private JButton bb = new JButton("Enter");
	private JButton gb = new JButton("Enter");
	private JButton rb = new JButton("Enter");
	
	private int height1;
	private int height2;
	private int height3;
	
	private int y1;
	private int y2;
	private int y3; 
	
	private String number1 = "";
	private String number2 = ""; 
	private String number3 = ""; 
	
	public Graph() {
		add(pane1, BorderLayout.NORTH);
		pane1.add(blue);
		pane1.add(b);
		pane1.add(bb); 
		pane1.add(green);
		pane1.add(g);
		pane1.add(gb); 
		pane1.add(red);
		pane1.add(r);
		pane1.add(rb);
		
		
		bb.addActionListener(this);
		gb.addActionListener(this);
		rb.addActionListener(this);
		b.addActionListener(this);
		g.addActionListener(this);
		r.addActionListener(this); 
		
		y1 = 280;
		y2 = 230;
		y3 = 270; 
		
		height1 = 20; // default 
		height2 = 70;
		height3 = 30; 
		
		number1 = "2";  // default 
		number2 = "7";
		number3 = "3"; 
	}

	public void paint(Graphics g) {
		super.paint(g);
		
		g.drawString("0", 35, 305);
		g.drawString("5", 35, 255);
		g.drawString("10", 35, 205);
		g.drawString("15", 35, 155);
		g.drawString("20", 35, 105);
		g.drawString("25", 35, 55);
		
		g.drawString(number1, 115, 320);
		
		g.drawString(number2, 285, 320);
		
		g.drawString(number3, 465, 320);
		 
		g.setColor(Color.BLUE);
		
		//g.fillRect(90, 280, 60,  2*10);
		g.fillRect(90, y1, 60,  height1);
		
		g.setColor(Color.GREEN);
		//g.fillRect(260, 230, 60,  7*10);
		g.fillRect(260, y2, 60,  height2);
		
		g.setColor(Color.RED);
		//g.fillRect(440, 270, 60,  3*10);
		g.fillRect(440, y3, 60,  height3);
		
		g.drawLine(50, 50, 50, 300);
		g.drawLine(50, 300, 550, 300);
	}

	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == bb) {
			int value = Integer.parseInt(b.getText().toString()); 
			height1 = value * 10;
			y1 = 300 - height1; 
			barB.setText(String.valueOf(value));
			number1 = barB.getText(); 
		}
		else if(source == gb) {
			int value = Integer.parseInt(g.getText().toString()); 
			height2 = value * 10; 
			y2 = 300 - height2; 
			barG.setText(String.valueOf(value));
			number2 = barG.getText(); 
		}
		else if(source == rb) {
			int value = Integer.parseInt(r.getText().toString()); 
			height3 = value * 10;
			y3 = 300 - height3; 
			barR.setText(String.valueOf(value));
			number3 = barR.getText(); 
		}
		repaint(); 
		
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Play With The Bar Graph!");
		frame.setSize(600, 400);

		// Creates window where program will run
		// Closes program when exited and restarts when run again
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		// adds program into the window
		Container contentPane = frame.getContentPane();
		contentPane.add(new Graph());

		frame.show();
	}
}
