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
import org.optaplanner.examples.common.domain.AbstractPersistable;
import org.optaplanner.examples.nqueens.domain.solution.QueenDifficultyWeightFactory;
import org.optaplanner.examples.nqueens.domain.solution.RowStrengthWeightFactory;

/** Dependencies used by sudoku example: **/
import java.io.Serializable;
import java.util.List;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

import org.optaplanner.examples.nqueens.domain.solution.SkyscraperDifficultyComparator;
import org.optaplanner.examples.nqueens.domain.solution.SkyscraperClueStrengthWeightFactory;

// Planning entity:
@PlanningEntity(difficultyComparatorClass = SkyscraperDifficultyComparator.class)
public class Cell implements Serializable {
    private int r_idx;
    private int c_idx;
    // private int entry;
    private Entry entry;



    /** Initialize cell: **/
    public Cell(int r_idx, int c_idx) {
        this.r_idx = r_idx;
        this.c_idx = c_idx;
        this.entry = new Entry();
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
    public void set_entry(int entry) {
        this.entry.set_entry_value(entry);
    }

    public int get_entry() {
        return this.entry.get_entry_value();
    }



    /** TODO: How do I work with this? **/
    @PlanningVariable(valueRangeProviderRefs = {"numberRange"},strengthWeightFactoryClass = SkyscraperClueStrengthWeightFactory.class)



    /** Return a string with the row index for debugging: **/
    @Override
    public String toString() {
        // "Cell[row, column, entry]":
        StringBuffer sb = new StringBuffer("Cell[" + this.get_row_idx() + ", "
                                                   + this.get_column_idx() + ", "
                                                   + this.get_entry() + "]");
        return sb.toString();
    }
}
