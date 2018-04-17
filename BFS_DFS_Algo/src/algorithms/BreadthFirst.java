package algorithms;

import java.awt.Color;

import structures.Queue;
import structures.Stack;
import visu.table;

public class BreadthFirst extends Labelling{
	/***************************************************
	 *   BFS- DFS Algorithms
	 *  BreadthFirst.java
	 *  Purpose:	Breadth First Search Algorithm for
	 *  			square tables.
	 *
	 *  @author Tiago B. Dos Anjos
	 *  @version 1.0 4/16/18 
	 ****************************************************/
	public BreadthFirst(table tab, int d) {
		super(tab, d);
		// TODO Auto-generated constructor stub
	}

	
	public void modeTwo(int r, int c, int i , Color cor) {
		

			int [] here , transfer; 
			
	

			int [][] pos = {
					{0,1}, //right [0]
					{1,0}, //down  [1]
					{0,-1},//left  [2]
					{-1,0}//up     [3]
			};
			
			 //	[0]		   [1]
			int obsRow = r , obsCol = c;
			int functionIndex = 1;
			Queue q = new Queue();
		
			here = new int[2];
			transfer = new int[2];
			
			
			here[0] = r;
			here[1] = c;
			
			q.put(here);
			boolean fisrTime = true;
			
			while (!q.isEmpty()){
			
				
				transfer = (int[]) q.remove();
				
				r = transfer[0];
				c = transfer[1];
				
				int o;
				for ( o =0; o <= 3 ; o++){
					
					obsRow = r + pos[o][0];
					obsCol = c + pos [o][1];
					if (getS()[obsRow][obsCol].getValue() == 1){
						
						functionIndex++;
						
						
						this.getS()[obsRow][obsCol].setValue(0);
						this.getT().setValueAt(i + "," + functionIndex, obsRow -1 ,obsCol -1 );
						this.getT().colorSet(obsRow -1 , obsCol-1, cor);
						
						here = new int[2];
						here[0] = obsRow;
						here[1] = obsCol;
						q.put(here);

						
					}
						
				}

			}
	}
	
	
}
