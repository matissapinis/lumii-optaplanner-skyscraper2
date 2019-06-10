package org.optaplanner.examples.nqueens.solver.move.factory;

import java.util.Collection;
import java.util.Collections;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.optaplanner.core.impl.heuristic.move.AbstractMove;
import org.optaplanner.core.impl.score.director.ScoreDirector;

import org.optaplanner.examples.nqueens.domain.Cell;
import org.optaplanner.examples.nqueens.domain.Puzzle;
import org.optaplanner.examples.nqueens.domain.Entry;

/**
[This class] is not abstract and does not override abstract method in [OptaPlanner cores files for heuristics].
**/
public class SkyscraperClueChangeMove extends AbstractMove<Puzzle> {
    private Cell cell;
    private Entry toEntry;



    /** Initializes the planning items for changing moves: **/
    public SkyscraperClueChangeMove(Cell cell, Entry toEntry) {
        super();
        this.cell = cell;
        this.toEntry = toEntry;
    }



    /** Returns whether two entries are equal: **/
    @Override
    public boolean isMoveDoable(ScoreDirector scoreDirector) {
        return !ObjectUtils.equals(cell.get_entry(), toEntry);
    }




    /**
    [This method] does not override or implement a method from a supertype.
    **/
    @Override
    /**
    [This method] cannot implement [the method in OptaPlanner cores files for heuristics
    with their return types being incompatible].
    **/
    // Previously: Move (type)
    public SkyscraperClueChangeMove createUndoMove(ScoreDirector scoreDirector) {
        return new SkyscraperClueChangeMove(cell, cell.get_entry());
    }



    /** Returns the set of planning entities: **/
    @Override
    public Collection<? extends Object> getPlanningEntities() {
        return Collections.singletonList(cell);
    }



    /** Returns the set of planning values: **/
    @Override
    public Collection<? extends Object> getPlanningValues() {
        return Collections.singletonList(toEntry);
    }



    /** TODO: Not sure what this does: **/
    @Override
    protected void doMoveOnGenuineVariables(ScoreDirector scoreDirector) {
        scoreDirector.beforeVariableChanged(cell, "entry");
        cell.set_entry(toEntry);
        scoreDirector.afterVariableChanged(cell, "entry");
    }



    /** Returns whether two objects are equal or not: **/
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        else if (o instanceof SkyscraperClueChangeMove) {
            SkyscraperClueChangeMove other = (SkyscraperClueChangeMove) o;
            return new EqualsBuilder()
                    .append(cell, other.cell)
                    .append(toEntry, other.toEntry)
                    .isEquals();
        } else {
            return false;
        }
    }



    /** TODO: Don't know what this is for: **/
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(cell)
                .append(toEntry)
                .toHashCode();
    }



    /** Return a string with the cell information and the entries being changed: **/
    @Override
    public String toString() {
        return cell + " {" + cell.get_entry() + " -> " + toEntry + "}";
    }
}
