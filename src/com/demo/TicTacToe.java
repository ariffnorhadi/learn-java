package com.demo;

/*
    [0][0] [0][1] [0][2]
    [1][0] [1][1] [1][2]
    [2][0] [2][1] [2][2]
*/

public class TicTacToe {

    public static void main(String[] args) {

        int X = 1;
        int O = -1;

        int[][] arrBoard = {
                { 1,-1, 1 },
                { 0, 0, 0 },
                { 1, 1, 1 }
        };

        int winner = evaluateWinner(arrBoard);

        printBoard(arrBoard);

        if (winner == X) {
            System.out.print("\nX (1) Won");
        } else if (winner == O) {
            System.out.print("\nO (-1) Won");
        } else {
            System.out.print("It's a tie ! No one wins ! Please try again.");
        }

        System.out.println(" (" + get_winner_evidence(get_row_number_starter(arrBoard), arrBoard) + ") ");

    }

    public static void printBoard(int[][] arrBoard) {
        for (int i = 0; i < arrBoard.length; i++) { // this equals to the row in our matrix.
            for (int j = 0; j < arrBoard[i].length; j++) { // this equals to the column in each row.
                System.out.print(arrBoard[i][j] + " ");
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

    public static int get_row_number_starter(int[][] arrBoard) {
        int number = 0; // start with zero, will increment this with each loop below
        boolean win = false; // once we set this to true / we find the matched row, we want to break the loop.
        for (int i = 0; i < arrBoard.length; i++) {
            if (win) // no need to go next row if we find the matched row already
                break;
            for (int j = 0; j < arrBoard.length; j++) {
                if (j == arrBoard.length - 1) { // the logic is to compare column 1 and the next column (still at same row), so once we reach the second last column, that should be the last loop
                    break;
                }
                if (arrBoard[i][j] != 0 && arrBoard[i][j] == arrBoard[i][j + 1]) { // compare one column next to each other, eg: column 1 and column 2, if true, we increment the variable number
                    number++;
                    if (j == arrBoard.length - 2) { // this means, first checking (column 1 and column 2 is matched already), else we already go to next row (line 87)
                        // so first checking done, then second checking also match (column 2 and 3)
                        win = true; // so we are breaking the whole loop (refer line 74)
                        number = number - 1; // number here can be 5 or 8, so we want it to be 4 or 7
                        break;
                    }
                } else {
                    number = number + arrBoard.length; // let say, number is 1, so row 1 no match, we will go next row, so should start with 4 (or add the number with size of array)
                    break;
                }
            }
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

}