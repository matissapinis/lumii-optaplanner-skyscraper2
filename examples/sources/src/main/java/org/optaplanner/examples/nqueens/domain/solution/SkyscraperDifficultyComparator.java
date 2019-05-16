/*******************************************************************************************************************
Class implementing the difficulty comparator (?) class of the OptaPlanner domain model for the Skyscraper Puzzle problem.

Sources:
1) lumii-optaplanner-sudolu

Author:         Matīss Apinis
Date created:   2019/05/13
Date edited:    2019/05/13
*******************************************************************************************************************/

package org.optaplanner.examples.nqueens.domain.solution;

import java.io.Serializable;
import java.util.Comparator;

import org.apache.commons.lang3.builder.CompareToBuilder;

/** TODO: Fix this dependency! **/
import org.optaplanner.examples.nqueens.domain.PuzzleCell;

public class SkyscraperDifficultyComparator implements Comparator<PuzzleCell>, Serializable {
    @Override
    public int compare(PuzzleCell a, PuzzleCell b) {
        return new CompareToBuilder()
                .append(a.getRowColNumberMultiplicand(), b.getRowColNumberMultiplicand())
                .append(a.getId(), b.getId()).toComparison();
    }
}
