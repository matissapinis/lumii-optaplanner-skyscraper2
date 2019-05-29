/*******************************************************************************************************************
Interfaces implementing the parameters for the OptaPlanner domain model for the Skyscraper Puzzle problem.

Sources:
1) lumii-optaplanner-sudoku

Author:         Matīss Apinis
Date created:   2019/05/16
Date edited:    2019/05/29
*******************************************************************************************************************/

package org.optaplanner.examples.nqueens.app;

public interface Skyscraper {
    /** Defines the parameters of the board grid. **/
    public static final int row_count = 4;
    public static final int column_count = 4;
    public static final int cell_count = 4*4;

    /** Defines the parameters of the board grid entries. **/
    public static final int minimum_cell_value = 1;
    public static final int maximum_cell_value = 4;
    public static final int cell_values[] = new int[]{1,2,3,4};

    /** Defines the parameters of the board grid border. **/
    public static final int side_count = 4;
    public static final int clue_count = 4*4;

    /** Defines the parameters of the board grid border entries. **/
    public static final int minimum_clue_value = 1;
    public static final int maximum_clue_value = 4;
    public static final int clue_values[] = new int[]{1,2,3,4};
}

/** From lumii-optaplanner-sudoku:
package org.optaplanner.examples.nqueens.app;

public interface Sudoku {
    public static final int numberOfCells = 9*9;
    public static final int maxNumberOfRows = 9;
    public static final int maxNumberOfColums = 9;
    public static final int minCellNumValue = 1;
    public static final int maxCellNumValue = 9;
    public static final int numOfRegions = 9;
    public static final int numOfCellsInRegion = 3*3;
    public static final int numberOfRowsInRegion = 3;
    public static final int numberOfColsInRegion = 3;
    public enum GameMode { EASY, MEDIUM, HARD };
    public static final int countOfNumbersInBoard = 9*9;
    public static final int heighestNumValue = 9;
    public static final int lowestNumValue = 1;
    public static final int numberValues[] = new int[]{1,2,3,4,5,6,7,8,9};
}
**/