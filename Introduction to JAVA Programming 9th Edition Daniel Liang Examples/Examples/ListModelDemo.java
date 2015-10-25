import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ListModelDemo extends JApplet {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private DefaultListModel<String> listModel = new DefaultListModel<String>();
    private JList<String> jlst = new JList<String>(listModel);
    private JButton jbtAdd = new JButton("Add new item");
    private JButton jbtRemove = new JButton("Remove selected item");

    /** Construct the applet */
    public ListModelDemo() {
	// Add items to the list model
	listModel.addElement("Item1");
	listModel.addElement("Item2");
	listModel.addElement("Item3");
	listModel.addElement("Item4");
	listModel.addElement("Item5");
	listModel.addElement("Item6");

	JPanel panel = new JPanel();
	panel.add(jbtAdd);
	panel.add(jbtRemove);

	add(panel, BorderLayout.NORTH);
	add(new JScrollPane(jlst), BorderLayout.CENTER);

	// Register listeners
	jbtAdd.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		String newItem = JOptionPane.showInputDialog("Enter a new item");

		if (newItem != null)
		    if (jlst.getSelectedIndex() == -1)
			listModel.addElement(newItem);
		    else
			listModel.add(jlst.getSelectedIndex(), newItem);
	    }
	});

	jbtRemove.addActionListener(new ActionListener() {
	    @Override
	    public void actionPerformed(ActionEvent e) {
		listModel.remove(jlst.getSelectedIndex());
	    }
	});
    }

    public static void main(String[] args) {
	ListModelDemo applet = new ListModelDemo();
	JFrame frame = new JFrame();
	// EXIT_ON_CLOSE == 3
	frame.setDefaultCloseOperation(3);
	frame.setTitle("ListModelDemo");
	frame.getContentPane().add(applet, BorderLayout.CENTER);
	applet.init();
	applet.start();
	frame.setSize(400, 320);
	frame.setLocationRelativeTo(null);
	frame.setVisible(true);
    }
}
