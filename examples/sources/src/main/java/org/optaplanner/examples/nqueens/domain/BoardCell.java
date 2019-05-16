/** Added from sudoku example (whole class): **/
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

import org.optaplanner.examples.nqueens.domain.solution.SudokuDifficultyComparator;
import org.optaplanner.examples.nqueens.domain.solution.SudokuNumberStrengthWeightFactory;

//Planning Entity
@PlanningEntity(difficultyComparatorClass = SudokuDifficultyComparator.class)
public class BoardCell implements Serializable {
    private int id;
    private static int count;
    private Row row;
    private Column col;
    private Region region;
    //private boolean fixed;
    //planning variable number
    private Number number;

    public BoardCell() { this(++count); }

    private BoardCell(int id){
        this.id = id;
        this.row = new Row();
        this.col = new Column();
        //this.number = new Number();
    }

    public int getId() { return id; }
    private Row getRow() { return row; }
    private Column getCol() { return col; }

    public Region getRegion() { return region; }
    public int getRegionIndex() { return getRegion().getIndex(); }

    public void setRegion(Region region) { this.region = region; }

    public void setRowIndex(int index) { getRow().setIndex(index); }

    @PlanningVariable(valueRangeProviderRefs = {"numberRange"},strengthWeightFactoryClass = SudokuNumberStrengthWeightFactory.class)

    public Number getNumber() { return this.number; }

    public void setNumber(Number number){
        this.number = number;
        setCellNumberInRegion(number);
    }

    private void setCellNumberInRegion(Number number) {}

    public int getRowIndex(){ return getRow().getIndex(); }

    public void setColumnIndex(int index){ getCol().setIndex(index); }
    public int getColIndex(){ return getCol().getIndex(); }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("Cell [row,col,region{" + row.getIndex() + "," + col.getIndex()
                + "," + getRegionIndex() + "} NumberValue=> ");
        if (getNumber() == null) {
            sb.append("null");
        } else {
            sb.append(getNumber().getNumberValue());
        }

        return sb.toString();
    }

    public int getCellNumberValue(){
        if(getNumber() == null) {
            return 0;
        } else {
            return getNumber().getNumberValue();
        }
    }

    public int getRowColNumberMultiplicand() { return getRowIndex()*getColIndex(); }
}
