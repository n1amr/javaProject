import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class MyImageCellRenderer extends DefaultTableCellRenderer {
  /**
   *
   */
  private static final long serialVersionUID = 1L;

  /**
   * Override this method in DefaultTableCellRenderer
   */
  @Override
  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean isFocused,
                                                 int row, int column) {
    Image image = ((ImageIcon) value).getImage();
    ImageViewer imageViewer = new ImageViewer(image);

    return imageViewer;
  }
}
