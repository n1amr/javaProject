import java.awt.*;

import javax.swing.*;

public class TestPaintComponent extends JFrame {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public TestPaintComponent() {
		add(new NewPanel());
	}

	public static void main(String[] args) {
		TestPaintComponent frame = new TestPaintComponent();
		frame.setTitle("TestPaintComponent");
		frame.setSize(400, 200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

class NewPanel extends JPanel {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.fillRect(0, 0, getWidth(), getHeight());

		g.setColor(Color.WHITE);
		g.drawLine(0, 0, 50, 50);
		g.drawString("hello", 0, 40);
		g.fillOval(45, 45, 30, 30);

	}
}
