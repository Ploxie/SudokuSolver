package org.ploxie.solver.gui;

import java.awt.GridLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JPanel;
import javax.swing.JTextField;

import org.ploxie.solver.ISolver;
import org.ploxie.solver.Sudoku;

public class Grid extends JPanel{

	private static final long serialVersionUID = 1L;

	private static final int CELL_SIZE = 25;
	
	private int width;
	private int height;
	
	private JTextField[][] grid;
	
	public Grid(int width, int height) {
		this.width = width;
		this.height = height;
		
		create();
	}
	
	public Grid(int[][] grid) {
		this.width = grid[0].length;
		this.height = grid[1].length;
		
		create();
		
		update(grid);
	}
	
	public void solve(ISolver solver) {
		Sudoku sudoku = getSudoku();
		
		sudoku = solver.solve(sudoku);
		
		update(sudoku.getGrid());
	}
	
	public Sudoku getSudoku(){
		int[][] grid = new int[height][width];
		for(int y = 0; y < height;y++) {
			for(int x = 0; x < width; x++) {
				grid[y][x] = Integer.parseInt(this.grid[y][x].getText());
			}
		}
		
		return new Sudoku(grid);
	}
	
	public void update(int[][] grid) {
		for(int y = 0; y < height;y++) {
			for(int x = 0; x < width; x++) {
				this.grid[y][x].setText(Integer.toString(grid[y][x]));
			}
		}
	}
	
	public void clear() {
		for(int y = 0; y < height;y++) {
			for(int x = 0; x < width; x++) {
				this.grid[y][x].setText(Integer.toString(0));
			}
		}
	}
	
	private void create() {
		setLayout(new GridLayout(height, width));
		
		grid = new JTextField[height][width];
		
		for(int y = 0 ; y < height;y++) {
			for(int x = 0 ; x < width; x++) {
				JTextField cell = new JTextField(" ");
				cell.setLocation(x * CELL_SIZE, y * CELL_SIZE);
				cell.setSize(CELL_SIZE, CELL_SIZE);
				cell.setVisible(true);
				cell.setHorizontalAlignment(JTextField.CENTER);
				
				cell.addFocusListener(new FocusListener() {

					@Override
					public void focusGained(FocusEvent arg0) {
						cell.selectAll();
					}

					@Override
					public void focusLost(FocusEvent arg0) {
						// TODO Auto-generated method stub
						
					}
					
				});
				
				grid[y][x] = cell;
				
				add(cell);
			}
		}
		
		setSize(width * CELL_SIZE, height * CELL_SIZE);
		setVisible(true);
	}
	
}
