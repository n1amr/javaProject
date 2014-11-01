import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.border.Border;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

public class ShowBorderLayout extends JFrame {
	static ShowBorderLayout frame;

	public ShowBorderLayout() {
		// Set FlowLayout, aligned left with horizontal gap 10
		// and vertical gap 20 between components
		setLayout(new BorderLayout(5, 5));

		// Add labels and text fields to the frame
		add(new JButton("NORTH"), BorderLayout.NORTH);
		add(new JButton("SOUTH"), BorderLayout.SOUTH);
		//add(new JButton("CENTER"), BorderLayout.CENTER);
		add(new JButton("EAST"), BorderLayout.EAST);
		add(new JButton("WEST"), BorderLayout.WEST);

		JPanel jPanel = new JPanel(new GridLayout(0, 2));
		jPanel.add(new JLabel("First Name"));
		jPanel.add(new JTextField(8));
		jPanel.add(new JLabel("MI"));
		jPanel.add(new JTextField(1));
		jPanel.add(new JLabel("Last Name"));
		jPanel.add(new JTextField(8));
		add(jPanel, BorderLayout.CENTER);

	}

	/** Main method */
	public static void main(String[] args) {
		frame = new ShowBorderLayout();
		showFrame();
	}

	private static void showFrame() {
		frame.setTitle("ShowFlowLayout");
		frame.setSize(200, 125);
		frame.pack();
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}