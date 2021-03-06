package org.ploxie.solver;

import org.ploxie.solver.gui.GUI;

public class Bootstrap {
	
	public static void main(String[] args) {
		Sudoku s = new Sudoku(new int[][]{
				{5,3,0,0,7,0,0,0,0},
				{6,0,0,1,9,5,0,0,0},
				{0,9,8,0,0,0,0,6,0},
				{8,0,0,0,6,0,0,0,3},
				{4,0,0,8,0,3,0,0,1},
				{7,0,0,0,2,0,0,0,6},
				{0,6,0,0,0,0,2,8,0},
				{0,0,0,4,1,9,0,0,5},
				{0,0,0,0,8,0,0,7,9}}
				);
		
		GUI gui = new GUI(s);
		
		BacktrackSolver solver = new BacktrackSolver();
		solver.solve(s);
	}
	
}
