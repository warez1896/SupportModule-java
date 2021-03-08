package custommodel;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class CustomTableModel extends AbstractTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Object[]> rows;
	private String[] headers;
	private int[] editableColumns = null;
	private Class<?>[] columnTypes = null;

	public void addRow(Object[] row) {
		rows.add(row);
		fireTableRowsInserted(rows.size() - 1, rows.size() - 1);
	}

	public void clear() {
		if (rows.size() > 0)
			fireTableRowsDeleted(0, rows.size() - 1);
		rows.clear();
	}

	public void setEditableColumns(int[] editableColumns, Class<?>[] columnTypes) {
		this.editableColumns = editableColumns;
		this.columnTypes = columnTypes;
	}

	public CustomTableModel(String[] headers, int[] editableColumns, Class<?>[] columnTypes) {
		// TODO Auto-generated constructor stub
		if ((editableColumns != null && columnTypes != null) && (editableColumns.length != columnTypes.length))
			throw new IllegalArgumentException("Editable columns require explicit data types");
		rows = new ArrayList<>();
		this.setEditableColumns(editableColumns, columnTypes);
		this.headers = headers;
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		// TODO Auto-generated method stub
		if (this.editableColumns != null && this.columnTypes != null) {
			for (int i = 0; i < editableColumns.length; i++) {
				if (editableColumns[i] == columnIndex)
					return columnTypes[i];
			}
		}
		return super.getColumnClass(columnIndex);
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return headers.length;
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return headers[column];
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return rows.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		if (rowIndex > -1)
			return rows.get(rowIndex)[columnIndex];
		else
			return null;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		if (rowIndex > -1) {
			rows.get(rowIndex)[columnIndex] = aValue;
//			System.out.println(columnIndex);
			fireTableCellUpdated(rowIndex, columnIndex);
		}
	}

	public int getID(int row) {
		return Integer.parseInt(rows.get(row)[0].toString());
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		if (this.editableColumns != null) {
			for (int col : this.editableColumns) {
				if (col == columnIndex)
					return true;
			}
		}
		return false;
	}
}
