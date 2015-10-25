import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class DisplayLabel extends JApplet {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public DisplayLabel() {
	add(new JLabel("Great!", SwingConstants.CENTER));
    }

    public static void main(String[] args) {
	// Create a frame
	JFrame frame = new JFrame("Applet is in the frame");

	// Create an instance of the applet
	DisplayLabel applet = new DisplayLabel();

	// Add the applet to the frame
	frame.add(applet);

	// Display the frame
	frame.setSize(300, 100);
	frame.setLocationRelativeTo(null); // Center the frame
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
    }
}
