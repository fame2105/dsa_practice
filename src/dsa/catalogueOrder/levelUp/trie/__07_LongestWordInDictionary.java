package dsa.catalogueOrder.levelUp.trie;

public class __07_LongestWordInDictionary {
    private static class Node {
        Node[] children;
        String str;

        public Node() {
            this.children = new Node[26];
            this.str = null;
        }

        public static void insert(Node curr, String word) {
            for(int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if(curr.children[ch - 'a'] == null) {
                    curr.children[ch - 'a'] = new Node();
                }
                curr = curr.children[ch - 'a'];
            }
            curr.str = word;
        }
    }

    private static Node root = new Node();

    private static String longestWord = "";
    public static String longestWord(String[] words) {
        for(String word : words) {
            Node.insert(root, word);
        }

        dfs(root);
        return longestWord;
    }

    private static void dfs(Node curr) {
        for(int i = 0; i < 26; i++) {
            if(curr.children[i] != null && curr.children[i].str != null) {
                if(curr.children[i].str.length() > longestWord.length()) {
                    longestWord = curr.children[i].str;
                }
                dfs(curr.children[i]);
            }
        }
    }
}
