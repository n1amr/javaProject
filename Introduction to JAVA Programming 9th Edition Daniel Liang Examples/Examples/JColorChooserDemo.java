import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JColorChooser;
import javax.swing.JFrame;

public class JColorChooserDemo extends javax.swing.JApplet {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void init() {
		JColorChooser.showDialog(this, "Choose a color", Color.YELLOW);
	}

	public static void main(String[] args) {
		JColorChooserDemo applet = new JColorChooserDemo();
		JFrame frame = new JFrame();
		// EXIT_ON_CLOSE == 3
		frame.setDefaultCloseOperation(3);
		frame.setTitle("TestColorDialog");
		frame.getContentPane().add(applet, BorderLayout.CENTER);
		applet.init();
		applet.start();
		frame.setSize(400, 320);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((d.width - frame.getSize().width) / 2, (d.height - frame.getSize().height) / 2);
		frame.setVisible(true);
	}
}
