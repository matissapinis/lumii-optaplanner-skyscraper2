package org.optaplanner.examples.nqueens.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.optaplanner.examples.nqueens.domain.BoardCell;
import org.optaplanner.examples.nqueens.domain.Number;
import org.optaplanner.examples.nqueens.domain.Region;
import org.optaplanner.examples.nqueens.domain.SudokuBoard;

public class SudokuBoardGenerator {
    SudokuBoard board = null;
    List<BoardCell> cells;
    List<Region> regions;
    List<Number> numbers;

    public SudokuBoard generateSudokuBoard() {
        board = new SudokuBoard();

        cells = createSudokuBoardCells();
        regions = createRegions();
        assignCellsToRegionsLite(cells,regions);
        numbers = createNumbersLite();

        board.setCells(cells);
        board.setRegions(regions);
        board.setNumbers(numbers);
        //assign problem assigned cells
        //board.setCells(assignProblemToBoard(20,board));
        return board;
    }

    private List<BoardCell> createSudokuBoardCells() {
        List<BoardCell> cells = new ArrayList<BoardCell>(Sudoku.numberOfCells);
        for(int i = 0; i < Sudoku.maxNumberOfRows; i++){
            for(int j = 0; j < Sudoku.maxNumberOfColums; j++) {
                BoardCell cell = new BoardCell();
                cell.setRowIndex(i + 1);
                cell.setColumnIndex(j + 1);
                cells.add(cell);
            }
        }
        return cells;
    }

    private List<Region> createRegions() {
        List<Region> regions = new ArrayList<Region>(Sudoku.numOfRegions);
        for (int i = 0,counter = 0; i < Sudoku.numberOfRowsInRegion; i++) {
            for (int j = 0; j < Sudoku.numberOfColsInRegion; j++) {
                Region r = new Region();
                r.setRowIndex(i + 1);
                r.setColumnIndex(j + 1);
                ++counter;
                r.setIndex(counter);
                regions.add(r);
            }
        }
        return regions;
    }

    private void assignCellsToRegionsLite(List<BoardCell> cells, List<Region> regions) {
        for (BoardCell cell : cells) {
            if (cell.getRowIndex() <= Sudoku.numberOfRowsInRegion &&
                cell.getColIndex() <= Sudoku.numberOfColsInRegion) {
                Region r0 = regions.get(0);
                cell.setRegion(r0);
            }
            if (cell.getRowIndex() <= Sudoku.numberOfRowsInRegion &&
               (cell.getColIndex() > Sudoku.numberOfColsInRegion &&
                cell.getColIndex() <= (Sudoku.numberOfColsInRegion * 2))) {
                Region r1 = regions.get(1);
                cell.setRegion(r1);
            }
            if (cell.getRowIndex() <= Sudoku.numberOfRowsInRegion &&
               (cell.getColIndex() > (Sudoku.numberOfColsInRegion * 2) &&
                cell.getColIndex() <= (Sudoku.numberOfColsInRegion * 3))) {
                Region r2 = regions.get(2);
                cell.setRegion(r2);
            }
            if (cell.getColIndex() <= Sudoku.numberOfColsInRegion &&
               (cell.getRowIndex() > (Sudoku.numberOfRowsInRegion) &&
                cell.getRowIndex() <= (Sudoku.numberOfRowsInRegion * 2))) {
                Region r3 = regions.get(3);
                cell.setRegion(r3);
            }

            if ((cell.getColIndex() > Sudoku.numberOfColsInRegion &&
                 cell.getColIndex() <= (Sudoku.numberOfColsInRegion * 2)) &&
                (cell.getRowIndex() > (Sudoku.numberOfRowsInRegion) &&
                 cell.getRowIndex() <= (Sudoku.numberOfRowsInRegion * 2))) {
                Region r4 = regions.get(4);
                cell.setRegion(r4);
            }

            if ((cell.getColIndex() > (Sudoku.numberOfColsInRegion * 2) &&
                 cell.getColIndex() <= (Sudoku.numberOfColsInRegion * 3)) &&
                (cell.getRowIndex() > (Sudoku.numberOfRowsInRegion) &&
                 cell.getRowIndex() <= (Sudoku.numberOfRowsInRegion * 2))) {
                Region r5 = regions.get(5);
                cell.setRegion(r5);
            }

            if (cell.getColIndex() <= Sudoku.numberOfColsInRegion &&
               (cell.getRowIndex() > (Sudoku.numberOfRowsInRegion * 2) &&
                cell.getRowIndex() <= (Sudoku.numberOfRowsInRegion * 3))) {
                Region r6 = regions.get(6);
                cell.setRegion(r6);
            }

            if ((cell.getColIndex() > Sudoku.numberOfColsInRegion &&
                 cell.getColIndex() <= (Sudoku.numberOfColsInRegion * 2)) &&
                (cell.getRowIndex() > (Sudoku.numberOfRowsInRegion * 2) &&
                 cell.getRowIndex() <= (Sudoku.numberOfRowsInRegion * 3))) {
                Region r7 = regions.get(7);
                cell.setRegion(r7);
            }

            if ((cell.getColIndex() > (Sudoku.numberOfColsInRegion * 2) &&
                 cell.getColIndex() <= (Sudoku.numberOfColsInRegion * 3)) &&
                (cell.getRowIndex() > (Sudoku.numberOfRowsInRegion * 2) &&
                 cell.getRowIndex() <= (Sudoku.numberOfRowsInRegion * 3))) {
                Region r8 = regions.get(8);
                cell.setRegion(r8);
            }
        }
    }

    /*
     * number should be 1-9 repeating 9 times
     */
    private List<Number> createNumbers(){
        List<Number> numbers = new ArrayList<Number>(Sudoku.countOfNumbersInBoard);
        for (int i = 0; i < Sudoku.maxNumberOfRows; i++) {
            for (int j = 0; j < Sudoku.maxNumberOfColums; j++) {
                Number n = new Number();
                n.setNumberValue(j + 1);
                numbers.add(n);
            }
        }
        return numbers;
    }

    private List<Number> createNumbersLite(){
        List<Number> numbers = new ArrayList<Number>(Sudoku.heighestNumValue);
        for (int i = 1; i <= Sudoku.heighestNumValue; i++) {
            Number n = new Number();
            n.setNumberValue(i);
            numbers.add(n);
        }
        Collections.shuffle(numbers);
        return numbers;
    }
}

