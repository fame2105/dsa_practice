package dsa.catalogueOrder.levelUp.trie;

public class __01_ImplementTrie {
    private static class Node {
        Node[] childs;
        boolean isEnd;

        Node() {
            this.childs = new Node[26];
            this.isEnd = false;
        }
    }

    private Node root;

    public __01_ImplementTrie() {
        root = new Node();
    }

    public void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (curr.childs[ch - 'a'] == null) {
                curr.childs[ch - 'a'] = new Node();
            }

            curr = curr.childs[ch - 'a'];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (curr.childs[ch - 'a'] == null) {
                return false;
            }

            curr = curr.childs[ch - 'a'];
        }

        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            if (curr.childs[ch - 'a'] == null) {
                return false;
            }

            curr = curr.childs[ch - 'a'];
        }

        return true;
    }
}
