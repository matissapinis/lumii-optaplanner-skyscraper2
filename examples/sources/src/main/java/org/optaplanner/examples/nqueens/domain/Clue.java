/*******************************************************************************************************************
Class implementing the problem fact (?) class of the OptaPlanner domain model for the Skyscraper Puzzle problem.

Sources:
1) lumii-optaplanner-sudolu

Author:         Matīss Apinis
Date created:   2019/05/13
Date edited:    2019/05/13
*******************************************************************************************************************/

package org.optaplanner.examples.nqueens.domain;

/** Dependencies used by sudoku example: **/
import java.io.Serializable;
import java.util.List;

/** Dependencies added by me: **/
/** TODO: Fix this dependency! **/
import org.optaplanner.examples.nqueens.app.Skyscraper;

public class Clue implements Serializable {
    private int id;
    private static int count;
    /** TODO: Fix this dependency! **/
    private int clueValue;
    //planning variable
    private PuzzleCell cell;

    public Clue() { this(++count); }
    private Clue(int id) {
        this.id = id;
        clueValue = 0;
    }

    public int getId() { return this.id; }

    public int getClueValue() { return clueValue; }

    public void setClueValue(int clueValue) {
        /** TODO: Fix this dependency! **/
        if (clueValue > Skyscraper.maxCellClueValue || clueValue < Skyscraper.minCellClueValue) {
            throw new IllegalArgumentException("Clue Values should be between 1-9!");
        }
        this.clueValue = clueValue;
    }

    @Override
    public String toString() { return "Clue [id=" + id + ", clueValue=" + clueValue + "]"; }

    public PuzzleCell getPuzzleCell() { return this.cell; }

    public void setPuzzleCell(PuzzleCell cell) { this.cell = cell; }

    public int[] getCellIndex(){
        if(cell != null) { return new int[]{cell.getRowIndex(),cell.getColIndex()}; }
        return new int[]{0,0};
    }

    public List<PuzzleCell> getPuzzleCellRow(List<PuzzleCell> puzzleCells) { return null; }

    public List<PuzzleCell> getPuzzleCellColumn(List<PuzzleCell> puzzleCells) { return null; }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Clue other = (Clue) obj;
        /** TODO: Fix this dependency! **/
        if (id != other.id) return false;
        return true;
    }
}
