import javax.swing.*;
import java.awt.*;

public class ShowFlowLayout extends JFrame {
  /**
   *
   */
  private static final long serialVersionUID = 1L;
  static ShowFlowLayout frame;

  public ShowFlowLayout() {
    // Set FlowLayout, aligned left with horizontal gap 10
    // and vertical gap 20 between components
    setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));

    // Add labels and text fields to the frame
    add(new JLabel("First Name"));
    add(new JTextField(8));
    add(new JLabel("MI"));
    add(new JTextField(1));
    add(new JLabel("Last Name"));
    add(new JTextField(8));
  }

  /**
   * Main method
   */
  public static void main(String[] args) {
    frame = new ShowFlowLayout();
    showFrame();
  }

  private static void showFrame() {
    frame.setTitle("ShowFlowLayout");
    frame.setSize(200, 200);
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}