/*******************************************************************************************************************
Class implementing the planning entity (?) class of the OptaPlanner domain model for the Skyscraper Puzzle problem.

Sources:
1) ..\examples\sources\src\main\java\org\optaplanner\examples\cloudbalancing\domain\CloudProcess.java
2) https://docs.optaplanner.org/7.20.0.Final/optaplanner-docs/html_single/index.html#cloudBalancingClassProcess

Author:         Matīss Apinis
Date created:   2019/04/23
Date edited:    2019/05/28
*******************************************************************************************************************/

package org.optaplanner.examples.nqueens.domain;

/** Dependencies used by OptaPlanner examples: **/
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

/** Dependencies used by sudoku example: **/
import java.io.Serializable;

// Planning entity:
@PlanningEntity
public class Cell implements Serializable {
    private int r_idx;
    private int c_idx;
    private Row row;
    private Column column;
    // private int entry; // Is an integer for cell entry a better way to represent the planning variable than a class?
    private Entry entry;



    /** Initialize cell: **/
    public Cell(int r_idx, int c_idx) {
        this.r_idx = r_idx;
        this.c_idx = c_idx;

        this.row = new Row();
        this.row.set_idx(r_idx);
        this.column = new Column();
        this.column.set_idx(c_idx);

        this.entry = new Entry();
    }



    /** Set and get cell row: **/
    public void set_row(Row row) {
        this.row = row;
    }

    public Row get_row() {
        return this.row;
    }



    /** Set and get cell column: **/
    public void set_column(Column column) {
        this.column = column;
    }

    public Column get_column() {
        return this.column;
    }



    /** Set and get cell row index: **/
    public void set_row_idx(int r_idx) {
        this.r_idx = r_idx;
    }

    public int get_row_idx() {
        return this.r_idx;
    }



    /** Set and get cell column index: **/
    public void set_column_idx(int c_idx) {
        this.c_idx = c_idx;
    }

    public int get_column_idx() {
        return this.c_idx;
    }



    /** Set and get cell entry value: **/
    public void set_entry(Entry entry) {
        this.entry = entry;
    }

    /**
    A planning variable is a JavaBean property (so a getter and setter) on a planning entity.
    It points to a planning value, which changes during planning.

    A genuine planning variable getter needs to be annotated with the @PlanningVariable annotation,
    which needs a non-empty valueRangeProviderRefs property.
    **/
    @PlanningVariable(valueRangeProviderRefs = {"entry_value_range"})
    public Entry get_entry() {
    // public int get_entry() {                 //
        return this.entry;
        // return this.entry.get_entry_value(); // Is this an incorrect way to plan the entry values?
    }



    /** Return a string with the cell indices and entry value for debugging: **/
    @Override
    public String toString() {
        // "Cell[row, column, entry]":
        StringBuffer sb = new StringBuffer("Cell[" + this.get_row_idx() + ", "
                                                   + this.get_column_idx() + ", "
                                                   + this.get_entry() + "]");
        return sb.toString();
    }
}
