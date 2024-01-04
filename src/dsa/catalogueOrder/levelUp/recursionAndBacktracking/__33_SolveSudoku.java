package dsa.catalogueOrder.levelUp.recursionAndBacktracking;

public class __33_SolveSudoku {

    public static void solveSudoku(int[][] board, int row, int col) {
        if(row == board.length) {
            display(board);
            return;
        }

        int nRow = (col == board[row].length - 1) ? row + 1 : row;
        int nCol = (col == board[row].length - 1) ? 0 : col + 1;

        if(board[row][col] != 0) {
            solveSudoku(board, nRow, nCol);
        } else {
            for(int i = 1; i <= 9; i++) {
                if(isValid(board, row, col, i)) {
                    board[row][col] = i; // mark
                    solveSudoku(board, nRow, nCol);
                    board[row][col] = 0; // unMark
                }
            }
        }
    }

    private static boolean isValid(int[][] board, int row, int col, int potentialAnswer) {
        // row check
        for(int j = 0; j < board[row].length; j++) {
            if(board[row][j] == potentialAnswer) {
                return false;
            }
        }

        // col check
        for(int i = 0; i < board.length; i++) {
            if(board[i][col] == potentialAnswer) {
                return false;
            }
        }

        // check in 3X3 sub matrix
        int subMatrixStartRow = row / 3 * 3;
        int subMatrixStartCol = col / 3 * 3;
        for (int i = subMatrixStartRow; i < subMatrixStartRow + 3; i++) {
            for (int j = subMatrixStartCol; j < subMatrixStartCol + 3; j++) {
                if(board[i][j] == potentialAnswer) return false;
            }
        }

        return true;
    }

    public static void display(int[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

}
