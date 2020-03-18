package org.ploxie.solver;

public class BacktrackSolver implements ISolver {

	@Override
	public Sudoku solve(Sudoku sudoku) {
		Sudoku temp = sudoku.clone();
		solveInternally(temp);
		return temp;
	}

	private boolean solveInternally(Sudoku temp) {
		for (int y = 0; y < 9; y++) {
			for (int x = 0; x < 9; x++) {
				if (temp.getValue(x, y) == 0) {

					for (int i = 1; i <= 9; i++) {
						if (temp.isValid(x, y, i)) {
							temp.setValue(x, y, i);

							if (solveInternally(temp)) {
								return true;
							} else {
								temp.setValue(x, y, 0);
							}
						}
					}

					return false;
				}
			}
		}

		return true;
	}
}
