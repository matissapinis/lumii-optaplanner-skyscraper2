/*******************************************************************************************************************
Class implementing the planning entity (?) class of the OptaPlanner domain model for the Skyscraper Puzzle problem.

Sources:
1) ..\examples\sources\src\main\java\org\optaplanner\examples\cloudbalancing\domain\CloudProcess.java
2) https://docs.optaplanner.org/7.20.0.Final/optaplanner-docs/html_single/index.html#cloudBalancingClassProcess

Author:         Matīss Apinis
Date created:   2019/04/23
Date edited:    2019/05/13
*******************************************************************************************************************/

package org.optaplanner.examples.nqueens.domain;

/** Dependencies used by OptaPlanner examples: **/
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;
import org.optaplanner.examples.common.domain.AbstractPersistable;
import org.optaplanner.examples.nqueens.domain.solution.QueenDifficultyWeightFactory;
import org.optaplanner.examples.nqueens.domain.solution.RowStrengthWeightFactory;

/** Dependencies used by sudoku example: **/
import java.io.Serializable;
import java.util.List;

import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

/** TODO: Fix this dependency! **/
import org.optaplanner.examples.nqueens.domain.solution.SkyscraperDifficultyComparator;
import org.optaplanner.examples.nqueens.domain.solution.SkyscraperClueStrengthWeightFactory;

// Planning entity:
/** TODO: Fix this dependency! **/
@PlanningEntity(difficultyComparatorClass = SkyscraperDifficultyComparator.class)
/** TODO: Fix this dependency! **/
public class PuzzleCell implements Serializable {
    private int id;
    private static int count;
    /** TODO: Fix this dependency! **/
    private Row row;
    /** TODO: Fix this dependency! **/
    private Column col;
    /** TODO: Fix this dependency! **/
    private Side side;
    //private boolean fixed;
    //planning variable number
    /** TODO: Fix this dependency! **/
    private Clue clue;

    public PuzzleCell() { this(++count); }

    private PuzzleCell(int id){
        this.id = id;
        this.row = new Row();
        this.col = new Column();
        //this.number = new Number();
    }

    public int getId() { return id; }
    private Row getRow() { return row; }
    private Column getCol() { return col; }

    /** TODO: Fix this dependency! **/
    public Side getSide() { return side; }
    /** TODO: Fix this dependency! **/
    public int getSideIndex() { return getSide().getIndex(); }

    /** TODO: Fix this dependency! **/
    public void setSide(Side side) { this.side = side; }

    /** TODO: Fix this dependency! **/
    public void setRowIndex(int index) { getRow().setIndex(index); }

    /** TODO: Fix this dependency! **/
    @PlanningVariable(valueRangeProviderRefs = {"numberRange"},strengthWeightFactoryClass = SkyscraperClueStrengthWeightFactory.class)

    /** TODO: Fix this dependency! **/
    public Clue getClue() { return this.clue; }

    /** TODO: Fix this dependency! **/
    public void setClue(Clue clue){
        this.clue = clue;
        setCellClueInSide(clue);
    }

    /** TODO: Fix this dependency! **/
    private void setCellClueInSide(Clue clue) {}

    public int getRowIndex(){ return getRow().getIndex(); }

    public void setColumnIndex(int index){ getCol().setIndex(index); }
    public int getColIndex(){ return getCol().getIndex(); }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("Cell [row,col,region{" + row.getIndex() + "," + col.getIndex()
                + "," + getSideIndex() + "} ClueValue=> ");
        if (getClue() == null) {
            sb.append("null");
        } else {
            /** TODO: Fix this dependency! **/
            sb.append(getClue().getClueValue());
        }

        return sb.toString();
    }

    public int getCellClueValue(){
        if(getClue() == null) {
            return 0;
        } else {
            /** TODO: Fix this dependency! **/
            return getClue().getClueValue();
        }
    }

    public int getRowColNumberMultiplicand() { return getRowIndex() * getColIndex(); }
}
