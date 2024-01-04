package dsa.catalogueOrder.levelUp.trie;

public class WordSearch_I {
    public static void main(String[] args) {
            char[][] board = {
                    {'A','B','C','E'},
                    {'S','F','C','S'},
                    {'A','D','E','E'}
            };
            String word = "ABCCEDF";
        System.out.println(exist(board, word));
    }

    public static boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;

        boolean[][] visited = new boolean[rows][cols];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(word.length() == 1) return true;
                    boolean result = dfs(board, i, j, word, 0, visited);
                    System.out.println("Result from DFS is " + result);
                    if(result == true) return true;
                }
            }
        }

        return false;
    }

    private static boolean dfs(char[][] board, int i, int j, String word, int idx, boolean[][] visited) {
        if(idx == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] == true) {
            return false;
        }

        char ch = board[i][j];
        boolean result = false;
        if(word.charAt(idx) == ch) {
            visited[i][j] = true;
            result = result || dfs(board, i-1, j, word, idx+1, visited);
            result = result || dfs(board, i, j-1, word, idx+1, visited);
            result = result || dfs(board, i+1, j, word, idx+1, visited);
            result = result || dfs(board, i, j+1, word, idx+1, visited);
            visited[i][j] = false;
        }

        return result;
    }
}
