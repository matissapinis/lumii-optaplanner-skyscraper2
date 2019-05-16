package org.optaplanner.examples.nqueens.solver.move.factory;

import java.util.Collection;
import java.util.Collections;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.optaplanner.core.impl.heuristic.move.AbstractMove;
import org.optaplanner.core.impl.heuristic.move.Move;
import org.optaplanner.core.impl.score.director.ScoreDirector;

import org.optaplanner.examples.nqueens.app.Skyscraper;
import org.optaplanner.examples.nqueens.domain.PuzzleCell;
import org.optaplanner.examples.nqueens.domain.Clue;
import org.optaplanner.examples.nqueens.domain.SkyscraperPuzzle;

/**
[This class] is not abstract and does not override abstract method in [OptaPlanner cores files for heuristics].
**/
public class SkyscraperClueChangeMove extends AbstractMove<SkyscraperPuzzle> {
    private PuzzleCell cell;
    private Clue toClue;

    public SkyscraperClueChangeMove(PuzzleCell cell, Clue toClue) {
        super();
        this.cell = cell;
        this.toClue = toClue;
    }

    @Override
    public boolean isMoveDoable(ScoreDirector scoreDirector) {
        return !ObjectUtils.equals(cell.getClue(), toClue);
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
    public SkyscraperClueChangeMove createUndoMove(ScoreDirector scoreDirector) { return new SkyscraperClueChangeMove(cell, cell.getClue()); }

    @Override
    public Collection<? extends Object> getPlanningEntities() {
        return Collections.singletonList(cell);
    }

    @Override
    public Collection<? extends Object> getPlanningValues() {
        return Collections.singletonList(toClue);
    }

    @Override
    protected void doMoveOnGenuineVariables(ScoreDirector scoreDirector) {
        scoreDirector.beforeVariableChanged(cell, "clue");
        cell.setClue(toClue);
        scoreDirector.afterVariableChanged(cell, "clue");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) { return true; }
        else if (o instanceof SkyscraperClueChangeMove) {
            SkyscraperClueChangeMove other = (SkyscraperClueChangeMove) o;
            return new EqualsBuilder()
                    .append(cell, other.cell)
                    .append(toClue, other.toClue)
                    .isEquals();
        } else { return false; }
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(cell)
                .append(toClue)
                .toHashCode();
    }

    @Override
    public String toString() {
        return cell + " {" + cell.getClue() + " -> " + toClue + "}";
    }
}
