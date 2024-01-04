package dsa.google;

// https://binarysearch.com/problems/Unidirectional-Word-Search
public class UnidirectionalWordSearch {

    public boolean uniDirectionalSearch(String[][] board, String word) {
        // search horizontally
        for(int row = 0; row < board.length; row++) {
            String rowWord = concat(board[row]);
            if(rowWord.contains(word)) {
                return true;
            }
        }

        String[][] rotatedBoard = rotateBoard(board); // rotating the board, because its easier to form concatinate Strings over a row.

        // search vertically
        for(int row = 0; row < rotatedBoard.length; row++) {
            String rowWord = concat(rotatedBoard[row]);
            if(rowWord.contains(word)) {
                return true;
            }
        }

        return false;
    }

    private String concat(String[] arr) { // arr : ["x", "z", "d", "x"]
        StringBuffer sb = new StringBuffer("");
        for(int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    private String[][] rotateBoard(String[][] board) {
        String[][] newBoard = new String[board[0].length][board.length];

        for(int col = board[0].length-1; col >= 0; col--) {
            for(int row = 0; row < board.length; row++) {
                newBoard[board[0].length -1 - col][row] = board[row][col];
            }
        }
        return newBoard;
    }
}
