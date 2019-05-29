package org.optaplanner.examples.nqueens.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.optaplanner.examples.nqueens.domain.Cell;

public class SkyscraperPuzzleGenerator {
    SkyscraperPuzzle puzzle = null;
    List<Cell> cells;
    List<Side> sides;
    List<Clue> clues;

    public SkyscraperPuzzle generateSkyscraperPuzzle() {
        puzzle = new SkyscraperPuzzle();

        cells = createSkyscraperPuzzleCells();
        sides = createSides();
        assignCellsToSidesLite(cells,sides);
        clues = createCluesLite();

        puzzle.setCells(cells);
        puzzle.setSides(sides);
        puzzle.setClues(clues);
        //assign problem assigned cells
        //puzzle.setCells(assignProblemToPuzzle(20,puzzle));
        return puzzle;
    }

    private List<PuzzleCell> createSkyscraperPuzzleCells() {
        List<PuzzleCell> cells = new ArrayList<PuzzleCell>(Skyscraper.numberOfCells);
        for(int i = 0; i < Skyscraper.maxNumberOfRows; i++){
            for(int j = 0; j < Skyscraper.maxNumberOfColumns; j++) {
                PuzzleCell cell = new PuzzleCell();
                cell.setRowIndex(i + 1);
                cell.setColumnIndex(j + 1);
                cells.add(cell);
            }
        }
        return cells;
    }

    private List<Side> createSides() {
        List<Side> sides = new ArrayList<Side>(Skyscraper.numOfSides);
        for (int i = 0,counter = 0; i < Skyscraper.numberOfRowsInSide; i++) {
            for (int j = 0; j < Skyscraper.numberOfColsInSide; j++) {
                Side s = new Side();
                s.setRowIndex(i + 1);
                s.setColumnIndex(j + 1);
                ++counter;
                s.setIndex(counter);
                sides.add(s);
            }
        }
        return sides;
    }

    private void assignCellsToSidesLite(List<PuzzleCell> cells, List<Side> sides) {
        for (PuzzleCell cell : cells) {
            if (cell.getRowIndex() <= Skyscraper.numberOfRowsInSide &&
                cell.getColIndex() <= Skyscraper.numberOfColsInSide) {
                Side s0 = sides.get(0);
                cell.setSide(s0);
            }
            if (cell.getRowIndex() <= Skyscraper.numberOfRowsInSide &&
               (cell.getColIndex() > Skyscraper.numberOfColsInSide &&
                cell.getColIndex() <= (Skyscraper.numberOfColsInSide * 2))) {
                Side s1 = sides.get(1);
                cell.setSide(s1);
            }
            if (cell.getRowIndex() <= Skyscraper.numberOfRowsInSide &&
               (cell.getColIndex() > (Skyscraper.numberOfColsInSide * 2) &&
                cell.getColIndex() <= (Skyscraper.numberOfColsInSide * 3))) {
                Side s2 = sides.get(2);
                cell.setSide(s2);
            }
            if (cell.getColIndex() <= Skyscraper.numberOfColsInSide &&
               (cell.getRowIndex() > (Skyscraper.numberOfRowsInSide) &&
                cell.getRowIndex() <= (Skyscraper.numberOfRowsInSide * 2))) {
                Side s3 = sides.get(3);
                cell.setSide(s3);
            }

            if ((cell.getColIndex() > Skyscraper.numberOfColsInSide &&
                 cell.getColIndex() <= (Skyscraper.numberOfColsInSide * 2)) &&
                (cell.getRowIndex() > (Skyscraper.numberOfRowsInSide) &&
                 cell.getRowIndex() <= (Skyscraper.numberOfRowsInSide * 2))) {
                Side s4 = sides.get(4);
                cell.setSide(s4);
            }

            if ((cell.getColIndex() > (Skyscraper.numberOfColsInSide * 2) &&
                 cell.getColIndex() <= (Skyscraper.numberOfColsInSide * 3)) &&
                (cell.getRowIndex() > (Skyscraper.numberOfRowsInSide) &&
                 cell.getRowIndex() <= (Skyscraper.numberOfRowsInSide * 2))) {
                Side s5 = sides.get(5);
                cell.setSide(s5);
            }

            if (cell.getColIndex() <= Skyscraper.numberOfColsInSide &&
               (cell.getRowIndex() > (Skyscraper.numberOfRowsInSide * 2) &&
                cell.getRowIndex() <= (Skyscraper.numberOfRowsInSide * 3))) {
                Side s6 = sides.get(6);
                cell.setSide(s6);
            }

            if ((cell.getColIndex() > Skyscraper.numberOfColsInSide &&
                 cell.getColIndex() <= (Skyscraper.numberOfColsInSide * 2)) &&
                (cell.getRowIndex() > (Skyscraper.numberOfRowsInSide * 2) &&
                 cell.getRowIndex() <= (Skyscraper.numberOfRowsInSide * 3))) {
                Side s7 = sides.get(7);
                cell.setSide(s7);
            }

            if ((cell.getColIndex() > (Skyscraper.numberOfColsInSide * 2) &&
                 cell.getColIndex() <= (Skyscraper.numberOfColsInSide * 3)) &&
                (cell.getRowIndex() > (Skyscraper.numberOfRowsInSide * 2) &&
                 cell.getRowIndex() <= (Skyscraper.numberOfRowsInSide * 3))) {
                Side s8 = sides.get(8);
                cell.setSide(s8);
            }
        }
    }

    private List<Clue> createClue(){
        List<Clue> clues = new ArrayList<Clue>(Skyscraper.countOfCluesInPuzzle);
        for (int i = 0; i < Skyscraper.maxNumberOfRows; i++) {
            for (int j = 0; j < Skyscraper.maxNumberOfColumns; j++) {
                Clue c = new Clue();
                c.setClueValue(j + 1);
                clues.add(c);
            }
        }
        return clues;
    }

    private List<Clue> createCluesLite(){
        List<Clue> clues = new ArrayList<Clue>(Skyscraper.highestClueValue);
        for (int i = 1; i <= Skyscraper.highestClueValue; i++) {
            Clue c = new Clue();
            c.setClueValue(i);
            clues.add(c);
        }
        Collections.shuffle(clues);
        return clues;
    }
}
