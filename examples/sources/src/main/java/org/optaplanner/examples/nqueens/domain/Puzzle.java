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
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.Solution;
import org.optaplanner.core.api.domain.solution.drools.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.simple.SimpleScore;

import org.optaplanner.examples.common.domain.AbstractPersistable;
import org.optaplanner.examples.nqueens.app.Skyscraper;
import org.optaplanner.examples.nqueens.domain.Cell;
import org.optaplanner.examples.nqueens.domain.Entry;

// Planning solution:
@PlanningSolution
public class Puzzle extends AbstractPersistable {
    /** Approach with lists of problem fact and planning entity objects: **/
    // Problem fact:
    private List<Row> row_list;
    // Problem fact:
    private List<Column> column_list;

    // Planning entity:
    private List<Cell> cell_list;
    // Problem fact:
    private List<Entry> entry_list;


    /** Previous approach with 2D grid of cells for O(1) operations:
    private Cell[][] grid;
    private Entry[][] entries;
    **/

    /** Previous approach with O(n) cell operations:
    private List<Row> rows;
    private List<Column> columns;
    private List<Cell> cells;
    **/


    // Planning score:
    private SimpleScore score;



    /** Initialize puzzle board: **/
    public Puzzle() {
        /** Approach with lists of problem fact and planning entity objects: **/
        this.row_list = new ArrayList<Row>(Skyscraper.row_count);
        this.column_list = new ArrayList<Column>(Skyscraper.column_count);

        this.cell_list = new ArrayList<Cell>(Skyscraper.cell_count);
        this.entry_list = new ArrayList<Entry>(Skyscraper.entry_count);


        /** Previous approach with 2D grid of cells for O(1) operations:
        this.grid = new Cell[Skyscraper.row_count][Skyscraper.column_count];
        this.entries = new Entry[Skyscraper.row_count][Skyscraper.column_count];
        **/


        /** Previous approach with O(n) cell operations:
        this.rows = new ArrayList<Row>();
        this.columns = new ArrayList<Column>();
        this.cells = new ArrayList<Cell>();
        **/
    }



    /** Create puzzle board as grid of cells: **/
    public void create_puzzle() {
        /** Approach with lists of problem fact and planning entity objects: **/
        // Create 16 cells in respective rows and columns indexed from (0,0) to (3,3) with entries valued -1:
        for (int i = 0; i < Skyscraper.row_count; i++) {
            for (int j = 0; j < Skyscraper.column_count; j++) {
                Cell new_cell = new Cell(i, j);
                this.row_list.add(new_cell.get_row());
                this.column_list.add(new_cell.get_column());
                this.cell_list.add(new_cell);
                this.entry_list.add(new_cell.get_entry());
            }
        }


        /** Previous approach with 2D grid of cells for O(1) operations:
        // Initialize cells in grid with entry value -1:
        for (int i = 0; i < this.grid.length; i++) {
            for (int j = 0; j < this.grid[i].length; j++) {
                this.grid[i][j] = new Cell(i, j);
            }
        }
        **/


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



    /** Set and get row list: **/
    public void set_row_list(List<Row> row_list) {
        this.row_list = row_list;
    }

    @ProblemFactCollectionProperty
    public List<Row> get_row_list() {
        return row_list;
    }



    /** Set and get column list: **/
    public void set_column_list(List<Column> column_list) {
        this.column_list = column_list;
    }

    @ProblemFactCollectionProperty
    public List<Column> get_column_list() {
        return column_list;
    }



    /** Set and get cell list: **/
    public void set_cell_list(List<Cell> cell_list) {
        this.cell_list = cell_list;
    }

    @PlanningEntityCollectionProperty
    public List<Cell> get_cell_list() {
        return cell_list;
    }



    /** Set and get entry list: **/
    public void set_entry_list(List<Entry> entry_list) {
        this.entry_list = entry_list;
    }

    @ValueRangeProvider(id = "entry_value_range") // {"entry_value_range"})
    @ProblemFactCollectionProperty
    public List<Entry> get_entry_list() {
        return entry_list;
    }



    /** Set and get grid of cells: **/
    /** Previous approach with 2D grid of cells for O(1) operations:
    public void set_grid(Cell[][] grid) {
        this.grid = grid;
    }
    **/

    /**
    "Planner needs to extract the entity instances from the solution instance.
    It gets those collection(s) by calling every getter (or field) that is annotated with @PlanningEntityCollectionProperty:
    **/
    /**
    @PlanningEntityCollectionProperty
    public Cell[][] get_grid() {
        return this.grid;
    }
    **/



    /** Set and get puzzle board cell entry: **/
    public void set_cell_entry(Cell cell, Entry entry) {
        cell.set_entry(entry);

        /** Previous approach with 2D grid of cells for O(1) operations:
        public void set_cell_entry(int r_idx, int c_idx, Entry entry) {
        this.grid[r_idx][c_idx].set_entry(entry);
        **/


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

    public Entry get_cell_entry(Cell cell) {
        return cell.get_entry();

        /** Previous approach with 2D grid of cells for O(1) operations:
        public Entry get_cell_entry(int r_idx, int c_idx) {
        return this.grid[r_idx][c_idx].get_entry();
        **/

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



    /** Set and get puzzle board cell entry value: **/
    public void set_cell_entry_value(Cell cell, int value) {
        cell.get_entry().set_entry_value(value);

        /** Previous approach with 2D grid of cells for O(1) operations:
        public void set_cell_entry_value(int r_idx, int c_idx, int value) {
        this.grid[r_idx][c_idx].get_entry().set_entry_value(value);
        **/
    }

    public int get_cell_entry_value(Cell cell) {
        return cell.get_entry().get_entry_value();

        /** Previous approach with 2D grid of cells for O(1) operations:
        public int get_cell_entry_value(int r_idx, int c_idx) {
        return this.grid[r_idx][c_idx].get_entry().get_entry_value();
        **/
    }



    /** Set and get grid of entries: **/
    /** Previous approach with 2D grid of cells for O(1) operations:
    public void set_entries(Entry[][] entries) {
        this.entries = entries;
    }
    **/

    /**
    The valueRangeProviderRefs property defines what are the possible planning values for this planning variable.
    It references one or more @ValueRangeProvider id's.
    **/
    /** Previous approach with 2D grid of cells for O(1) operations:
    public Entry[][] get_entries() {
        return this.entries;
    }
    **/



    /** Set and get the planning solution score: **/
    public void setScore(SimpleScore score) {
        this.score = score;
    }

    @PlanningScore
    public SimpleScore getScore() {
        return score;
    }



    /** Get a cell from the grid by its row and column indices: **/
    public Cell get_cell_by_indices(int r_idx, int c_idx) {
        for (int i = 0; i < Skyscraper.row_count; i++) {
             for (int j = 0; j < Skyscraper.column_count; i++) {
                 Cell target_cell = this.cell_list.get(i);

                 boolean row_match = (target_cell.get_row_idx() == r_idx);
                 boolean column_match = (target_cell.get_column_idx() == c_idx);

                 if (row_match && column_match) {
                     return target_cell;
                 }
             }
        }
        return null;

        /** Previous approach with 2D grid of cells for O(1) operations:
        return this.grid[r_idx][c_idx];
        **/
    }
}
