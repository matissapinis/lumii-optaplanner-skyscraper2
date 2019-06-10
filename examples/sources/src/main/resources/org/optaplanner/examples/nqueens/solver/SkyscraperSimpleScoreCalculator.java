package org.optaplanner.examples.nqueens.solver.move.factory;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.optaplanner.core.impl.heuristic.move.AbstractMove;
import org.optaplanner.core.impl.score.director.ScoreDirector;

import org.optaplanner.examples.nqueens.app.Skyscraper;
import org.optaplanner.examples.nqueens.domain.Puzzle;

import java.util.Collection;
import java.util.Collections;


public class SkyscraperSimpleScoreCalculator implements SimpleScoreCalculator<NQueens> {

    public SimpleScore calculateScore(Puzzle puzzle) {
        Cell[][] grid = puzzle.get_grid();
        Entry[][] grid = puzzle.get_entries();

        int total_score = 0;



        /** Decreasing score for each duplicate entry and for each entry out of bounds: **/
        int duplicate_score = 0;
        int bounds_score = 0;

        int[][] duplicate_counts = new int[Skyscraper.row_count][Skyscraper.column_count]; // Java initializes zeroes.

        for (int i = 0; i < Skyscraper.row_count; i++) {
            for (int j = 0; j < Skyscraper.column_count; j++) {
                /** Meanwhile also decrease score for cell entries out of ruled bounds: **/
                if (grid[i][j] < 0 || grid[i][j] > Skyscraper.row_count) {
                    bounds_score += -100;
                }

                duplicate_counts[i][grid[i][j] - 1]++;
            }
        }

        for (int i = 0; i < Skyscraper.row_count; i++) {
            for (int j = 0; j < Skyscraper.column_count; j++) {
                if (duplicate_counts[i][j] != 1) {
                    duplicate_score += -1; // Double-counting (e.g., {3,3,2,1} -> {1,1,2,0})? Use -0.5 float instead?
                }
            }
        }



        // TBC3:
        /** TODO: Decreasing score for each incorrect number of sighted skyscrapers: **/
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Queen leftQueen = queenList.get(i);
                Queen rightQueen = queenList.get(j);
                if (leftQueen.getRow() != null && rightQueen.getRow() != null) {
                    if (leftQueen.getRowIndex() == rightQueen.getRowIndex()) {
                        score--;
                    }

                    if (leftQueen.getAscendingDiagonalIndex() == rightQueen.getAscendingDiagonalIndex()) {
                        score--;
                    }

                    if (leftQueen.getDescendingDiagonalIndex() == rightQueen.getDescendingDiagonalIndex()) {
                        score--;
                    }
                }
            }
        }

        return SimpleScore.valueOf(score);
    }
}