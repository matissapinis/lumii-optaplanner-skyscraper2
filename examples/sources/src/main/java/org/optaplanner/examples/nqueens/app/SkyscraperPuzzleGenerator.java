package org.optaplanner.examples.nqueens.app;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.optaplanner.examples.nqueens.domain.Puzzle;
import org.optaplanner.examples.nqueens.domain.Cell;
import org.optaplanner.examples.nqueens.domain.Entry;

public class SkyscraperPuzzleGenerator {
    Puzzle puzzle = null;
    private List<Cell> cell_list;
    private List<Entry> entry_list;

    /** Previous approach with 2D grid of cells for O(1) operations:
    private Cell[][] grid;
    private Entry[][] entries;
    **/


    /** Initialize a skyscraper puzzle board: **/
    public Puzzle generate_puzzle() {
        this.puzzle = new Puzzle();
        this.puzzle.create_puzzle();

        return this.puzzle;
    }



    /// TODO: TBC
    /** Assign a set of clues to all sides: **/
    public Puzzle assign_puzzle_clues(int[] T_clues, int[] R_clues, int[] B_clues, int[] L_clues) {
        for (int i = 0; i < Skyscraper.row_count; i++) {
            for (int j = 0; j < Skyscraper.column_count; j++) {
                for (int ii = 0; ii < Skyscraper.cell_count; ii++) {
                    for (int jj = 0; jj < Skyscraper.cell_count; jj++) {
                        if (this.puzzle.get_cell_list().get(ii).get_row_idx() == i && this.puzzle.get_cell_list().get(jj).get_column_idx() == j) {
                            this.puzzle.get_cell_list().get(j).get_column().set_T_clue(T_clues[j]);
                            this.puzzle.get_cell_list().get(j).get_row().set_R_clue(R_clues[i]);
                            this.puzzle.get_cell_list().get(j).get_column().set_B_clue(B_clues[j]);
                            this.puzzle.get_cell_list().get(j).get_row().set_L_clue(L_clues[i]);
                        }
                    }
                }

                /** Previous approach with 2D grid of cells for O(1) operations:
                this.grid[i][j].get_column().set_T_clue(T_clues[j]);
                this.grid[i][j].get_row().set_R_clue(R_clues[i]);
                this.grid[i][j].get_column().set_B_clue(B_clues[j]);
                this.grid[i][j].get_row().set_L_clue(L_clues[i]);
                **/
            }
        }

        // this.puzzle.set_cell_list(this.cell_list); /// Unnecessary?

        /** Previous approach with 2D grid of cells for O(1) operations:
        this.puzzle.set_grid(this.grid); // Unnecessary?
        **/

        return this.puzzle;
    }
}
