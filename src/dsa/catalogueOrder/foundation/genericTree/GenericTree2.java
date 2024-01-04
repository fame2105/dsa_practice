package dsa.catalogueOrder.foundation.genericTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenericTree2 {
    // GenericTreeNode
    private static void driver() {
        int[] data = new int[]{10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};

        Node root = construct(data);

        System.out.println("Displaying the generic Tree :");
        display(root);
    }

    public static void main(String[] args) {
        driver();
    }

    private static class Node {
        public int data;
        public ArrayList<Node> children;

        public Node(int data) {
            this.data = data;
            this.children = new ArrayList<>();
        }
    }

    public static Node construct(int[] arr) {
        Node root = null;
        Stack<Node> st = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            Integer data = arr[i];
            if (data != null) {
                Node newNode = new Node(data);
                if (st.isEmpty()) {
                    root = newNode;
                } else {
                    st.peek().children.add(newNode);
                }

                st.push(newNode);
            } else {
                st.pop();
            }
        }
        return root;
    }

    // doesn't need base case because never enters invalid case -> dry run for more details
    public static void display(Node root) {
        // string for printing current node data
        String str = "[" + root.data + "] -> ";

        // attach immediate children data to current
        for (Node child : root.children) {
            str = str + child.data + ", ";
        }

        // print current and immediate children data
        System.out.println(str + "_");

        // print data for all children Nodes
        for (Node child : root.children) {
            display(child);
        }
    }

    // Height in terms of edges
    private static int height(Node node) {
        int ht = -1;

        for (Node child : node.children) {
            ht = Math.max(ht, height(child));
        }
        return ht + 1;
    }

    static int diameter = 0;

    private static int diameter(Node node) {
        int deepestNode = -1;
        int secondDeepestNode = -1;
        int ht = -1;

        for (Node child : node.children) {
            ht = diameter(child);
            if (ht > deepestNode) {
                secondDeepestNode = deepestNode;
                deepestNode = ht;
            } else if (ht > secondDeepestNode) {
                secondDeepestNode = ht;
            }
        }

        if (diameter > deepestNode + secondDeepestNode + 2) {
            diameter = deepestNode + secondDeepestNode + 2;
        }

        return ht + 1;
    }

    static class Pair {
        Node node;
        int state;

        public Pair(Node node) {
            this.node = node;
            this.state = -1;
        }

        public Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static void iterativePreAndPostOrderTraversal(Node node) {
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();

        Stack<Pair> st = new Stack<>();
        st.push(new Pair(node));

        while (!st.isEmpty()) {
            Pair peekPair = st.peek();

            if (peekPair.state == -1) {
                peekPair.state += 1;
                preOrder.add(peekPair.node.data);
            } else if (peekPair.state >= 0 && peekPair.state < peekPair.node.children.size()) {
                    st.push(new Pair(peekPair.node.children.get(peekPair.state)));
                    peekPair.state += 1;
            } else {
                postOrder.add(peekPair.node.data);
                st.pop();
            }
        }
        System.out.println(preOrder);
        System.out.println(postOrder);
    }

}
