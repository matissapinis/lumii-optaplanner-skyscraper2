package org.optaplanner.examples.nqueens.app;

import org.optaplanner.core.api.solver.Solver;
import org.optaplanner.core.api.solver.SolverFactory;

/** Commented out to simplify project:
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
**/

import java.util.Iterator;

import org.optaplanner.examples.nqueens.domain.Cell;
import org.optaplanner.examples.nqueens.domain.Puzzle;

public class SkyscraperHelloWorld {
    Puzzle unSolvedPuzzle = null;
    Puzzle solvedPuzzle = null;

    /** Commented out to simplify project:
    protected final transient Logger logger = LoggerFactory.getLogger(getClass());
    **/



    public SkyscraperHelloWorld() {
        this.unSolvedPuzzle = null;
        this.solvedPuzzle = null;
    }



    public static void main(String[] args) {
        // TODO Auto-generated method stub
        SkyscraperHelloWorld sh = new SkyscraperHelloWorld();
        this.sh.init();
    }



    public void init(){
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



    /** Outputs the solved skyscraper puzzle problem in the system console: **/
    public void printSolvedSolution(Puzzle puzzle){
        /// TBC:
        // System.out.println(cells);
        for (int i = 0; i < Skyscraper.maxNumberOfColumns; i++) {
            if ((i % Skyscraper.numberOfColsInSide) == 0) { System.out.print("|"); }
            System.out.print("-");
        }
        System.out.print("|");

        for (int i = 1; i <= Skyscraper.maxNumberOfRows; i++) {
            System.out.println();
            System.out.print("|");
            for (int j = 1; j <= Skyscraper.maxNumberOfColumns; j++) {
                //System.out.println("i "+i+" J "+j);
                PuzzleCell c = puzzle.getCell(i, j);
                System.out.print(c.getCellClueValue());
                if ((j % Skyscraper.numberOfColsInSide) == 0) { System.out.print("|"); }
            }

            if ((i % Skyscraper.numberOfRowsInSide) == 0) {
                System.out.println();
                for (int k = 0; k < Skyscraper.maxNumberOfColumns; k++) {
                    if ((k % Skyscraper.numberOfColsInSide) == 0) { System.out.print("|"); }
                    System.out.print("-");
                }
                System.out.print("|");
            }
        }
    }
}
