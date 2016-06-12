import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Graphics2DDemo extends JApplet {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public Graphics2DDemo() {
		add(new ShapePanel());
	}

	static class ShapePanel extends JPanel {
		/**
		 *
		 */
		private static final long serialVersionUID = 1L;

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);

			Graphics2D g2d = (Graphics2D) g;

			g2d.draw(new Line2D.Double(10, 10, 40, 80));
			g2d.draw(new Rectangle2D.Double(50, 10, 30, 70));
			g2d.fill(new Rectangle2D.Double(90, 10, 30, 70));
			g2d.fill(new RoundRectangle2D.Double(130, 10, 30, 70, 20, 30));
			g2d.draw(new Ellipse2D.Double(170, 10, 30, 70));
			g2d.draw(new Arc2D.Double(220, 10, 30, 70, 0, 270, Arc2D.OPEN));
			g2d.draw(new Arc2D.Double(260, 10, 30, 70, 0, 270, Arc2D.PIE));
			g2d.draw(new Arc2D.Double(300, 10, 30, 70, 0, 270, Arc2D.CHORD));
		}
	}

	/**
	 * Main method
	 */
	public static void main(String[] args) {
		Graphics2DDemo applet = new Graphics2DDemo();
		applet.init();
		applet.start();
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Graphics2DDemo");
		frame.getContentPane().add(applet, BorderLayout.CENTER);
		frame.setSize(400, 130);
		frame.setVisible(true);
	}
}
