package dsa.catalogueOrder.levelUp.trie;

public class __02_DesignAddAndSearchWords {
    private class Node {
        Node[] childs;
        boolean isEnd;

        Node() {
            this.childs = new Node[26];
            this.isEnd = false;
        }
    }

    private Node root;

    public __02_DesignAddAndSearchWords() {
        root = new Node();
    }

    public void addWord(String word) {
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
        return find(curr, word, 0);
    }

    private boolean find(Node curr, String word, int idx) {
        if (idx == word.length()) {
            return curr.isEnd;
        }

        char ch = word.charAt(idx);
        if (ch == '.') {
            for (int i = 0; i < curr.childs.length; i++) {
                if (curr.childs[i] != null && find(curr.childs[i], word, idx + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            if (curr.childs[ch - 'a'] == null) {
                return false;
            } else {
                Node childNode = curr.childs[ch - 'a'];
                return find(childNode, word, idx + 1);
            }
        }
    }


}
