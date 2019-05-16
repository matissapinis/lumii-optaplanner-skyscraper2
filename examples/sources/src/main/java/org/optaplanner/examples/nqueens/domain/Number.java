/** Added from sudoku example (whole class): **/
package org.optaplanner.examples.nqueens.domain;

/** Dependencies used by sudoku example: **/
import java.io.Serializable;
import java.util.List;

/** Dependencies added by me: **/
import org.optaplanner.examples.nqueens.app.Sudoku;

public class Number implements Serializable {
    private int id;
    private static int count;
    private int numberValue;
    //planning variable
    private BoardCell cell;

    public Number() { this(++count); }
    private Number(int id) {
        this.id = id;
        numberValue = 0;
    }

    public int getId() { return this.id; }

    public int getNumberValue() { return numberValue; }

    public void setNumberValue(int numberValue) {
        if (numberValue > Sudoku.maxCellNumValue || numberValue < Sudoku.minCellNumValue) {
            throw new IllegalArgumentException("Number Values should be between 1-9!");
        }
        this.numberValue = numberValue;
    }

    @Override
    public String toString() { return "Number [id=" + id + ", numberValue=" + numberValue + "]"; }

    public BoardCell getBoardCell() { return this.cell; }

    public void setBoardCell(BoardCell cell) { this.cell = cell; }

    public int[] getCellIndex(){
        if(cell !=null) { return new int[]{cell.getRowIndex(),cell.getColIndex()}; }
        return new int[]{0,0};
    }

    public List<BoardCell> getBoardCellRow(List<BoardCell> boardCells) { return null; }

    public List<BoardCell> getBoardCellColumn(List<BoardCell> boardCells) { return null; }

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
        Number other = (Number) obj;
        if (id != other.id) return false;
        return true;
    }
}
