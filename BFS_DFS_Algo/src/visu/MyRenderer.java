package visu;

import java.awt.Color;
import java.awt.Component;
import java.util.concurrent.TimeUnit;

import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

//DO NOT TOUCH!
public class MyRenderer implements TableCellRenderer//, Runnable
 {
	private TableCellRenderer delegate;
	private Component c;
	private square [][] s;
	
	public MyRenderer(TableCellRenderer defaultRenderer , square [][] array)
	  {
	    this.delegate = defaultRenderer;
	    this.s = array;

	  }

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) 
	{

		c = delegate.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		c.setBackground(s[row][column].getColor());
		
		return c;
	}

	
	
}
