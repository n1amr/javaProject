import java.io.File;

import javax.swing.JApplet;
import javax.swing.JLabel;

public class SignedAppletDemo extends JApplet {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public SignedAppletDemo() {
		JLabel label = new JLabel();
		add(label);
		try {
			File file = new File(".");
			label.setText("The current directory is " + file.getAbsolutePath());
		} catch (Exception ex) {
			ex.printStackTrace();
			label.setText("Security exception ");
		}
	}
}