package dsa.catalogueOrder.foundation.recursion.backtracking;

import java.util.Scanner;

public class NQueens {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] arr = new int[n][n];

        printNQueen(arr, 0, "");
    }

    private static void printNQueen(int[][] chessBoard, int row, String queenPlacedSoFar) {
        if(row == chessBoard.length) {
            System.out.println(queenPlacedSoFar);
            return;
        }


        // iterating on columns and changing rows via recursive calls
        // Each row acts as level and number of columns at each row are my options to be explored
        for(int i = 0; i < chessBoard[0].length; i++) {
            if(checkIfQueenCanBePlacedHereSafely(chessBoard, row, i)) {
                chessBoard[row][i] = 1;
                printNQueen(chessBoard, row + 1, queenPlacedSoFar + row + i + "\t");
                chessBoard[row][i] = 0;
            }
        }
    }

    // Check PrintWaysToSelectBox before this
    // qpsf -> queen placed so far
    // asf -> answer so far
    private static void nQueenSubsequencesMethod(int[][] board, int sr, int sc, int qpsf, String asf) {
        if(sr == board.length) {
            if(qpsf == board.length)
                System.out.println(asf + ".");
            return;
        }

        if(sc + 1 < board[0].length) { // next column is valid
            // yes + isvalid
            if(checkIfQueenCanBePlacedHereSafely(board, sr, sc) == true) {
                board[sr][sc] = 1;
                nQueenSubsequencesMethod(board, sr + 1, 0, qpsf + 1, asf + sr + "-" + sc + ", ");
                board[sr][sc] = 0;
            }
            // no call
            nQueenSubsequencesMethod(board, sr, sc + 1, qpsf, asf);
        } else { // next column is not valid
            // yes + isvalid
            if(checkIfQueenCanBePlacedHereSafely(board, sr, sc) == true) {
                board[sr][sc] = 1;
                nQueenSubsequencesMethod(board, sr + 1, 0, qpsf + 1, asf + sr + "-" + sc + ", ");
                board[sr][sc] = 0;
            }
            // no call
            nQueenSubsequencesMethod(board, sr + 1, 0, qpsf, asf);
        }
    }

    private static boolean checkIfQueenCanBePlacedHereSafely(int[][] chessBoard, int row, int column) {
        // check in all the boxes straight up the given row and column
        for(int i = row - 1, j = column; i>=0; i--) {
            if(chessBoard[i][j] == 1) {
                return false;
            }
        }

       // checking above left diagonal to see if there is any queen present already
        for(int i = row - 1, j = column-1; i>=0 && j >= 0; i--, j--) {
            if(chessBoard[i][j] == 1) {
                return false;
            }
        }

        // checking above right diagonal to see if there is any queen present already
        for(int i = row - 1, j = column + 1; i>=0 && j < chessBoard.length; i--,j++) {
            if(chessBoard[i][j] == 1) {
                return false;
            }
        }
        return true;
    }
}
