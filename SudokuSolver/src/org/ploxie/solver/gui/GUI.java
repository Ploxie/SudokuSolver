package org.ploxie.solver.gui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.ploxie.solver.BacktrackSolver;
import org.ploxie.solver.ISolver;
import org.ploxie.solver.Sudoku;

public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;

	private static final int WIDTH = 300;
	private static final int HEIGHT = 350;

	private Grid grid;
	private JButton solveButton;
	private ISolver solver;
	
	public GUI(Sudoku sudoku) {
		grid = new Grid(sudoku.getGrid());
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

		int x = (dim.width - WIDTH) / 2;
		int y = (dim.height - HEIGHT) / 2;
		
		setTitle("Sudoku Solver");
		setLocation(x, y);
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		setLayout(null);
		
		int gx = (WIDTH - grid.getWidth()-15) / 2;
		grid.setLocation(gx, 15);
		add(grid);
		
		solver = new BacktrackSolver();
		solveButton = new JButton("Solve");
		solveButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				grid.solve(solver);
			}
			
		});
		
		solveButton.setSize(100, 20);
		solveButton.setLocation((WIDTH - solveButton.getWidth() - 15) / 2, grid.getY() + grid.getHeight() + 15);
		solveButton.setVisible(true);
		add(solveButton);
		
		
		JButton clearButton = new JButton("Clear");
		clearButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				grid.clear();
				sudoku.clear();
			}
			
		});
		
		clearButton.setSize(100, 20);
		clearButton.setLocation((WIDTH - clearButton.getWidth() - 15) / 2, solveButton.getY()+ solveButton.getHeight());
		clearButton.setVisible(true);
		add(clearButton);
	}

}
