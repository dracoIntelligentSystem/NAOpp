package table;

import java.awt.Component;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class CustomRenderer extends DefaultTableCellRenderer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Component getTableCellRendererComponent(
	        JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column)
	    {
			this.setBorder(noFocusBorder);
	        return super.getTableCellRendererComponent(table, value, isSelected, false, row, column);
	        
	        //return this;
	    }
}
