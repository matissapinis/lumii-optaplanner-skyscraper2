/*******************************************************************************************************************
Interfaces implementing the parameters for the OptaPlanner domain model for the Skyscraper Puzzle problem.

Sources:
1) lumii-optaplanner-sudoku

Author:         Matīss Apinis
Date created:   2019/05/13
Date edited:    2019/05/13
*******************************************************************************************************************/

package org.optaplanner.examples.nqueens.app;

/** TODO: This is where the sudoku reasoning starts to diverge for the skyscraper puzzle. **/
public interface Skyscraper {
    public static final int numberOfCells = 9*9; // 4*4 #
    public static final int maxNumberOfRows = 9; // 4 #
    public static final int maxNumberOfColumns = 9; // 4 #
    public static final int minCellClueValue = 1; // 1 #
    public static final int maxCellClueValue = 9; // 4 #
    public static final int numOfSides = 9; // 4 #
    public static final int numOfCellsInSide = 3*3; // 4*1 ?
    public static final int numberOfRowsInSide = 3; // 4 ?
    public static final int numberOfColsInSide = 3; // 4 ?
    public enum GameMode { EASY, MEDIUM, HARD }; // enum GameMode = { EASY, MEDIUM, HARD };
    public static final int countOfCluesInPuzzle = 9*9; // 4*4 #
    public static final int highestClueValue = 9; // 4 #
    public static final int lowestClueValue = 1; // 1 #
    public static final int clueValues[] = new int[]{1,2,3,4,5,6,7,8,9}; // int clueValues[] = new int[]{1,2,3,4};
}

/**
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