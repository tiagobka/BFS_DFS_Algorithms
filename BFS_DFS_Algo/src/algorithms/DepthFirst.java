package algorithms;

import java.awt.Color;

import structures.Stack;
import visu.square;
import visu.table;
/***************************************************
 *   BFS- DFS Algorithms 
 *  DepthFirst.java 
 *  Purpose:	Depth First Search Algorithm for
 *  			square tables.
 *
 *  @author Tiago B. Dos Anjos
 *  @version 1.0 4/16/18
 ****************************************************/
public class DepthFirst extends Labelling {

	public DepthFirst( table tab, int d) {
		super(tab, d);
		
		// TODO Auto-generated constructor stub
	}
	
	
	public void modeTwo(int r, int c, int i , Color cor) {
		

		
		int [] here; 
		
		

			int [][] pos = {
					{0,1}, //right [0]
					{1,0}, //down  [1]
					{0,-1},//left  [2]
					{-1,0}//up     [3]
			};
		 //	[0]		   [1]
		int obsRow = r , obsCol = c;
		int functionIndex = 1;

		Stack sta = new Stack();
		here = new int[2];
		here[0] = r;
		here[1]=c;
		
		sta.push(here);
		
		while (!sta.empty()){
	
			
			int o;
			for ( o =0; o <= 3 ; o++){
				
				obsRow = here[0] + pos[o][0];
				obsCol = here[1] + pos [o][1];
				if (getS()[obsRow][obsCol].getValue() == 1) break;
				
			}
			
			

			if (o <= 3){
				sta.push(here);
				
				
				
				this.getS()[here[0]][here[1]].setValue(0);
	
				functionIndex++;
				here = new int[2];
				here[0] = obsRow;
				here[1] = obsCol;
				
				this.getT().setValueAt(i + "," + functionIndex, here[0] -1 ,here[1] -1 );
				this.getT().colorSet(here[0] -1 , here[1]-1, cor);
				
				
			}else{

				int [] backUp = (int[]) sta.pop();
				this.getS()[here[0]][here[1]].setValue(0);
				
				here = new int[2];
				here [0] = backUp [0];
				here [1] = backUp [1];
				}

		}
		
		
		
	}
	
	
	










}
