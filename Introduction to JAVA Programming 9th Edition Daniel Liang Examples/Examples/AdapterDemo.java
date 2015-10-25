import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class AdapterDemo extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
	AdapterDemo frame = new AdapterDemo();
	frame.setLocationRelativeTo(null); // Center the frame
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setTitle("AdapterDemo");
	frame.setSize(220, 80);
	frame.setVisible(true);
    }

    public AdapterDemo() {
	addWindowListener(new WindowAdapter() {
	    @Override
	    public void windowActivated(WindowEvent event) {
		System.out.println("Window activated");
	    }
	});
    }
}
