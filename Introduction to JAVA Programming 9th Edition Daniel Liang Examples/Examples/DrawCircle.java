import java.awt.Graphics;

import javax.swing.JApplet;

public class DrawCircle extends JApplet {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Override
    public void paint(Graphics g) {
	g.drawOval(10, 10, 100, 100);
    }
}
