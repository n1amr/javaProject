import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.*;

public class HandleEvent extends JFrame {
	JButton jbtnOK = new JButton("OK");
	JButton jbtnCancel = new JButton("Cancel");
	JCheckBox jchkChoose = new JCheckBox("Choose");

	public HandleEvent() {

		JPanel panel = new JPanel();
		panel.add(jbtnOK);
		panel.add(jbtnCancel);
		panel.add(jchkChoose);

		this.add(panel);

		jbtnOK.addActionListener(new ActionListenerTest());
		jbtnCancel.addActionListener(new ActionListenerTest());

		jbtnOK.addMouseListener(new MouseListenerTest());
		jbtnOK.addKeyListener(new KeyListenerTest());

		jchkChoose.addItemListener(new ItemListenerTest());
	}

	public static void main(String[] args) {
		HandleEvent frame = new HandleEvent();
		frame.setTitle("Handle Event");
		frame.setSize(200, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	private class ActionListenerTest implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() instanceof JButton) {

				System.out.println("actionPerformed: "
						+ ((JButton) e.getSource()).getText());
			}
			if (jbtnOK == e.getSource()) {
				Calendar time = new GregorianCalendar();
				time.setTimeInMillis(e.getWhen());
				System.out.println(time.getTime().toString());
			} else if (jbtnCancel == e.getSource()) {
			}
		}
	}

	private class MouseListenerTest implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println("mouseClicked");
		}

		@Override
		public void mousePressed(MouseEvent e) {
			System.out.println("mousePressed");
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			System.out.println("mouseReleased");
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			System.out.println("mouseEntered");
		}

		@Override
		public void mouseExited(MouseEvent e) {
			System.out.println("mouseExited");
		}

	}

	private class KeyListenerTest implements KeyListener {
		@Override
		public void keyTyped(KeyEvent e) {
			System.out.println("keyTyped: " + e.getKeyChar());
		}

		@Override
		public void keyPressed(KeyEvent e) {
			System.out.println("keyPressed: " + e.getKeyChar());
			if (e.getKeyCode() == KeyEvent.VK_UP)
				System.out.println("UP");
		}

		@Override
		public void keyReleased(KeyEvent e) {
			System.out.println("keyReleased: " + e.getKeyChar());
		}
	}

	private class ItemListenerTest implements ItemListener {
		@Override
		public void itemStateChanged(ItemEvent e) {
			System.out.println("itemStateChanged: Check box state is "
					+ ((JCheckBox) e.getSource()).isSelected());
		}
	}
}
