import java.awt.BorderLayout;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ControlCircleWithoutEventHandling extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private JButton jbtEnlarge = new JButton("Enlarge");
	private JButton jbtShrink = new JButton("Shrink");
	private CirclePanel canvas = new CirclePanel();

	public ControlCircleWithoutEventHandling() {
		JPanel panel = new JPanel(); // Use the panel to group buttons
		panel.add(jbtEnlarge);
		panel.add(jbtShrink);

		this.add(canvas, BorderLayout.CENTER); // Add canvas to center
		this.add(panel, BorderLayout.SOUTH); // Add buttons to the frame
	}

	/**
	 * Main method
	 */
	public static void main(String[] args) {
		JFrame frame = new ControlCircleWithoutEventHandling();
		frame.setTitle("ControlCircleWithoutEventHandling");
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(200, 200);
		frame.setVisible(true);
	}
}

class CirclePanel extends JPanel {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private int radius = 5; // Default circle radius

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawOval(getWidth() / 2 - radius, getHeight() / 2 - radius, 2 * radius, 2 * radius);
	}
}
