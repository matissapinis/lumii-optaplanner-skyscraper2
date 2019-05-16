/** Added from sudoku example (whole class): **/
package org.optaplanner.examples.nqueens.domain;

/** Dependencies used by OptaPlanner examples: **/
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;
import org.optaplanner.examples.common.domain.AbstractPersistable;
import org.optaplanner.examples.nqueens.domain.solution.QueenDifficultyWeightFactory;
import org.optaplanner.examples.nqueens.domain.solution.RowStrengthWeightFactory;

/** Dependencies used by sudoku example: **/
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/** Dependencies added by me: **/
import org.optaplanner.examples.nqueens.app.Sudoku;

public class Region extends AbstractPersistable {
    private int index;
    private Row row;
    private Column col;

    public Region() {
        super();
        this.row = new Row();
        this.col = new Column();
    }

    public Region(int index){
        this();
        this.index = index;
    }

    public int getIndex() { return index; }

    public void setIndex(int index) { this.index = index; }

    private Row getRow() { return this.row; }
    private Column getColumn() { return this.col; }

    public int getRowIndex() { return getRow().getIndex(); }
    public int getColumnIndex() { return getColumn().getIndex(); }

    public void setRowIndex(int index){
        if (index > Sudoku.numberOfRowsInRegion) {
            throw new IllegalArgumentException("Row index should be less than " + Sudoku.numberOfRowsInRegion);
        }
        getRow().setIndex(index);
    }

    public void setColumnIndex(int index){
        if (index > Sudoku.numberOfColsInRegion) {
            throw new IllegalArgumentException("Column index should be less than " + Sudoku.numberOfColsInRegion);
        }
        getColumn().setIndex(index);
    }

    @Override
    public String toString() { return "Region-" + index + ", Row and Column Index-" + getRowIndex() + "," + getColumnIndex(); }
}
