package dsa.catalogueOrder.levelUp.trie;

public class __08_StreamOfCharacters {
    public static class StreamChecker {
        private static class Node {
            Node[] children;
            boolean isEnd;
            Node() {
                this.children = new Node[26];
                this.isEnd = false;
            }

            public void insert(Node curr, String word) {
                for(int i = word.length() - 1; i >= 0; i--) {
                    char ch = word.charAt(i);
                    if(curr.children[ch - 'a'] == null) {
                        curr.children[ch - 'a'] = new Node();
                    }
                    curr = curr.children[ch - 'a'];
                }
                curr.isEnd = true;
            }
        }

        private StringBuilder sb = new StringBuilder();
        private Node root;

        public StreamChecker(String[] words) {
            this.root = new Node();
            for (String word : words) {
                root.insert(root, word);
            }
        }

        public boolean query(char letter) {
            sb.append(letter);
            Node curr = this.root;
            for(int i = sb.length() - 1; i >= 0; i--) {
                char ch = sb.charAt(i);
                curr = curr.children[ch - 'a'];
                if(curr == null) return false;
                if(curr.isEnd == true) return true;
            }
            return false;
        }
    }
}
