/*******************************************************************************************************************
Class implementing the general OptaPlanner domain model for the Skyscraper Puzzle problem.

Sources:
1) ..\examples\sources\src\main\java\org\optaplanner\examples\cloudbalancing\domain\CloudBalance.java
2) https://docs.optaplanner.org/7.20.0.Final/optaplanner-docs/html_single/index.html#cloudBalancingClassCloudBalance

Author:         Matīss Apinis
Date created:   2019/05/28
Date edited:    2019/05/28

Notes:
* The CloudBalance class has a @PlanningSolution annotation.
* It holds a list of all computers and a list of all processes.
* It represents both the planning problem and (if it is initialized) the planning solution.
* To save a solution, Planner initializes a new instance of the class.
*******************************************************************************************************************/

package org.optaplanner.examples.nqueens.domain;

import java.util.List;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.Solution;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.simple.SimpleScore;

import org.optaplanner.examples.nqueens.app.Skyscraper;

// Planning solution:
@PlanningSolution
public class Puzzle implements Solution<SimpleScore> {
    /** TODO: Create my own planning entity! **/
    // Planning entity:
    private List<Row> rows;
    private List<Column> columns;
    private List<Cell> cells;

    private SimpleScore score;

    /** Initialize puzzle board: **/
    private Puzzle() {
        this.rows = new ArrayList<Row>();
        this.columns = new ArrayList<Column>();
        this.cells = new ArrayList<Cell>();
    }

    /** Create puzzle rows, columns and cells assigned to them: **/
    private void create_puzzle() {
        // Create 4 rows indexed from 0 to 3:
        for (int i = 0; i < Skyscraper.row_count; i++) {
<<<<<<< HEAD
            Row new_row = new Row();
            new_row.set_idx(i);
            this.rows.add(new_row);
        }

        // Create 4 columns indexed from 0 to 3:
        for (int i = 0; i < Skyscraper.column_count; i++) {
            Column new_column = new Column();
            new_column.set_idx(i);
            this.columns.add(new_column);
        }

        // Create 16 cells indexed from (0,0) to (3,3):
        for (int i = 0; i < Skyscraper.row_count; i++) {
            for (int j = 0; j < Skyscraper.column_count; j++) {
                Cell new_cell = new Cell(i, j);
=======
            new_row = new Row();
            new_row.set_idx(i);
            this.rows.add(new_row);
        }

        // Create 4 columns indexed from 0 to 3:
        for (int i = 0; i < Skyscraper.column_count; i++) {
            new_column = new Column();
            new_column.set_idx(i);
            this.columns.add(new_column);
        }

        // Create 16 cells indexed from (0,0) to (3,3):
        for (int i = 0; i < Skyscraper.row_count; i++) {
            for (int j = 0; j < Skyscraper.column_count; j++) {
                new_cell = new Cell(i, j);
>>>>>>> skyscraper3
                this.cells.add(new_cell);
            }
        }
    }

    @PlanningEntityCollectionProperty
    /** Set and get puzzle board cell entry: **/
<<<<<<< HEAD
    public void set_cell_entry(int r_idx, int c_idx, int entry) {
        /** TODO: Charge to an OOP model with O(1) cell look-up instead of O(n). **/
        for (int i = 0; i < Skyscraper.row_count; i++) {
            for (int j = 0; j < Skyscraper.column_count; i++) {
                Cell target_cell = this.cells.get(i);

                boolean row_match = (target_cell.get_row_idx() == r_idx);
                boolean column_match = (target_cell.get_column_idx() == c_idx);

                if (row_match && column_match) {
                    target_cell.set_entry(entry);
                }
            }
        }
    }

    public int get_cell_entry(int r_idx, int c_idx, int entry) {
        for (int i = 0; i < Skyscraper.row_count; i++) {
            for (int j = 0; j < Skyscraper.column_count; i++) {
                Cell target_cell = this.cells.get(i);

                boolean row_match = (target_cell.get_row_idx() == r_idx);
                boolean column_match = (target_cell.get_column_idx() == c_idx);

                if (row_match && column_match) {
                    return target_cell.get_entry();
                }
            }
        }
=======
    public void set_cell_entry(int r_idx, int c_idx) {

>>>>>>> skyscraper3
    }

    /// TBC:

    public List<Cell> get_cells() {
        return cells;
    }

    @ValueRangeProvider(id = "numberRange")
    /** TODO: Fix these dependencies! **/
    public List<Clue> getClues() { return clues; }
    /** TODO: Fix this dependency! **/
    public void setClues(List<Clue> clues) { this.clues = clues; }

    public SimpleScore getScore() { return score; }

    public void setScore(SimpleScore score) { this.score = score; }

    public List<Side> getSides() { return sides; }
    public void setSides(List<Side> sides) { this.sides = sides; }

    @Override
    public Collection<? extends Object> getProblemFacts() {
        List<Object> facts = new ArrayList<Object>();
        facts.addAll(clues);

        // Do not add the planning entity's (cells) because that will be done automatically
        return facts;
    }

    /** TODO: Fix this dependency! **/
    public PuzzleCell getCell(int rowIndex, int colIndex){
        PuzzleCell cellToReturn = null;
        /** TODO: Fix this dependency! **/
        if ((rowIndex < 1 || rowIndex > Skyscraper.maxNumberOfRows) ||
                (colIndex < 1 || colIndex > Skyscraper.maxNumberOfColumns)) {
            throw new IllegalArgumentException("Row index or Col index is out of bound!");
        }

        for (Iterator iterator = cells.iterator(); iterator.hasNext();) {
            PuzzleCell cell = (PuzzleCell) iterator.next();
            /** TODO: Fix this dependency! **/
            if (cell.getRowIndex() == rowIndex && cell.getColIndex() == colIndex) {
                cellToReturn = cell;
                break;
            }
        }
        return cellToReturn;
    }
}
