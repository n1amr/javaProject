import java.awt.Component;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class MyImageCellRenderer extends DefaultTableCellRenderer {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /** Override this method in DefaultTableCellRenderer */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean isFocused,
	    int row, int column) {
	Image image = ((ImageIcon) value).getImage();
	ImageViewer imageViewer = new ImageViewer(image);

	return imageViewer;
    }
}
