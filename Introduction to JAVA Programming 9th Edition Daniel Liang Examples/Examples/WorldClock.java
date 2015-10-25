import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class WorldClock extends JPanel {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private TimeZone timeZone = TimeZone.getTimeZone("EST");
    private Timer timer = new Timer(1000, new TimerListener());
    private StillClock clock = new StillClock();
    private JLabel jlblDigitTime = new JLabel("", JLabel.CENTER);

    public WorldClock() {
	setLayout(new BorderLayout());
	add(clock, BorderLayout.CENTER);
	add(jlblDigitTime, BorderLayout.SOUTH);
	timer.start();
    }

    public void setTimeZone(TimeZone timeZone) {
	this.timeZone = timeZone;
    }

    private class TimerListener implements ActionListener {
	@Override
	public void actionPerformed(ActionEvent e) {
	    Calendar calendar = new GregorianCalendar(timeZone, getLocale());
	    clock.setHour(calendar.get(Calendar.HOUR));
	    clock.setMinute(calendar.get(Calendar.MINUTE));
	    clock.setSecond(calendar.get(Calendar.SECOND));

	    // Display digit time on the label
	    DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.LONG, getLocale());
	    formatter.setTimeZone(timeZone);
	    jlblDigitTime.setText(formatter.format(calendar.getTime()));
	}
    }
}
