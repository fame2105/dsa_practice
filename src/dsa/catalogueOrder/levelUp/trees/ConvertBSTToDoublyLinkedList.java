package dsa.catalogueOrder.levelUp.trees;

import java.util.Stack;

public class ConvertBSTToDoublyLinkedList {

    private static class Node {
        int val = 0;
        Node left = null; // prev
        Node right = null; // next

        Node(int val) {
            this.val = val;
        }
    }

// Approach 01 -> Using DFS Recursion (Converts BST to Sorted Circular Doubly Linked List)

    static Node prev = null;
    public static Node BSTtoDLL_approach01(Node root) {
        Node dummy = new Node(-1);
        prev = dummy;
        BSTtoDLLHelper_approach01(root);

        Node head = dummy.right;
        head.left = dummy.right = null; // breaking the link between dummy and head pointer

        prev.right = head; // connect tail to head to make the linked list circular
        head.left = prev;
        return head;
    }

    private static void BSTtoDLLHelper_approach01(Node root) {
        if(root == null) return;

        BSTtoDLLHelper_approach01(root.left);

        prev.right = root;
        root.left = prev;
        prev = prev.right; // or {prev = root} => both will work

        BSTtoDLLHelper_approach01(root.right);
    }

// Approach 02 -> Using Iterative Method (Converts BST to Sorted Circular Doubly Linked List)

    public static Node BSTtoDLL_approach02(Node root) {
        Stack<Node> st = new Stack<>();
        addAllLeftNodes(root, st);

        Node dummy = new Node(-1);
        Node prev = dummy;

        while(!st.isEmpty()) {
            Node current = st.pop();

            prev.right = current;
            current.left = prev;
            prev = current;

            addAllLeftNodes(current.right, st);
        }

        Node head = dummy.right;
        dummy.right = head.left = null;

        prev.right = head;
        head.left = prev;

        return head;
    }

    private static void addAllLeftNodes(Node node, Stack<Node> stack) {
        while(node != null) {
            stack.push(node);
            node = node.left;
        }
    }

// Approach 03 -> Using Morris Traversal (Converts BST to Sorted Circular Doubly Linked List)
}
