package org.optaplanner.examples.nqueens.domain;

import java.io.Serializable;
import java.util.List;

import org.optaplanner.core.api.domain.variable.PlanningVariable;
import org.optaplanner.examples.nqueens.app.Skyscraper;

public class Entry implements Serializable {
    private int id;
    private int value;
    // Planning variable:
    @PlanningVariable
    private Cell cell;

    private Entry(int id) {
        this.id = id;
        this.value = -1;
    }

    /** Get entry ID **/ // Don't know whether this is necessary.
    public int get_id() {
        return this.id;
    }

    /** Set and get entry value: **/
    public int get_entry_value() {
        return this.value;
    }

    public void set_entry_value(int value) {
        if (value < Skyscraper.minimum_entry_value || value > Skyscraper.maximum_entry_value) {
            throw new IllegalArgumentException("Entry values should be from 1 to 4!");
        }

        this.value = value;
    }

    @Override
    public String toString() {
        // "Number[id, value]":
        return "Number[" + this.id + ", " + this.value + "]";
    }

    public Cell get_entry_cell() {
        return this.cell;
    }

    public void set_entry_cell(Cell cell) {
        this.cell = cell;
    }

    public int[] get_cell_idx() {
        if (cell != null) {
            return new int[]{cell.get_row_idx(), cell.get_column_idx()};
        }
        return new int[]{-1, -1};
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Entry other = (Entry) obj;
        if (id != other.id) return false;
        return true;
    }
}
