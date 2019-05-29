package org.optaplanner.examples.nqueens.solver.move.factory;

import org.optaplanner.core.impl.heuristic.selector.move.factory.MoveListFactory;

import java.util.ArrayList;
import java.util.List;

import org.optaplanner.examples.nqueens.domain.PuzzleCell;

/**
Previously (prior to reboot when Maven compilation worked):
'createUndoMove(ScoreDirector)' in 'org.optaplanner.examples.nqueens.solver.move.factory.SudokuNumberChangeMove'
clashes with 'createUndoMove(ScoreDirector<Solution_>)' in 'org.optaplanner.core.impl.heuristic.move.AbstractMove';
attempting to use incompatible return type
**/

/**
[This class] is not abstract and does not override abstract method in [OptaPlanner cores files for heuristics].
**/

public class SkyscraperMoveChangeFactory implements MoveListFactory<SkyscraperPuzzle> {
    /**
    [This method] does not override or implement a method from a supertype.
    **/
    @Override
    /**
    [This method] cannot implement [the method in OptaPlanner cores files for heuristics].
    **/
    // Previously: <? extends Move> etc.
    public List<? extends SkyscraperClueChangeMove> createMoveList(SkyscraperPuzzle solution) {
        // TODO Auto-generated method stub
        List<SkyscraperClueChangeMove> moveList = new ArrayList<SkyscraperClueChangeMove>();
        for (PuzzleCell cell:solution.getCells()) {
            for (Clue toClue : solution.getClues()) {
                moveList.add(new SkyscraperClueChangeMove(cell, toClue));
            }
        }
        return moveList;
    }
}