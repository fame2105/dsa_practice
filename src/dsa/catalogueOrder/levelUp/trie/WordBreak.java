package dsa.catalogueOrder.levelUp.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
//        String s = "applepenapple";
//        String[] dict = new String[] {"apple", "penn"};

//        String s = "aaaaaaa";
//        String[] dict = new String[] {"aaaa", "aaa"};

        String s = "catsandog";
        String[] dict = new String[] {"cats","dog","sand","and","cat"};
        List<String> list = new ArrayList<>(Arrays.asList(dict));
        System.out.println(wordBreak(s, list));;
    }
    private static class Node {
        Node[] children;
        boolean isEnd;

        Node() {
            this.children = new Node[26];
            this.isEnd = false;
        }
    }

    private static void addWord(String word) {
        Node curr = root;
        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if(curr.children[ch - 'a'] == null) {
                curr.children[ch - 'a'] = new Node();
            }
            curr = curr.children[ch - 'a'];
        }
        curr.isEnd = true;
    }

    private static Node root = new Node();

    public static boolean wordBreak(String s, List<String> wordDict) {
        for(String word : wordDict) {
            addWord(word);
        }

        int idx = 0;
        while(idx < s.length()) {
            dfs(s, idx, root);
            idx = idxsf;
            if(idx == -1) {
                return false;
            }
            idx++;
            System.out.println("stuck in while");
        }

        return idx >= s.length();

    }

    private static int idxsf = -1;
    private static void dfs(String s, int idx, Node curr)  {
        if(idx == s.length()) {
            idxsf = idx;
            return;
        }

        char ch = s.charAt(idx);
        if(curr.children[ch - 'a'] == null) return;

        if(curr.children[ch - 'a'].isEnd == true) {
            idxsf = idx;
        }

        dfs(s, idx+1, curr.children[ch - 'a']);

        /*for(int i = idx; idx < s.length(); idx++) {
            char c = s.charAt(idx);
            Node child = curr.children[c - 'a'];
            if(child != null && child.str != null) {
                return dfs(s, idx+1, root);
            }

            curr = child;
        }

        return false;*/
    }
}
