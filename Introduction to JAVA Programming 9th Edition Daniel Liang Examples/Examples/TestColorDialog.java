import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;

public class TestColorDialog extends JApplet {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private ColorDialog colorDialog1 = new ColorDialog();
	private JButton jbtChangeColor = new JButton("Choose color");

	public TestColorDialog() {
		setLayout(new java.awt.FlowLayout());
		jbtChangeColor.setText("Change Button Text Color");
		jbtChangeColor.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				colorDialog1.setVisible(true);

				if (colorDialog1.getColor() != null)
					jbtChangeColor.setForeground(colorDialog1.getColor());
			}
		});
		add(jbtChangeColor);
	}

	public static void main(String[] args) {
		TestColorDialog applet = new TestColorDialog();
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
