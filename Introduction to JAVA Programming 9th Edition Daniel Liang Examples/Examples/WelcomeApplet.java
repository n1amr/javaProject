// WelcomeApplet.java: Applet for displaying a message

import javax.swing.*;

public class WelcomeApplet extends JApplet {
  /**
   *
   */
  private static final long serialVersionUID = 1L;

  /**
   * Initialize the applet
   */
  @Override
  public void init() {
    add(new JLabel("Welcome to Java", SwingConstants.CENTER));
  }
}
