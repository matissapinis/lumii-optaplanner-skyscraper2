package org.optaplanner.examples.nqueens.solver.move.factory;

import java.util.Collection;
import java.util.Collections;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.optaplanner.core.impl.heuristic.move.AbstractMove;
import org.optaplanner.core.impl.score.director.ScoreDirector;

import org.optaplanner.examples.nqueens.domain.SudokuBoard;

/**
[This class] is not abstract and does not override abstract method in [OptaPlanner cores files for heuristics].
**/
// Previously: No <SudokuBoard>
public class SudokuNumberChangeMove extends AbstractMove<SudokuBoard> {
    private BoardCell cell;
    private Number toNumber;

    public SudokuNumberChangeMove(BoardCell cell, Number toNumber) {
        super();
        this.cell = cell;
        this.toNumber = toNumber;
    }

    @Override
    public boolean isMoveDoable(ScoreDirector scoreDirector) {
        return !ObjectUtils.equals(cell.getNumber(), toNumber);
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
    public SudokuNumberChangeMove createUndoMove(ScoreDirector scoreDirector) { return new SudokuNumberChangeMove(cell, cell.getNumber()); }

    @Override
    public Collection<? extends Object> getPlanningEntities() {
        return Collections.singletonList(cell);
    }

    @Override
    public Collection<? extends Object> getPlanningValues() {
        return Collections.singletonList(toNumber);
    }

    @Override
    protected void doMoveOnGenuineVariables(ScoreDirector scoreDirector) {
        scoreDirector.beforeVariableChanged(cell, "number");
        cell.setNumber(toNumber);
        scoreDirector.afterVariableChanged(cell, "number");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        else if (o instanceof SudokuNumberChangeMove) {
            SudokuNumberChangeMove other = (SudokuNumberChangeMove) o;
            return new EqualsBuilder()
                    .append(cell, other.cell)
                    .append(toNumber, other.toNumber)
                    .isEquals();
        } else { return false; }
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(cell)
                .append(toNumber)
                .toHashCode();
    }

    @Override
    public String toString() {
        return cell + " {" + cell.getNumber() + " -> " + toNumber + "}";
    }
}
