import javax.swing.JApplet;
import javax.swing.JFrame;

public class DisplayBST extends JApplet {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public DisplayBST() {
	add(new TreeControl(new BST<Integer>()));
    }

    public static void main(String[] args) {
	JFrame frame = new JFrame("DisplayBST");
	JApplet applet = new DisplayBST();
	frame.add(applet);
	frame.setSize(500, 300);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLocationRelativeTo(null);
	frame.setVisible(true);
    }
}