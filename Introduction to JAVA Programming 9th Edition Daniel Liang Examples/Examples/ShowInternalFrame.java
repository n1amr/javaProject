import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ShowInternalFrame extends JApplet {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	// Create image icons
	private ImageIcon USIcon = new ImageIcon(getClass().getResource("/image/usIcon.gif"));
	private ImageIcon CanadaIcon = new ImageIcon(getClass().getResource("/image/caIcon.gif"));

	private JMenuBar jMenuBar1 = new JMenuBar();
	private JMenuItem jmiUS = new JMenuItem("US");
	private JMenuItem jmiCanada = new JMenuItem("Canada");
	private JLabel jlblImage = new JLabel(USIcon, JLabel.CENTER);

	// Create JDesktopPane to hold the internal frame
	private JDesktopPane desktop = new JDesktopPane();
	private JInternalFrame internalFrame = new JInternalFrame("US", true, true, true, true);

	public ShowInternalFrame() {
		desktop.add(internalFrame);

		this.setSize(new Dimension(400, 300));
		getContentPane().add(desktop, BorderLayout.CENTER);

		jlblImage.setIcon(USIcon);
		internalFrame.setFrameIcon(USIcon);

		internalFrame.add(jlblImage);
		internalFrame.setLocation(20, 20);
		internalFrame.setSize(100, 100);
		internalFrame.setVisible(true);

		JMenu jMenu1 = new JMenu("Flags");
		jMenuBar1.add(jMenu1);
		jMenu1.add(jmiUS);
		jMenu1.add(jmiCanada);

		setJMenuBar(jMenuBar1);

		jmiUS.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jlblImage.setIcon(USIcon);
				internalFrame.setFrameIcon(USIcon);
				internalFrame.setTitle("US");
			}
		});

		jmiCanada.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jlblImage.setIcon(CanadaIcon);
				internalFrame.setFrameIcon(CanadaIcon);
				internalFrame.setTitle("Canada");
			}
		});
	}

	public static void main(String[] args) {
		ShowInternalFrame applet = new ShowInternalFrame();
		JFrame frame = new JFrame();
		// EXIT_ON_CLOSE == 3
		frame.setDefaultCloseOperation(3);
		frame.setTitle("ShowInternalFrame");
		frame.getContentPane().add(applet, BorderLayout.CENTER);
		applet.init();
		applet.start();
		frame.setSize(400, 320);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation((d.width - frame.getSize().width) / 2, (d.height - frame.getSize().height) / 2);
		frame.setVisible(true);
	}
}
