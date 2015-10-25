import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Path2DDemo extends JApplet {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public Path2DDemo() {
	add(new ShapePanel());
    }

    class ShapePanel extends JPanel {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g);

	    Graphics2D g2d = (Graphics2D) g;
	    Path2D path = new Path2D.Double();
	    path.moveTo(100, 100);
	    path.curveTo(150, 50, 250, 150, 300, 100);
	    path.moveTo(100, 100);
	    path.curveTo(150, 150, 250, 50, 300, 100);
	    path.lineTo(200, 20);
	    path.closePath();

	    g2d.draw(path);
	}
    }

    /** Main method */
    public static void main(String[] args) {
	JApplet applet = new Path2DDemo();
	applet.init();
	applet.start();
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setTitle("Path2DDemo");
	frame.getContentPane().add(applet, BorderLayout.CENTER);
	frame.setSize(400, 150);
	frame.setVisible(true);
    }
}
