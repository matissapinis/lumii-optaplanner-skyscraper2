package org.optaplanner.examples.nqueens.solver.move.factory;

import org.optaplanner.core.impl.heuristic.move.Move;
import org.optaplanner.core.impl.heuristic.selector.move.factory.MoveListFactory;

import java.util.ArrayList;
import java.util.List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.optaplanner.core.impl.heuristic.move.Move;
import org.optaplanner.core.impl.heuristic.selector.move.factory.MoveListFactory;

import org.optaplanner.examples.nqueens.domain.BoardCell;
import org.optaplanner.examples.nqueens.domain.SudokuBoard;
import org.optaplanner.examples.nqueens.domain.Number;

/**
Previously (prior to reboot when Maven compilation worked):
    'createUndoMove(ScoreDirector)' in 'org.optaplanner.examples.nqueens.solver.move.factory.SudokuNumberChangeMove'
    clashes with 'createUndoMove(ScoreDirector<Solution_>)' in 'org.optaplanner.core.impl.heuristic.move.AbstractMove';
    attempting to use incompatible return type
**/

/**
[This class] is not abstract and does not override abstract method in [OptaPlanner cores files for heuristics].
**/
public class SudokuMoveChangeFactory implements MoveListFactory<SudokuBoard> {
    /**
    [This method] does not override or implement a method from a supertype.
    **/
    @Override
    /**
    [This method] cannot implement [the method in OptaPlanner cores files for heuristics].
    **/
    // Previously: <? extends Move> etc.
    public List<? extends SudokuNumberChangeMove> createMoveList(SudokuBoard solution) {
        // TODO Auto-generated method stub
        List<SudokuNumberChangeMove> moveList = new ArrayList<SudokuNumberChangeMove>();
        for (BoardCell cell:solution.getCells()) {
            for (Number toNumber : solution.getNumbers()) {
                moveList.add(new SudokuNumberChangeMove(cell, toNumber));
            }
        }
        return moveList;
    }
}

