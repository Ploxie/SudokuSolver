package org.ploxie.solver;

public class Sudoku {

	private int[][] grid;
	
	public Sudoku() {
		this.grid = new int[9][9];
		clear();
	}
	
	public Sudoku(int[][] grid) {
		this.grid = grid;
	}
	
	private Sudoku(Sudoku clone) {
		this.grid = new int[9][9];
		for(int y = 0; y < 9; y++) {
			for(int x = 0; x < 9; x++) {
				this.grid[y][x] = clone.grid[y][x];
			}
		}
	}
	
	public void clear() {
		for(int y = 0; y < 9; y++) {
			for(int x = 0; x < 9; x++) {
				this.grid[y][x] = 0;
			}
		}
	}
	
	public void setValue(int x, int y, int value) {
		this.grid[y][x] = value;
	}
	
	public int getValue(int x, int y) {
		return this.grid[y][x];
	}
	
	
	public boolean isInRow(int row, int value) {		
		for(int i = 0 ; i < 9;i++) {
			if(grid[row][i] == value) {
				return true;
			}
		}		
		return false;
	}
	
	public boolean isInColumn(int column, int value) {
		for(int i = 0 ; i < 9;i++) {
			if(grid[i][column] == value) {
				return true;
			}
		}
		return false;
	}
	
	public boolean isInBox(int column, int row, int value) {
		int r = row - row % 3;
		int c = column - column % 3;
		
		for(int y = r; y < r + 3;y++) {
			for(int x = c; x < c + 3; x++) {
				if(grid[y][x] == value) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	public boolean isValid(int column, int row, int value) {
		return !isInBox(column, row, value) && !isInColumn(column, value) && !isInRow(row, value);
	}
	
	public int[][] getGrid() {
		return grid;
	}
	
	public Sudoku clone() {
		return new Sudoku(this);
	}
	
	public String toString() {
		String res = "┏━━━┳━━━┳━━━┳━━━┳━━━┳━━━┳━━━┳━━━┳━━━┓\n";
		for(int i = 0 ; i < 9;i++) {
			for(int j = 0 ; j < 9;j++) {
				res+="┃ "+this.grid[i][j]+ " ";
			}
			res += "┃\n";
			res += "┣━━━╋━━━╋━━━╋━━━╋━━━╋━━━╋━━━╋━━━╋━━━┫\n";
		}
		
		return res;
	}

	
}
