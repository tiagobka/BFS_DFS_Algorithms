package visu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;

import java.awt.GridBagLayout;
import java.awt.GridLayout;

import net.miginfocom.swing.MigLayout;

import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import algorithms.BreadthFirst;
import algorithms.DepthFirst;
import algorithms.Labelling;

import javax.swing.JEditorPane;

import java.awt.GridBagConstraints;
import java.awt.FlowLayout;
import java.awt.Color;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.SwingConstants;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.util.concurrent.TimeUnit;

import javax.swing.JCheckBox;
import javax.swing.JButton;

import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.ScrollPane;
import java.awt.Checkbox;

import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBoxMenuItem;

import structures.Queue;
import structures.Stack;

/***************************************************
 *   BFS- DFS Algorithms 
 *  launcher.java 
 *  Purpose: UI for algorithm demonstration
 *
 *  @author Tiago B. Dos Anjos
 *  @version 1.0 4/16/18 
 ****************************************************/
public class Launcher {

	private JFrame frmJFrame1;
	private table t;
	private JTextField textField;
	private JFrame msg = new JFrame();
     
    

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Launcher window = new Launcher();
					window.frmJFrame1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Launcher() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmJFrame1 = new JFrame();
		frmJFrame1.setTitle("Breadth and Depth Search Examples");
		frmJFrame1.setBounds(100, 100, 850, 650);
		frmJFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJFrame1.getContentPane().setLayout(null);
		
		
		
		
		
		JButton btnLabelIt = new JButton("Label It!");
		btnLabelIt.setEnabled(false);
		
		
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Breadth First");
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setBounds(27, 128, 109, 23);
		frmJFrame1.getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Depth First");
		rdbtnNewRadioButton_1.setBounds(27, 154, 139, 23);
		frmJFrame1.getContentPane().add(rdbtnNewRadioButton_1);
		
		JLabel lblEnter = new JLabel("Please enter a dimension");
		lblEnter.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEnter.setBounds(27, 42, 179, 23);
		frmJFrame1.getContentPane().add(lblEnter);
		
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnNewRadioButton);
		buttonGroup.add(rdbtnNewRadioButton_1);
	
		
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setText("10");
		textField.setBounds(58, 67, 86, 20);
		frmJFrame1.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnGenerateGrid = new JButton("Generate Grid");
		btnGenerateGrid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
				int  dimension =Integer.parseInt(textField.getText());
				
					if(dimension >15 || dimension <5)
			           {
			           String message = "Please enter a dimension between 5 and 15";
			          JOptionPane.showMessageDialog(msg, message);
			           }else{
			        	t = new table(dimension);
			       		t.setBounds(216, 30, 550, 550);
			       		
			       		t.model.fireTableCellUpdated(0, 0);
			       		
			       		frmJFrame1.getContentPane().add(t);                     
			       		btnGenerateGrid.setEnabled(false);
			       		textField.setEnabled(false);
			       		btnLabelIt.setEnabled(true);
			       		
			       		t.model.fireTableCellUpdated(0, 0);
			       		frmJFrame1.show();
	       		
			          }
			
				}catch(NumberFormatException x){
					String message = "Please enter a dimension between 5 and 15";
			          JOptionPane.showMessageDialog(msg, message);
				
				}
			}
		});
	
		
		btnGenerateGrid.setBounds(42, 98, 112, 23);
		frmJFrame1.getContentPane().add(btnGenerateGrid);
		
		btnLabelIt.setBounds(42, 213, 89, 23);
		frmJFrame1.getContentPane().add(btnLabelIt);
		
		btnLabelIt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//START LABELING
				//Polymorphic classes
				
				
				if (rdbtnNewRadioButton.isSelected()){
					
					//insert here the code for DepthFirst search
					// use t for table object and Integer.parseInt(textField.getText()) for the dimension
					
					BreadthFirst bF = new BreadthFirst(t, Integer.parseInt(textField.getText()));
					bF.process();

				}else {

					
					//insert here the code for DepthFirst search
					// use t for table object and Integer.parseInt(textField.getText()) for the dimension
					DepthFirst dF = new DepthFirst(t, Integer.parseInt(textField.getText()));
					dF.process();
	
				}
				
				btnLabelIt.setEnabled(false);

			}
		});
		
		
		}
}
