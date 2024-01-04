package dsa.catalogueOrder.levelUp.trie;

public class __04_ReplaceWords {
    public static void main(String[] args) {
        String[] dictionary = {"catt", "cat", "bat", "rat"};
        String sentence = "the cattle was rattled by the battery";

        System.out.println(replaceWords(dictionary, sentence));
    }
    private static class Node {
        Node[] children;
        boolean isEnd;

        public Node() {
            this.children = new Node[26];
            this.isEnd = false;
        }
    }

    private static Node root = new Node();

    public static String replaceWords(String dictionary[], String sentence) {
        for(String word : dictionary) {
            addWords(word);
        }
        Node curr = root;
        StringBuilder ans = new StringBuilder("");
        for (String str : sentence.split(" ")) {
            String prefix = search(str);
            if(prefix.isEmpty()) {
                ans.append(" " + str);
            } else {
                ans.append(" " + prefix);
            }
        }

        return ans.toString();
    }

    // for constructing Trie
    private static void addWords(String word) {
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

    // get prefix for a word in dictionary
    private static String search(String word) {
        System.out.println("Constructing Prefix for : " + word);
        Node curr = root;
        int idx = 0;
        String prefix = "";
        while(idx < word.length()) {
            char ch = word.charAt(idx++);
            if(curr.children[ch - 'a'] != null) {
                prefix += ch;
                System.out.println("prefix made so far : " + prefix);
                if(curr.children[ch - 'a'].isEnd) return prefix;
            } else {
                return  "";
            }
            curr = curr.children[ch - 'a'];
        }
        return prefix;
    }
}
