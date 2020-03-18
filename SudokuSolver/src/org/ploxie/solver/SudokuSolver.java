package org.ploxie.solver;

public class SudokuSolver {

	private ISolver solver;
	
	public SudokuSolver(ISolver solver) {
		this.solver = solver;
	}
	
	public Sudoku solve(Sudoku sudoku) {
		return solver.solve(sudoku);
	}
	
}
