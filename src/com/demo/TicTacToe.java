package com.demo;

/*
    [0][0] [0][1] [0][2]
    [1][0] [1][1] [1][2]
    [2][0] [2][1] [2][2]
*/

public class TicTacToe {

    public static void main(String[] args) {

        // Declare and assign players, blank
        int X = 1;
        int O = -1;

        int[][] arrBoard = {
                {1, 1, 0},
                {1, 1, 1},
                {0, 0, 0}
        };

        // Declare board
        int winner = evaluateWinner(arrBoard);

        if (winner == X) {
            System.out.println("\n1 Won");
        } else if (winner == O) {
            System.out.println("\n-1 Won");
        } else {
            System.out.println("It's a tie ! No one wins ! Please try again.");
        }

        System.out.println(winByRow(arrBoard));
        System.out.println(get_row_number_starter(arrBoard));
        System.out.println(get_winner_evidence(get_row_number_starter(arrBoard), arrBoard));

    }

    final static int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
    };

    public static void printBoard() {
        for (int i = 0; i < matrix.length; i++) { // this equals to the row in our matrix.
            for (int j = 0; j < matrix[i].length; j++) { // this equals to the column in each row.
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(); // change line on console as row comes to end in the matrix.
        }
    }

    public static int evaluateWinner(int[][] arrBoard) {

        // Check for rows and columns
        for (int i = 0; i < arrBoard.length; i++) {
            if (0 != arrBoard[0][i] &&
                    arrBoard[0][i] == arrBoard[1][i] && arrBoard[1][i] == arrBoard[2][i]) { // check rows
                return arrBoard[0][i];
            } else if (0 != arrBoard[i][0] &&
                    arrBoard[i][0] == arrBoard[i][1] && arrBoard[i][1] == arrBoard[i][2]) { // check columns
                return arrBoard[i][0];
            }
        }

        // check diagonal upper left to lower right
        // check diagonal lower left to upper right
        if (arrBoard[1][1] != 0 &&
                ((arrBoard[0][0] == arrBoard[1][1] && arrBoard[1][1] == arrBoard[2][2])
                        || (arrBoard[0][2] == arrBoard[1][1] && arrBoard[1][1] == arrBoard[2][0]))) {
            return arrBoard[1][1];
        }
        return 0;
    }

    public static boolean winByRow(int[][] arrBoard) {
        boolean match = false;
        for (int i = 0; i < arrBoard.length; i++) {
            if (match) break;
            for (int j = 0; j < arrBoard.length; j++) {
                if (j == arrBoard.length - 1) break;
                if (arrBoard[i][j] != 0 && arrBoard[i][j] == arrBoard[i][j + 1]) {
                    match = true;
                    break;
                }
            }
        }
        return match;
    }

    public static int get_row_number_starter(int[][] arrBoard) {
        int number = 0;
        boolean match = false;
        for (int i = 0; i < arrBoard.length; i++) {
            if (match) break;
            for (int j = 0; j < arrBoard.length; j++) {
                if (j == arrBoard.length - 1) {
                    break;
                }
                if (arrBoard[i][j] != 0 && arrBoard[i][j] == arrBoard[i][j + 1]) {
                    if (j == arrBoard.length - 2) {
                        match = true;
                        number = number - 1;
                        break;
                    }
                    number++;
                } else {
                    number = number + arrBoard.length;
                    break;
                }
            }
        }
        if (number == 0) {
            number = 1;
        }
        return number;
    }

    public static String get_winner_evidence(int row_number, int[][] arrboard) {
        String evidence = "";
        for (int i = 0; i < arrboard.length; i++) {
            evidence = evidence.concat(String.valueOf(row_number));
            row_number++;
        }
        return evidence;
    }

    public static boolean winByCol(int[][] arrBoard) {
        boolean winByCol = false;
        for (int i = 0; i < arrBoard.length; i++) {
            if (0 != arrBoard[i][0] &&
                    arrBoard[i][0] == arrBoard[i][1] && arrBoard[i][1] == arrBoard[i][2]) {
                winByCol = true;
            }
        }
        return winByCol;
    }

    public static boolean winsByDiagonals(int[][] arrBoard) {
        boolean winByDiagonals = false;
        if (arrBoard[1][1] != 0 &&
                ((arrBoard[0][0] == arrBoard[1][1] && arrBoard[1][1] == arrBoard[2][2])
                        || (arrBoard[0][2] == arrBoard[1][1] && arrBoard[1][1] == arrBoard[2][0]))) {
            winByDiagonals = true;
        }
        return winByDiagonals;
    }

    public static int getrow(int[][] arrBoard) {
        int row = 0;
        for (int i = 0; i < arrBoard.length; i++) {
            if (0 != arrBoard[0][i] &&
                    arrBoard[0][i] == arrBoard[1][i] && arrBoard[1][i] == arrBoard[2][i]) {
                row = i;
            }
        }
        return row;
    }

    public static int getCol(int[][] arrBoard) {
        int row = 0;
        for (int i = 0; i < arrBoard.length; i++) {
            if (0 != arrBoard[i][0] &&
                    arrBoard[i][0] == arrBoard[i][1] && arrBoard[i][1] == arrBoard[i][2]) {
                row = i + 1;
            }
        }
        if (row != 1) {
            row = row + 1;
        }
        return row;
    }

    public static int getDiagonals(int[][] arrBoard) {
        int diagonals = 0;
        for (int i = 0; i < arrBoard.length; i++) {
            if (arrBoard[1][1] != 0 &&
                    ((arrBoard[0][0] == arrBoard[1][1] && arrBoard[1][1] == arrBoard[2][2])
                            || (arrBoard[0][2] == arrBoard[1][1] && arrBoard[1][1] == arrBoard[2][0]))) {
                diagonals = i;
            }
        }
        return diagonals;
    }

    public static String getRowIndex(int[][] arrBoard, int rowNum) {
        String row = "";
        int counter = 2;
        if (rowNum == 0) {
            rowNum = 1;
        }
        for (int i = 0; i <= counter; i++) {
            row = row.concat(String.valueOf(rowNum));
            rowNum++;
        }
        return row;
    }

    public static String getColIndex(int[][] arrBoard, int colNum) {
        String row = "";
        int counter = 2;
        if (colNum == 0) {
            colNum = 1;
        }
        for (int i = 0; i <= counter; i++) {
            row = row.concat(String.valueOf(colNum));
            colNum++;
        }
        return row;
    }

    public static String getDiagonalIndex(int[][] arrBoard, int diagonalNum) {
        String row = "";
        int counter = 2;
        if (diagonalNum == 0) {
            diagonalNum = 1;
        }
        for (int i = 0; i <= counter; i++) {
            row = row.concat(String.valueOf(diagonalNum));
            diagonalNum++;
        }
        return row;
    }

}