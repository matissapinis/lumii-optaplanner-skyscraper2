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

/** TODO: Fix this dependency! **/
import org.optaplanner.examples.nqueens.app.Skyscraper;
// Planning solution:
@PlanningSolution
public class Puzzle implements Solution<SimpleScore> {
    int idx;

    /** TODO: Create my own planning entity! **/
    // Planning entity:
    private List<Row> rows;
    private List<Column> columns;
    private List<Cell> cells;

    /** TODO: How do I work with this? **/
    // Problem facts:
    // private List<Clue> clues;

    private SimpleScore score;

    /** Initialize puzzle board: **/
    private SkyscraperPuzzle(int idx) {
        this.idx = idx;
    }

    /** Set and get column index: **/
    /** TODO: What's the point of this method, if changing the index after the constructor has no use? **/
    public void set_idx(int idx) {
        this.idx = idx
    }

    public int get_idx() {
        return this.idx;
    }

    @PlanningEntityCollectionProperty
    /** TODO: Fix this dependency! **/
    /** Set and get puzzle board cells: **/
    public void set_cells(List<Cell> cells) {
        this.cells = cells;
    }

    public List<Cell> get_cells() {
        return cells;
    }

    @ValueRangeProvider(id = "numberRange")
    /** TODO: Fix this dependency! **/
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
