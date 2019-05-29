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
    private int idx;
    private Row row;
    private Column column;
    private int entry;

    /** Initialize cell: **/
    private Cell(int idx){
        this.idx = idx;
        this.row = new Row();
        this.column = new Column();
        this.entry = 0;
    }

    /** Set and get cell index: **/
    public void set_idx(int idx) {
        this.idx = idx;
    }

    public int get_idx() {
        return this.idx;
    }

    /** Set and get cell row index: **/
    public void set_row_idx(int idx) {
        this.row.set_idx(idx);
    }

    private int get_row_idx() {
        return this.row.get_idx();
    }

    /** Set and get cell column index: **/
    public void set_column_idx(int idx) {
        this.column.set_idx(idx);
    }

    private int get_column_idx() {
        return this.column.get_idx();
    }

    /** Set and get cell entry value: **/
    public void set_entry(int entry) {
        this.entry = entry;
    }

    public int get_entry() {
        return this.entry;
    }

    /** TODO: How do I work with this? **/
    @PlanningVariable(valueRangeProviderRefs = {"numberRange"},strengthWeightFactoryClass = SkyscraperClueStrengthWeightFactory.class)

    /** TODO: What is this used for? Is this necessary? **/
    @Override
    public String toString() {
        // "Cell[row, column, entry]":
        StringBuffer sb = new StringBuffer("Cell[" + this.get_row_idx() + ", "
                                                   + this.get_column_idx() + ", "
                                                   + this.get_entry() + "]");
        return sb.toString();
    }
}
