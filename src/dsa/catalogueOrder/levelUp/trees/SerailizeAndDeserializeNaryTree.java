package dsa.catalogueOrder.levelUp.trees;

import java.util.ArrayList;
import java.util.Stack;

public class SerailizeAndDeserializeNaryTree {

    private static class Node {
        private int val;
        private ArrayList<Node> children;

        Node() {
            children = new ArrayList<Node>();
        }

        Node(int _val) {
            val = _val;
            children = new ArrayList<Node>();
        }

        Node(int _val, ArrayList<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    // Encodes a tree to a single string.
    public static String serialize(Node root) {
        if(root == null) return "";
        StringBuilder sb = new StringBuilder("");
        serialize_(root, sb);
        return sb.toString();
    }

    private static void serialize_(Node root, StringBuilder sb) {
        sb.append(root.val + ",");

        for(Node child : root.children)
            serialize_(child, sb);

        sb.append("null,"); // null / -1  this marks the end of node with all its child processed.
    }

    // Decodes your encoded data to tree.
    public static Node deserialize(String str) {
        String[] arr = str.split(",");
        Node root = deserialize_(arr);
        return root;
    }

    private static Node deserialize_(String[] arr) {
        int idx = 0;
        int element = Integer.parseInt(arr[idx++]);
        Stack<Node> st = new Stack<>();
        Node root = new Node(element);
        st.push(root);

        while(st.size() > 0 && idx < arr.length) {
            Node peekNode = st.peek();

            String elementStr = arr[idx++];
            if(elementStr.equals(null)) {
                st.pop();
            } else {
                Node node = new Node(Integer.parseInt(elementStr));
                peekNode.children.add(node);
                st.push(node);
            }
        }
        return root;
    }
}
