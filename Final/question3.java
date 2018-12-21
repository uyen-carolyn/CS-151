import java.awt.*;

import javax.swing.*;

/**
 * This program implements an animation that moves a car shape.
 */
public class question3 {
	public static void main(String[] args) {
		JFrame frame = new JFrame();

		final MoveableShape shape1 = new CarShape(0, 0, CAR_WIDTH);

		final MoveableShape shape2 = new CarShape(0, 25, CAR_WIDTH);

		final MoveableShape shape3 = new CarShape(0, 50, CAR_WIDTH);

		ShapeIcon icon1 = new ShapeIcon(shape1, ICON_WIDTH, ICON_HEIGHT);

		ShapeIcon icon2 = new ShapeIcon(shape2, ICON_WIDTH, ICON_HEIGHT);

		ShapeIcon icon3 = new ShapeIcon(shape3, ICON_WIDTH, ICON_HEIGHT);

		final JLabel label1 = new JLabel(icon1);
		final JLabel label2 = new JLabel(icon2);
		final JLabel label3 = new JLabel(icon3);

		frame.setLayout(new FlowLayout());
		frame.add(label1);
		frame.add(label2);
		frame.add(label3);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

		Thread paintThread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					shape1.move();
					frame.repaint();
					try {
						Thread.sleep(150);// determines how slow the ovals will move
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		Thread paintThread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					shape2.move();
					frame.repaint();
					try {
						Thread.sleep(20);// determines how slow the ovals will move
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});

		Thread paintThread3 = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					shape3.move();
					frame.repaint();
					try {
						Thread.sleep(10);// determines how slow the ovals will move
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		paintThread1.start();// start the animation
		paintThread2.start();
		paintThread3.start();

	}

	private static final int ICON_WIDTH = 400;
	private static final int ICON_HEIGHT = 100;
	private static final int CAR_WIDTH = 100;
}