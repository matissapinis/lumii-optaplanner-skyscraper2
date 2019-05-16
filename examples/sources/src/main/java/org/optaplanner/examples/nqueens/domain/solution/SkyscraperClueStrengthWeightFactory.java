/*******************************************************************************************************************
Class implementing the difficulty comparator (?) class of the OptaPlanner domain model for the Skyscraper Puzzle problem.

Sources:
1) lumii-optaplanner-sudolu

Author:         Matīss Apinis
Date created:   2019/05/13
Date edited:    2019/05/13
*******************************************************************************************************************/

package org.optaplanner.examples.nqueens.domain.solution;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.optaplanner.core.impl.heuristic.selector.common.decorator.SelectionSorterWeightFactory;

/** TODO: Fix this dependency! **/
import org.optaplanner.examples.nqueens.domain.Clue;
/** TODO: Fix this dependency! **/
import org.optaplanner.examples.nqueens.domain.SkyscraperPuzzle;

public class SkyscraperClueStrengthWeightFactory implements SelectionSorterWeightFactory<SkyscraperPuzzle, Clue> {
    @Override
    public Comparable createSorterWeight(SkyscraperPuzzle solution, Clue selection) {
        /** TODO: Fix this dependency! **/
        return new ClueStrengthWeight(selection);
    }

    public static class ClueStrengthWeight implements Comparable<ClueStrengthWeight> {
        Clue clue;

        public ClueStrengthWeight(Clue clue) {
            super();
            this.clue = clue;
        }

        public Clue getClue() {
            return clue;
        }

        public void setClue(Clue clue) {
            this.clue = clue;
        }

        @Override
        public int compareTo(ClueStrengthWeight cl_ue) {
            return new CompareToBuilder()
                    .append(this.clue.getClueValue(), cl_ue.getClue().getClueValue())
                    .append(this.clue.getId(), cl_ue.getClue().getId())
                    .toComparison();
        }
    }
}
