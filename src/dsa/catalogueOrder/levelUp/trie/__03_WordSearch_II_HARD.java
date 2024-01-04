package dsa.catalogueOrder.levelUp.trie;

import java.util.ArrayList;
import java.util.List;

public class __03_WordSearch_II_HARD {
    private class Node {
        Node[] childs;
        String end;

        Node() {
            this.childs = new Node[26];
            this.end = null;
        }
    }

    private Node root = new Node();

    private void constructTrie(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (curr.childs[ch - 'a'] == null) {
                curr.childs[ch - 'a'] = new Node();
            }
            curr = curr.childs[ch - 'a'];
        }
        curr.end = word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        for (String word : words) {
            constructTrie(word);    
        }

        int r = board.length;
        int c = board[0].length;
        boolean[][] visited = new boolean[r][c];

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, ans, visited);
            }
        }

        return ans;
    }
    
    private void dfs(char[][] board, int i, int j, Node root, List<String> ans, boolean[][] visited) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] == true)
            return;
        
        char ch = board[i][j];        
        Node child = root.childs[ch - 'a'];

        if (child == null)
            return;

        if (child.end != null) {
            ans.add(child.end);
            child.end = null;
        }

        visited[i][j] = true;
        dfs(board, i - 1, j, child, ans, visited);
        dfs(board, i + 1, j, child, ans, visited);
        dfs(board, i, j - 1, child, ans, visited);
        dfs(board, i, j + 1, child, ans, visited);
        visited[i][j] = false;
    }
    
}
