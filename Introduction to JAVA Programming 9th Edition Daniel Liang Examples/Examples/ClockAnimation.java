import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;

public class ClockAnimation extends JFrame {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private StillClock clock = new StillClock();

    public ClockAnimation() {
	add(clock);

	// Create a timer with delay 1000 ms
	Timer timer = new Timer(1000, new TimerListener());
	timer.start();
    }

    private class TimerListener implements ActionListener {
	@Override /** Handle the action event */
	public void actionPerformed(ActionEvent e) {
	    // Set new time and repaint the clock to display current time
	    clock.setCurrentTime();
	    clock.repaint();
	}
    }

    /** Main method */
    public static void main(String[] args) {
	JFrame frame = new ClockAnimation();
	frame.setTitle("ClockAnimation");
	frame.setSize(200, 200);
	frame.setLocationRelativeTo(null); // Center the frame
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setVisible(true);
    }
}
