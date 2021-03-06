import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ComboBoxDemo extends JFrame {
  /**
   *
   */
  private static final long serialVersionUID = 1L;

  // Declare an array of Strings for flag titles
  private String[] flagTitles = {"Canada", "China", "Denmark", "France", "Germany", "India", "Norway",
      "United Kingdom", "United States of America"};

  // Declare an ImageIcon array for the national flags of 9 countries
  private ImageIcon[] flagImage = {new ImageIcon("image/ca.gif"), new ImageIcon("image/china.gif"),
      new ImageIcon("image/denmark.gif"), new ImageIcon("image/fr.gif"), new ImageIcon("image/germany.gif"),
      new ImageIcon("image/india.gif"), new ImageIcon("image/norway.gif"), new ImageIcon("image/uk.gif"),
      new ImageIcon("image/us.gif")};

  // Declare an array of strings for flag descriptions
  private String[] flagDescription = new String[9];

  // Declare and create a description panel
  private DescriptionPanel descriptionPanel = new DescriptionPanel();

  // Create a combo box for selecting countries
  private JComboBox jcbo = new JComboBox(flagTitles);

  public static void main(String[] args) {
    ComboBoxDemo frame = new ComboBoxDemo();
    frame.pack();
    frame.setTitle("ComboBoxDemo");
    frame.setLocationRelativeTo(null); // Center the frame
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }

  public ComboBoxDemo() {
    // Set text description
    flagDescription[0] = "The Canadian national flag ...";
    flagDescription[1] = "Description for China ... ";
    flagDescription[2] = "Description for Denmark ... ";
    flagDescription[3] = "Description for France ... ";
    flagDescription[4] = "Description for Germany ... ";
    flagDescription[5] = "Description for India ... ";
    flagDescription[6] = "Description for Norway ... ";
    flagDescription[7] = "Description for UK ... ";
    flagDescription[8] = "Description for US ... ";

    // Set the first country (Canada) for display
    setDisplay(0);

    // Add combo box and description panel to the frame
    add(jcbo, BorderLayout.NORTH);
    add(descriptionPanel, BorderLayout.CENTER);

    // Register listener
    jcbo.addItemListener(new ItemListener() {
      @Override
      /** Handle item selection */
      public void itemStateChanged(ItemEvent e) {
        setDisplay(jcbo.getSelectedIndex());
      }
    });
  }

  /**
   * Set display information on the description panel
   */
  public void setDisplay(int index) {
    descriptionPanel.setTitle(flagTitles[index]);
    descriptionPanel.setImageIcon(flagImage[index]);
    descriptionPanel.setDescription(flagDescription[index]);
  }
}
