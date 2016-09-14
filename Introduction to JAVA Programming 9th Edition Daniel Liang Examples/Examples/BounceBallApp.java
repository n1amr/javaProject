import javax.swing.*;
import java.awt.*;

public class BounceBallApp extends JApplet {
  /**
   *
   */
  private static final long serialVersionUID = 1L;

  public BounceBallApp() {
    add(new BallControl());
  }

  public static void main(String[] args) {
    BounceBallApp applet = new BounceBallApp();
    JFrame frame = new JFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setTitle("BounceBallApp");
    frame.add(applet, BorderLayout.CENTER);
    frame.setSize(400, 320);
    frame.setVisible(true);
  }
}
