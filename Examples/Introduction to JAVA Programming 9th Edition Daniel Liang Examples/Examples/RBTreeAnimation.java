import javax.swing.*;

public class RBTreeAnimation extends JApplet {
  /**
   *
   */
  private static final long serialVersionUID = 1L;

  public RBTreeAnimation() {
    RBTree<Integer> tree = new RBTree<Integer>();
    add(new RBTreeView(tree));
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("RBTreeAnimation");
    JApplet applet = new RBTreeAnimation();
    frame.add(applet);
    frame.setSize(500, 300);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
  }
}