package algorithms;

import java.awt.Color;
import java.util.Vector;
import java.util.concurrent.TimeUnit;
import java.util.Random;

import visu.square;
import visu.table;

public class Labelling {
	private table t;
	private int dimension;
	
	public table getT() {
		return t;
	}


	public void setT(table t) {
		this.t = t;
	}


	public int getDimension() {
		return dimension;
	}


	public void setDimension(int dimension) {
		this.dimension = dimension;
	}


	public square[][] getS() {
		return s;
	}


	public void setS(square[][] s) {
		this.s = s;
	}


	private square s[][];
	int index;
	
	
	
	public Labelling( table tab, int d ){
		
		t = tab;
		dimension = d;
		s = new square[d+2][d+2];
		index = 0;
	}
	
	
	public void process(){
		
		// create grid with borders
		for (int r = 0 ; r < dimension+2 ; r++){
			for (int c = 0 ; c < dimension+2 ; c++){
				
				if (c == 0 || c == (dimension+1) || r == 0 || r== (dimension +1))
					s[r][c] = new square();
				else
					s[r][c]= t.getS()[r-1][c-1];
				
			}
		}
		
		//MODE 1
		for (int r = 1 ; r < dimension+2 ; r++){
			for (int c = 1 ; c < dimension+2 ; c++){
						//MODE2
				if (s[r][c].getValue() == 1){
						++index;
						
						Color cor = rbg();
						this.getT().setValueAt(index + "," + 1, r -1 ,c-1 );
						this.getT().colorSet(r -1, c-1, cor);
						this.s[r][c].setValue(0);
						modeTwo( r, c, index, cor);
				}
				
			}
		}
		
		
		
	}


	public void modeTwo(int r ,int c, int i , Color cor) {
		//implemented on polymorphic classes
		
	}
	public Color rbg (){

		// pastel colors
		Random rnd = new Random();
	    int r = rnd.nextInt(155) + 100; // 128 ... 255
	    int g = rnd.nextInt(155) + 010; // 128 ... 255
	    int b = rnd.nextInt(155) + 001; // 128 ... 255
	    
	    Color c = new Color(r, g, b);
	    
		return c.brighter();
		
	}

}
