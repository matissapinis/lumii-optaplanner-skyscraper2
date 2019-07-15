package org.optaplanner.examples.nqueens.solver;

import org.optaplanner.core.impl.score.director.easy.EasyScoreCalculator;
import org.optaplanner.core.api.score.buildin.simple.SimpleScore;
import org.optaplanner.examples.nqueens.app.Skyscraper;
import org.optaplanner.examples.nqueens.domain.Cell;
import org.optaplanner.examples.nqueens.domain.Entry;
import org.optaplanner.examples.nqueens.domain.Puzzle;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

// import org.optaplanner.core.api.domain.solution.PlanningScore;


public class SkyscraperEasyScoreCalculator implements EasyScoreCalculator<Puzzle> {

    public SimpleScore calculateScore(Puzzle puzzle) {
        // @PlanningScore
        int total_score = 0;

        List<Cell> cell_list = puzzle.get_cell_list();
        List<Entry> entry_list = puzzle.get_entry_list();

        /** Previous approach with 2D grid of cells for O(1) operations:
        Cell[][] grid = puzzle.get_grid();
        Entry[][] entries = puzzle.get_entries();
        **/

        /** Put all the cells and entries into 2D grids for O(1) operations: **/
        Cell[][] grid = new Cell[Skyscraper.row_count][Skyscraper.column_count];
        Entry[][] entries = new Entry[Skyscraper.row_count][Skyscraper.column_count];

        for (int c = 0; c < cell_list.size(); c++) {
            for (int i = 0; i < Skyscraper.row_count; i++) {
                for (int j = 0; j < Skyscraper.column_count; j++) {
                    if (cell_list.get(c).get_row_idx() == i && cell_list.get(c).get_column_idx() == j) {
                        grid[i][j] = cell_list.get(c);
                        entries[i][j] = entry_list.get(c);
                    }
                }
            }
        }


        /** Decreasing score for each duplicate entry and for each entry out of bounds: **/
        int bounds_score = 0;
        int duplicate_score = 0;

        int[][] duplicate_counts = new int[Skyscraper.row_count][Skyscraper.column_count]; // Java initializes zeroes.

        for (int i = 0; i < Skyscraper.row_count; i++) {
            for (int j = 0; j < Skyscraper.column_count; j++) {
                /** Meanwhile also decrease score for cell entries out of ruled bounds: **/
                if (entries[i][j].get_entry_value() < 0 || entries[i][j].get_entry_value() > Skyscraper.row_count) {
                    bounds_score += -100;
                }

                duplicate_counts[i][entries[i][j].get_entry_value() - 1]++;
            }
        }

        for (int i = 0; i < Skyscraper.row_count; i++) {
            for (int j = 0; j < Skyscraper.column_count; j++) {
                if (duplicate_counts[i][j] != 1) {
                    duplicate_score += -1; // Double-counting (e.g., {3,3,2,1} -> {1,1,2,0})? Use -0.5 float instead?
                }
            }
        }



        /** Decreasing score for each incorrect number of sighted skyscrapers along axis: **/
        int sight_score = 0;

        int[] L_sight_count = new int[Skyscraper.row_count];
        Arrays.fill(L_sight_count, 1);
        int[] T_sight_count = new int[Skyscraper.column_count];
        Arrays.fill(T_sight_count, 1);

        int[] R_sight_count = new int[Skyscraper.row_count];
        Arrays.fill(R_sight_count, 1);
        int[] B_sight_count = new int[Skyscraper.column_count];
        Arrays.fill(B_sight_count, 1);

        for (int i = 1, ii = Skyscraper.row_count - 1; i < Skyscraper.row_count + 1; i++, ii--) {
            for (int j = 1, jj = Skyscraper.column_count - 1; j < Skyscraper.column_count + 1; j++, jj--) {
                // Checks all rows left to right:
                if (entries[i - 1][j - 1].get_entry_value() < entries[i - 1][j].get_entry_value()) {
                    L_sight_count[i - 1]++;
                }

                // Checks all columns top to bottom:
                if (entries[j - 1][i - 1].get_entry_value() < entries[j][i - 1].get_entry_value()) {
                    T_sight_count[j - 1]++;
                }

                // Checks all rows right to left:
                if (entries[ii][jj].get_entry_value() < entries[ii][jj - 1].get_entry_value()) {
                    R_sight_count[ii]++;
                }

                // Checks all columns bottom to left;
                if (entries[jj][ii].get_entry_value() < entries[jj - 1][ii].get_entry_value()) {
                    B_sight_count[jj]++;
                }
            }
        }

        for (int i = 0; i < Skyscraper.row_count; i++) {
            if (R_sight_count[i] != grid[i][0].get_row().get_R_clue()) {
                sight_score += -1 * Math.abs(R_sight_count[i] - grid[i][0].get_row().get_R_clue());
            }

            if (L_sight_count[i] != grid[i][0].get_row().get_L_clue()) {
                sight_score += -1 * Math.abs(L_sight_count[i] - grid[i][0].get_row().get_L_clue());
            }

            if (T_sight_count[i] != grid[0][i].get_column().get_T_clue()) {
                sight_score += -1 * Math.abs(T_sight_count[i] - grid[0][i].get_column().get_T_clue());
            }

            if (B_sight_count[i] != grid[0][i].get_column().get_B_clue()) {
                sight_score += -1 * Math.abs(B_sight_count[i] - grid[0][i].get_column().get_B_clue());
            }
        }



        /** Returns the total score as sum of penalties: **/
        total_score = bounds_score + duplicate_score + sight_score;
        return SimpleScore.valueOf(total_score);
    }
}