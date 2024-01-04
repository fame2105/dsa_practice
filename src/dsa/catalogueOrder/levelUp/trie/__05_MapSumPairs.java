package dsa.catalogueOrder.levelUp.trie;

import java.util.HashMap;
import java.util.Map;

public class __05_MapSumPairs {
    private class Node {
        Node[] children;
        int score;

        public Node() {
            this.children = new Node[26];
            this.score = 0;
        }
    }

    private Node root;
    private Map<String, Integer> map;
    public __05_MapSumPairs() {
        this.root = new Node();
        this.map = new HashMap<>();
    }

    public void insert(String key, int val) {
        int prevVal = map.getOrDefault(key, 0);
        int delta = val - prevVal;
        map.put(key, val);

        Node curr = root;
        for(int i = 0; i < key.length(); i++) {
            char ch = key.charAt(i);
            if(curr.children[ch - 'a'] == null) {
                curr.children[ch - 'a'] = new Node();
            }

            curr.children[ch - 'a'].score += delta;
            curr = curr.children[ch - 'a'];
        }
    }

    public int sum(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (curr.children[ch - 'a'] == null) {
                return 0;
            }
            curr = curr.children[ch - 'a'];
        }
        return curr.score;
    }
}
