/** Added from sudoku example (whole class): **/
package org.optaplanner.examples.nqueens.domain.solution;

import java.io.Serializable;
import java.util.Comparator;

import org.apache.commons.lang3.builder.CompareToBuilder;

public class SudokuDifficultyComparator implements Comparator<BoardCell>, Serializable {
    @Override
    public int compare(BoardCell a, BoardCell b) {
        return new CompareToBuilder()
                .append(a.getRowColNumberMultiplicand(), b.getRowColNumberMultiplicand())
                .append(a.getId(), b.getId()).toComparison();
    }
}
