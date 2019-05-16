/*******************************************************************************************************************
Class implementing the problem fact (?) class of the OptaPlanner domain model for the Skyscraper Puzzle problem.

Sources:
1) lumii-optaplanner-sudoku

Author:         Matīss Apinis
Date created:   2019/05/13
Date edited:    2019/05/13
*******************************************************************************************************************/

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

/** TODO: Fix this dependency! **/
import org.optaplanner.examples.nqueens.app.Skyscraper;

public class Side extends AbstractPersistable {
    private int index;
    private Row row;
    private Column col;

    public Side() {
        super();
        this.row = new Row();
        this.col = new Column();
    }

    public Side(int index){
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
        /** TODO: Fix this dependency! **/
        if (index > Skyscraper.numberOfRowsInSide) {
            throw new IllegalArgumentException("Row index should be less than " + Skyscraper.numberOfRowsInSide);
        }
        getRow().setIndex(index);
    }

    public void setColumnIndex(int index){
        /** TODO: Fix this dependency! **/
        if (index > Skyscraper.numberOfColsInSide) {
            throw new IllegalArgumentException("Column index should be less than " + Skyscraper.numberOfColsInSide);
        }
        getColumn().setIndex(index);
    }

    @Override
    public String toString() { return "Region-" + index + ", Row and Column Index-" + getRowIndex() + "," + getColumnIndex(); }
}