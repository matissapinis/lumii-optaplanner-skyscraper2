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

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.Solution;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.simple.SimpleScore;

import org.optaplanner.examples.nqueens.app.Skyscraper;

// Planning solution:
@PlanningSolution
public class Puzzle implements Solution<SimpleScore> {
    // Planning entity:
    /** Approach with 2D grid of cells for O(1) operations: **/
    private Cell[][] grid;
    private Entry[][] entries;


    /** Previous approach with O(n) cell operations:
    private List<Row> rows;
    private List<Column> columns;
    private List<Cell> cells;
    **/

    private SimpleScore score;



    /** Initialize puzzle board: **/
    private Puzzle() {
        /** Approach with 2D grid of cells for O(1) operations: **/
        /** TODO: How to create a 2D array of objects in Java? **/
        this.grid = new ArrayList[Skyscraper.row_count][Skyscraper.column_count];
        this.entries = new ArrayList[Skyscraper.row_count][Skyscraper.column_count];


        /** Previous approach with O(n) cell operations:
        this.rows = new ArrayList<Row>();
        this.columns = new ArrayList<Column>();
        this.cells = new ArrayList<Cell>();
        **/
    }



    /** Create puzzle board as grid of cells: **/
    private void create_puzzle() {
        /** Approach with 2D grid of cells for O(1) operations: **/
        // Initialize cells in grid with entry value -1:
        for (int i = 0; i < Skyscraper.row_count; i++) {
            for (int j = 0; j < Skyscraper.column_count; j++) {
                grid[i][j] = new Cell(i, j);
            }
        }


        /** Previous approach with O(n) cell operations:
        // Create 4 rows indexed from 0 to 3:
        for (int i = 0; i < Skyscraper.row_count; i++) {
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
                this.cells.add(new_cell);
            }
         }
         **/
    }



    /** Set and get grid of cells: **/
    public void set_grid(Cell[][] grid) {
        this.grid = grid;
    }

    /**
    "Planner needs to extract the entity instances from the solution instance.
    It gets those collection(s) by calling every getter (or field) that is annotated with @PlanningEntityCollectionProperty:
    **/
    @PlanningEntityCollectionProperty
    public Cell[][] get_grid() {
        return this.grid;
    }



    /** Set and get puzzle board cell entry: **/
    public void set_cell_entry(int r_idx, int c_idx, int entry) {
        /** Approach with 2D grid of cells for O(1) operations: **/
        this.grid[r_idx][c_idx].set_entry(entry);


        /** Previous approach with O(n) cell operations:
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
        **/
    }

    public int get_cell_entry(int r_idx, int c_idx, int entry) {
        /** Approach with 2D grid of cells for O(1) operations: **/
        return this.grid[r_idx][c_idx].get_entry();

        /** Previous approach with O(n) cell operations:
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
        **/
    }


    /**
    The valueRangeProviderRefs property defines what are the possible planning values for this planning variable.
    It references one or more @ValueRangeProvider id's.
    **/
    @ValueRangeProvider(id = "entry_value_range")
    public Entry[][] get_entries() {

    }

    public SimpleScore getScore() {
        return score;
    }

    public void setScore(SimpleScore score) {
        this.score = score;
    }

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
