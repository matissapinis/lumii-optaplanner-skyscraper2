package org.optaplanner.examples.nqueens.app;

import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;

/** Commented out to simplify project:
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
**/

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.lang.String.*;

import org.optaplanner.examples.nqueens.domain.Cell;
import org.optaplanner.examples.nqueens.domain.Puzzle;

public class SkyscraperHelloWorld {
    Puzzle unSolvedPuzzle = null;
    Puzzle solvedPuzzle = null;

    /**
    * Commented out to simplify project:
    * protected final transient Logger logger = LoggerFactory.getLogger(getClass());
    **/



    /** Initializes skyscraper puzzle for solving: **/
    public SkyscraperHelloWorld() {
        this.unSolvedPuzzle = null;
        this.solvedPuzzle = null;
    }



    /** Main function that launches the program: **/
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SkyscraperHelloWorld sh = new SkyscraperHelloWorld();
        sh.init();
    }



    /** Solves a generated skyscraper puzzle by calling solver: **/
    public void init() {
        long startTime = System.currentTimeMillis();
        SkyscraperPuzzleGenerator generator = new SkyscraperPuzzleGenerator();
        this.unSolvedPuzzle = generator.generate_puzzle();

        //printSolvedSolution(unSolvedBoard);
        //logger.info("Numbers =>"+unSolvedBoard.getNumbers());

        SolverFactory solverFactory =
                SolverFactory.createFromXmlResource("org/optaplanner/examples/nqueens/solver/skyscraperSolverConfig.xml");
        Solver solver = solverFactory.buildSolver();

        solver.solve(unSolvedPuzzle);
        solvedPuzzle = (Puzzle) solver.getBestSolution();
        printSolvedSolution(solvedPuzzle);

        /** Commented out to simplify project:
         long endTime = System.currentTimeMillis();
         long duration = endTime - startTime;
         logger.info("Solved in " + (duration / 1000) + " seconds");
         **/
        //printRegions(solvedBoard);
    }



    /** Outputs the solved skyscraper puzzle in the system console: **/
    public void printSolvedSolution(Puzzle puzzle) {
        /// TBC:
        // System.out.println(cells);

        /**
         1) Print ' ' + top clues ' '.
         2) Print left clue + row + right clue for all rows.
         3) Print ' ' + bottom clues ' '.
         **/

        List<Cell> cell_list = puzzle.get_cell_list();

        /** Previous approach with 2D grid of cells for O(1) operations:
        Cell[][] grid = puzzle.get_grid();
        **/

        /// TODO: To make sure to choose the (i, j)-th cell from the cell list I'd have to use a loop to find it.
        System.out.printf(" ");
        for (int i = 0; i < Skyscraper.row_count; i++) {
            for (int ii = 0; ii < cell_list.size(); ii++) {
                if (cell_list.get(ii).get_column_idx() == i) {
                    System.out.printf(String.valueOf(cell_list.get(i).get_column().get_T_clue()) + " ");
                }
            }

            /** Previous approach with 2D grid of cells for O(1) operations:
            System.out.printf(String.valueOf(grid[0][i].get_column().get_T_clue()) + " ");
            **/
        }

        System.out.printf("%n");

        for (int i = 0; i < Skyscraper.row_count; i++) {
            for (int ii = 0; ii < cell_list.size(); ii++) {
                if (cell_list.get(ii).get_row_idx() == i) {
                    System.out.printf(String.valueOf(cell_list.get(i).get_row().get_L_clue()) + " ");
                }
            }

            /** Previous approach with 2D grid of cells for O(1) operations:
            System.out.printf(String.valueOf(grid[i][0].get_row().get_L_clue()) + " ");
            **/

            for (int j = 0; j < Skyscraper.column_count; j++) {
                for (int ii = 0; ii < cell_list.size(); ii++) {
                    for (int jj = 0; ii < cell_list.size(); jj++) {
                        if (cell_list.get(ii).get_row_idx() == i && cell_list.get(jj).get_column_idx() == j) {
                            System.out.printf(String.valueOf(cell_list.get(j).get_entry().get_entry_value()) + " "); /// TODO: Index correct?
                        }
                    }
                }

                /** Previous approach with 2D grid of cells for O(1) operations:
                System.out.printf(String.valueOf(grid[i][j].get_entry().get_entry_value()) + " ");
                **/
            }

            /// TODO: To make sure to choose the (i, j)-th cell from the cell list I'd have to use a loop to find it.
            System.out.printf(String.valueOf(cell_list.get(i).get_column().get_T_clue()) + " "); /// TODO: Wrong, left here.

            /** Previous approach with 2D grid of cells for O(1) operations:
            System.out.printf(String.valueOf(grid[i][0].get_row().get_R_clue()) + "%n");
            **/
        }

        System.out.printf(" ");
        for (int i = 0; i < Skyscraper.row_count; i++) {
            for (int ii = 0; ii < cell_list.size(); ii++) {
                if (cell_list.get(ii).get_column_idx() == i) {
                    System.out.printf(String.valueOf(cell_list.get(i).get_column().get_B_clue()) + " ");
                }
            }

            /** Previous approach with 2D grid of cells for O(1) operations:
            System.out.printf(String.valueOf(grid[0][i].get_column().get_B_clue()) + " ");
            **/
        }
    }
}
