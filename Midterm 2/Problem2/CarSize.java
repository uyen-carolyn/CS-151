import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class CarSize extends JPanel implements ChangeListener {

	private int x;
	private int y; 
	private int width; 
	private JSlider slider; 
	
	public CarSize()  {
		slider = new JSlider(); 
		slider.setMajorTickSpacing(10);
		slider.setMinorTickSpacing(10);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true); 
		
		x = 150;
		y = 150; 
		width = 50; // size of car initialized at 50 for width
		            // car placement and dimensions depend on width value
                
		add(slider); 
		slider.addChangeListener(this); 
		setVisible(true); 
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		// bottom of car
		g.setColor(Color.red);
		g.fillRect(x, y + width / 6, 
		           width - 1, width / 6);
		// wheels
		g.setColor(Color.black); 
		g.fillOval(x + width / 6, y + width / 3, 
		           width / 6, width / 6);
		g.setColor(Color.black); 
		g.fillOval(x + width * 2 / 3, 
		           y + width / 3,
		           width / 6, width / 6);
		//top of car
		g.setColor(Color.red);
		g.fillRect(x + (width / 4), y + width / 24, 
        width / 2, width / 4);
	}
	
	public void stateChanged(ChangeEvent e) {
		JSlider source = (JSlider)e.getSource(); 
         int val = source.getValue();  // get slider value
         width = val; // resizing to value on slider
         repaint();
	}
	
	public static void main(String[] args) {
		JFrame frame = new JFrame("Change the Car's Size!");
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
		contentPane.add(new CarSize());

		frame.show();
	}
}
