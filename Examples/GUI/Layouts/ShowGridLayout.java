import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFrame;

import java.awt.FlowLayout;
import java.awt.GridLayout;

public class ShowGridLayout extends JFrame {
	static ShowGridLayout frame;

	public ShowGridLayout() {
		// Set FlowLayout, aligned left with horizontal gap 10
		// and vertical gap 20 between components
		setLayout(new GridLayout(0,2, 5, 5));

		// Add labels and text fields to the frame
		add(new JLabel("First Name"));
		add(new JTextField(8));
		add(new JLabel("MI"));
		add(new JTextField(1));
		add(new JLabel("Last Name"));
		add(new JTextField(8));
	}

	/** Main method */
	public static void main(String[] args) {
		frame = new ShowGridLayout();
		showFrame();
	}

	private static void showFrame() {
		frame.setTitle("ShowFlowLayout");
		frame.setSize(200, 125);
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}