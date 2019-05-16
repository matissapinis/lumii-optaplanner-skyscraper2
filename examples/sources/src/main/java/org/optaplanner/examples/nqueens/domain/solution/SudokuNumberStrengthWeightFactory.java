/** Added from sudoku example (whole class): **/
package org.optaplanner.examples.nqueens.domain.solution;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.optaplanner.core.impl.heuristic.selector.common.decorator.SelectionSorterWeightFactory;

import org.optaplanner.examples.nqueens.domain.Number;
import org.optaplanner.examples.nqueens.domain.SudokuBoard;

public class SudokuNumberStrengthWeightFactory implements SelectionSorterWeightFactory<SudokuBoard, Number> {
    @Override
    public Comparable createSorterWeight(SudokuBoard solution, Number selection) {
        return new NumberStrengthWeight(selection);
    }

    public static class NumberStrengthWeight implements Comparable<NumberStrengthWeight>{
        Number number;

        public NumberStrengthWeight(Number number) {
            super();
            this.number = number;
        }

        public Number getNumber() {
            return number;
        }

        public void setNumber(Number number) {
            this.number = number;
        }

        @Override
        public int compareTo(NumberStrengthWeight num) {
            return new CompareToBuilder()
                    .append(this.number.getNumberValue(), num.getNumber().getNumberValue())
                    .append(this.number.getId(), num.getNumber().getId())
                    .toComparison();
        }
    }
}
