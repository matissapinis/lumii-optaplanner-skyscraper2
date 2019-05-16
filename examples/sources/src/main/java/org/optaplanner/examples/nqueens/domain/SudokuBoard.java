/** Added from sudoku example (whole class): **/
package org.optaplanner.examples.nqueens.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.Solution;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.simple.SimpleScore;

import org.optaplanner.examples.nqueens.app.Sudoku;

//Planning Solution
@PlanningSolution
public class SudokuBoard implements Solution<SimpleScore> {
    int id;
    static int count;
    //planning entity
    private List<BoardCell> cells;
    private List<Region> regions;
    //problem facts
    private List<Number> numbers;

    private SimpleScore score;

    public SudokuBoard() { this(++count); }
    private SudokuBoard(int count){ this.id = count; }
    public int getId(){ return id; }

    @PlanningEntityCollectionProperty
    public List<BoardCell> getCells() { return cells; }

    public void setCells(List<BoardCell> cells) { this.cells = cells; }

    @ValueRangeProvider(id = "numberRange")
    public List<Number> getNumbers() { return numbers; }

    public void setNumbers(List<Number> numbers) { this.numbers = numbers; }

    public SimpleScore getScore() { return score; }

    public void setScore(SimpleScore score) { this.score = score; }
    public List<Region> getRegions() { return regions; }
    public void setRegions(List<Region> regions) { this.regions = regions; }

    @Override
    public Collection<? extends Object> getProblemFacts() {
        List<Object> facts = new ArrayList<Object>();
        facts.addAll(numbers);

        // Do not add the planning entity's (cells) because that will be done automatically
        return facts;
    }

    public BoardCell getCell(int rowIndex, int colIndex){
        BoardCell cellToReturn = null;
        if ((rowIndex < 1 || rowIndex > Sudoku.maxNumberOfRows) ||
            (colIndex < 1 || colIndex > Sudoku.maxNumberOfColums)) {
            throw new IllegalArgumentException("Row index or Col index is out of bound!");
        }
        for (Iterator iterator = cells.iterator(); iterator.hasNext();) {
            BoardCell cell = (BoardCell) iterator.next();
            if (cell.getRowIndex()==rowIndex && cell.getColIndex()==colIndex) {
                cellToReturn = cell;
                break;
            }
        }
        return cellToReturn;
    }
}
