package dsa.dpMasterCourseUdemy;

// https://leetcode.com/problems/sudoku-solver/
public class SudokuSolver {
    public static void main(String[] args) {
        char[][] board = new char[][] {
                {'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}
        };
        solveSudoku(board);
        print(board);
    }

    public static void solveSudoku(char[][] board) {
        solution(board, 0, 0);
    }

    private static boolean solution(char[][] board, int row, int col) {
        if(row == board.length) {
            return true;
        }

        if(col == board[row].length) {
            return solution(board, row+1, 0);
        }

        if(board[row][col] != '.') {
            return solution(board, row, col+1);
        }


        for(int i = 1; i <= 9; i++) {
            char num = (char) ('0' + i);
            if(safeToPlace(board, row, col, num) == true) {
                board[row][col] = num;
                boolean subSolution = solution(board, row, col+1);
                if(subSolution == true) {
                    return true;
                }
            }
        }

        board[row][col] = '.';
        return false;
    }

    private static boolean safeToPlace(char[][] board, int row, int col, char num) {

        // check in row and col
        for(int i = 0; i < board.length; i++) {
            if(board[row][i] == num || board[i][col] == num)
                return false;
        }

        // check in sub matrix
        int rowStart = (row/3) * 3;
        int colStart = (col/3) * 3;

        for(int i = rowStart; i < rowStart+3; i++) {
            for(int j = colStart; j < colStart + 3; j++) {
                if(board[i][j] == num)
                    return false;
            }
        }
        return true;
    }

    private static void print(char[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
