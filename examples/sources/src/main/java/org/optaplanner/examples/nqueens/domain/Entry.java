package org.optaplanner.examples.nqueens.domain;

import java.io.Serializable;
import java.util.List;

import org.optaplanner.core.api.domain.variable.PlanningVariable;
import org.optaplanner.examples.nqueens.app.Skyscraper;

public class Entry implements Serializable {
    private int id;
    private int value;
    private static int count; ///

    // Planning variable:
    @PlanningVariable
    private Cell cell;



    /** TODO: Not sure how to use an entry counter as ID enumerator: **/
    /**
    public Entry() {
        this(++count);
    }
    **/

    /** Initialize entry: **/
    /// public Entry(int id, Cell cell) {
    /// public Entry(Cell cell) {
    public Entry() {
        /// this.id = id;
        this.value = -1;
        /// this.cell = cell;
    }



    /** Get entry ID **/ // Don't know whether this is necessary.
    public int get_entry_id() {
        return this.id;
    }



    /** Set and get entry value: **/
    public void set_entry_value(int value) {
        if (value < Skyscraper.minimum_entry_value || value > Skyscraper.maximum_entry_value) {
            throw new IllegalArgumentException("Entry values should be from 1 to 4!");
        }

        this.value = value;
    }

    public int get_entry_value() {
        return this.value;
    }



    /** Set and get entry cell: **/
    public Cell get_entry_cell() {
        return this.cell;
    }

    public void set_entry_cell(Cell cell) {
        this.cell = cell;
    }



    /** Get cell index as pair of row-column incides: **/
    public int[] get_cell_idx() {
        if (cell != null) {
            return new int[]{cell.get_row_idx(), cell.get_column_idx()};
        }
        return new int[]{-1, -1};
    }



    /** Return a string with the row index for debugging: **/
    @Override
    public String toString() {
        // "Cell[id, value]":
        return "Cell[" + this.id + ", " + this.value + "]";
    }



    /** Not sure what the overridden hashing is for: **/
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }
    /**************************************************/



    /** Not sure what comparing two object IDs is for: **/
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Entry other = (Entry) obj;
        if (id != other.id) return false;
        return true;
    }
    /***************************************************/
}
