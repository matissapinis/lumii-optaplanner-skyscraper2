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
    private Cell[][] grid;
    private Entry[][] entries;



    /** Initialize a skyscraper puzzle board: **/
    public Puzzle generate_puzzle() {
        this.puzzle = new Puzzle();
        this.puzzle.create_puzzle();

        return this.puzzle;
    }



    /** Assign a set of clues to all sides: **/
    public Puzzle assign_puzzle_clues(int[] T_clues, int[] R_clues, int[] B_clues, int[] L_clues) {
        for (int i = 0; i < Skyscraper.row_count; i++) {
            for (int j = 0; j < Skyscraper.column_count; j++) {
                this.grid[i][j].get_column().set_T_clue(T_clues[j]);
                this.grid[i][j].get_row().set_R_clue(R_clues[i]);
                this.grid[i][j].get_column().set_B_clue(B_clues[j]);
                this.grid[i][j].get_row().set_L_clue(L_clues[i]);
            }
        }
        this.puzzle.set_grid(this.grid); // Unnecessary?
        return this.puzzle;
    }
}
