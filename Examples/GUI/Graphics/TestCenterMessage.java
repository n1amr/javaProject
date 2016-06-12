import java.awt.*;

import javax.swing.*;

public class TestCenterMessage extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public TestCenterMessage() {
		CenterMessage messagePanel = new CenterMessage();
		add(messagePanel);
		messagePanel.setBackground(Color.WHITE);
		messagePanel.setFont(new Font("Californian FB", Font.BOLD, 30));
	}

	public static void main(String[] args) {
		TestCenterMessage frame = new TestCenterMessage();
		frame.setSize(400, 200);
		// frame.pack();
		frame.setTitle("TestFigurePanel");
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

class CenterMessage extends JPanel {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Override
	/** Paint the message */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// Get font metrics for the current font
		FontMetrics fm = g.getFontMetrics();

		// Find the center location to display
		int stringWidth = fm.stringWidth("Welcome to Java");
		int stringAscent = fm.getAscent();

		// Get the position of the leftmost character in the baseline
		int xCoordinate = getWidth() / 2 - stringWidth / 2;
		int yCoordinate = getHeight() / 2 + stringAscent / 2;

		g.drawString("Welcome to Java", xCoordinate, yCoordinate);
	}
}