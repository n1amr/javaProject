import java.awt.Color;
import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.border.Border;

public class MyListCellRenderer implements ListCellRenderer {
	private JLabel jlblCell = new JLabel(" ", JLabel.LEFT);
	private Border lineBorder = BorderFactory.createLineBorder(Color.black, 1);
	private Border emptyBorder = BorderFactory.createEmptyBorder(2, 2, 2, 2);

	/**
	 * Implement this method in ListCellRenderer
	 */
	public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected,
	                                              boolean cellHasFocus) {
		Object[] pair = (Object[]) value; // Cast value into an array
		jlblCell.setOpaque(true);
		jlblCell.setIcon((ImageIcon) pair[0]);
		jlblCell.setText(pair[1].toString());

		if (isSelected) {
			jlblCell.setForeground(list.getSelectionForeground());
			jlblCell.setBackground(list.getSelectionBackground());
		} else {
			jlblCell.setForeground(list.getForeground());
			jlblCell.setBackground(list.getBackground());
		}

		jlblCell.setBorder(cellHasFocus ? lineBorder : emptyBorder);

		return jlblCell;
	}
}
