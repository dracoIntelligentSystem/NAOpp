package table;

import javax.swing.table.AbstractTableModel;

public class MyTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String[] columnNames;
	private Object[][] data;  
	
	public MyTableModel(String[] columnsName, Object[][] content) {
		this.columnNames=columnsName;
		this.data=content;
	}
	@Override
	public int getRowCount() {
		return data.length;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return data[rowIndex][columnIndex];
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}
	
	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}
	
	@Override
	public int findColumn(String columnName) {
		return super.findColumn(columnName);
	}
}
