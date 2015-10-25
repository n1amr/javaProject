import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ControlCircle extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JButton jbtEnlarge = new JButton("Enlarge");
    private JButton jbtShrink = new JButton("Shrink");
    private CirclePanel canvas = new CirclePanel();

    public ControlCircle() {
	JPanel panel = new JPanel(); // Use the panel to group buttons
	panel.add(jbtEnlarge);
	panel.add(jbtShrink);

	this.add(canvas, BorderLayout.CENTER); // Add canvas to center
	this.add(panel, BorderLayout.SOUTH); // Add buttons to the frame

	jbtEnlarge.addActionListener(new EnlargeListener());
    }

    /** Main method */
    public static void main(String[] args) {
	JFrame frame = new ControlCircle();
	frame.setTitle("ControlCircle");
	frame.setLocationRelativeTo(null); // Center the frame
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(200, 200);
	frame.setVisible(true);
    }

    class EnlargeListener implements ActionListener { // Inner class
	@Override
	public void actionPerformed(ActionEvent e) {
	    canvas.enlarge();
	}
    }

    class CirclePanel extends JPanel { // Inner class
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private int radius = 5; // Default circle radius

	/** Enlarge the circle */
	public void enlarge() {
	    radius++;
	    repaint();
	}

	@Override
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    g.drawOval(getWidth() / 2 - radius, getHeight() / 2 - radius, 2 * radius, 2 * radius);
	}
    }
}
