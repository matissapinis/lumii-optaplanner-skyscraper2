package org.optaplanner.examples.nqueens.solver.move.factory;

import org.optaplanner.core.impl.heuristic.selector.move.factory.MoveListFactory;

import java.util.ArrayList;
import java.util.List;

import org.optaplanner.examples.nqueens.app.Skyscraper;
import org.optaplanner.examples.nqueens.domain.Cell;
import org.optaplanner.examples.nqueens.domain.Entry;
import org.optaplanner.examples.nqueens.domain.Puzzle;
import org.optaplanner.examples.nqueens.solver.move.factory.SkyscraperClueChangeMove;

/**
[This class] is not abstract and does not override abstract method in [OptaPlanner cores files for heuristics].
**/

public class SkyscraperMoveChangeFactory implements MoveListFactory<Puzzle> {
    /**
    [This method] does not override or implement a method from a supertype.
    **/
    /**
    [This method] cannot implement [the method in OptaPlanner cores files for heuristics].
    **/
    // Previously: <? extends Move> etc.
    @Override
    public List<? extends SkyscraperClueChangeMove> createMoveList(Puzzle solution) {
        // TODO Auto-generated method stub
        Cell[][] grid = solution.get_grid();
        Entry[][] entries = solution.get_entries();
        List<SkyscraperClueChangeMove> moveList = new ArrayList<SkyscraperClueChangeMove>();
        for (int i = 0; i < Skyscraper.row_count; i++) {
            for (int j = 0; j < Skyscraper.column_count; j++) {
                moveList.add(new SkyscraperClueChangeMove(grid[i][j], entries[i][j]));
            }
        }

        return moveList;
    }
}