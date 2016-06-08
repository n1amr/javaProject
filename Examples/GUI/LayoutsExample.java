import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class LayoutsExample extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public LayoutsExample() {

		JPanel panelNumbers = new JPanel(new GridLayout(0, 3));
		JButton[] jbtnNumbers = new JButton[12];
		String[] sButtonLabels = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "Start", "Stop"};
		for (int i = 0; i < sButtonLabels.length; i++) {
			jbtnNumbers[i] = new JButton(sButtonLabels[i]);
			jbtnNumbers[i].setBackground(new Color(i * 5 + 200, 0, 0));
			panelNumbers.add(jbtnNumbers[i]);
		}

		JPanel panelPad = new JPanel(new BorderLayout());
		panelPad.setBorder(new TitledBorder("Numbers"));
		JTextField field = new JTextField("");
		field.setToolTipText("Time to be displayed here");
		field.setBorder(new LineBorder(Color.YELLOW));
		field.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
		Font font = new Font("Comic Sans MS", Font.BOLD + Font.ITALIC, 16);
		field.setFont(font);
		panelPad.add(field, BorderLayout.NORTH);
		panelPad.add(panelNumbers, BorderLayout.CENTER);

		setLayout(new BorderLayout());
		this.add(new JLabel("Food to be placed here"), BorderLayout.CENTER);
		this.add(panelPad, BorderLayout.EAST);
	}

	public static void main(String[] args) {
		LayoutsExample example = new LayoutsExample();
		example.setTitle("The Front View of a Microwave Oven");
		example.pack();
		example.setSize(400, 250);
		example.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		example.setLocationRelativeTo(null);
		example.setVisible(true);

		// Get All Fonts
		GraphicsEnvironment mGraphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		String[] fontnames = mGraphicsEnvironment.getAvailableFontFamilyNames();
		for (int i = 0; i < fontnames.length; i++)
			System.out.println(fontnames[i]);
	}
}
