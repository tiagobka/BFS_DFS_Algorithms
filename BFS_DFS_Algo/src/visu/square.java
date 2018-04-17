package visu;

import java.awt.Color;

public class square {
	private int row, column , value;
	private Color color;
	
	
	public square(){ 
	row = 0;
	column = 0 ;
	color = Color.WHITE;
	setValue(0);}
	
	
	public square(int r, int c, Color cor){
		row = r;
		column =c;
		setValue(0);
		color = cor;
	}
	
	
	
	
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		this.column = column;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

}
