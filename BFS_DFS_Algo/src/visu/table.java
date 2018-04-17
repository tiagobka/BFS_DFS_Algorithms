package visu;

import java.awt.Component;
import java.awt.Desktop.Action;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

import javax.swing.AbstractAction;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class table extends JTable
{
 private int row;
 private int col;
 private square[][] s;
 private TableCellRenderer customRenderer;
 public DefaultTableModel model;



	public table(int dim){
		this.setColumnSelectionAllowed(false);
		this.setRowSelectionAllowed(false);
		
		this.setCellSelectionEnabled(false);
	
		this.setRowHeight(550/dim);
		//this.setDefaultRenderer(Object.class, new MyRenderer());
		
		
		
		model = new DefaultTableModel();
		
		
		row = dim;
		col = dim;
		s = new square[dim][dim];
		Vector v = new Vector();
		
		
		for (int i = 0; i <dim; i++){
			v.add(i);
		}

		model.setNumRows(dim);
		model.setColumnIdentifiers(v);
		
		
		//System.out.println(model.getColumnCount());
		
		//super.getCellRenderer(dim, column)
		model.isCellEditable(2, 2);

		
		
		this.setModel(model);
		
		//random generator of 1 or ""
		for (int r = 0 ; r < dim ; r++){
			for (int c = 0 ; c < dim ; c++){
				
				s[r][c] = new square(r ,c , Color.WHITE);
				
				//String val	= ((int) (Math.random() *2) == 1)? "1": "";				
				if ((int) (Math.random() *2) == 1){
					model.setValueAt(1, r, c);
					s[r][c].setColor(Color.LIGHT_GRAY);
					s[r][c].setValue(1);
				}
			}
		}
		
		TableCellRenderer renderer = this.getDefaultRenderer(Object.class);
		customRenderer = new MyRenderer(renderer,s);
		this.setDefaultRenderer(Object.class, customRenderer );
		//colorSet(0 ,0 , Color.red);
		
		
		 
	}
	
	public square[][] getS() {
		return s;
	}

	public void setS(square[][] s) {
		this.s = s;
	}

	public boolean isCellEditable(int row, int column) {
		return false;
	
	}
	public void colorSet(int r, int c, Color cor ) {
		this.getS()[r][c].setColor(cor);
		//s[r][c].setColor();
		//model.fireTableCellUpdated(1, 1);
				
		//System.out.println("colorset" + r + " " + c + " " + cor);
		customRenderer.getTableCellRendererComponent(this, "" , true, true, r, c);
		//model.fireTableDataChanged();
		this.model.fireTableDataChanged();
		this.setModel(model);
		
		//this.setVisible(false);
		
	

	}
		

	
}