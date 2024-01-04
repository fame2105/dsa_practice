package dsa.catalogueOrder.foundation.binarySearchTree;

import java.util.ArrayList;

public class BinarySearchTree {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node() {
            this.data = 0;
            left = null;
            right = null;
        }

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
//        driver();
        StringBuilder sb = new StringBuilder("");

        sb.append("2");
        sb.append("->");
        sb.append("3");
        sb.append("->");
        System.out.println(sb.toString());
        sb.delete(sb.length() - 3, sb.length());
        System.out.println(sb.toString());
    }

    public static void driver() {
        int[] arr = new int[]{10, 20, 30, 40, 50, 60, 70, 80, 90};
        Node root = constructBST(arr, 0, arr.length - 1);
        System.out.println("<!--------- Displaying BST: -------->");
        display(root);
        System.out.println("-----------------------------------------");
        System.out.println("Size = " + size(root));
        System.out.println("-----------------------------------------");
        System.out.println("Sum = " + sum(root));
        System.out.println("-----------------------------------------");
        System.out.println("Max = " + max(root));
        System.out.println("-----------------------------------------");
        System.out.println("Min = " + min(root));
        System.out.println("-----------------------------------------");
        System.out.println("found 80 = " + find(root, 80));

    }

    // arr is sorted (inorder)
    private static Node constructBST(int[] arr, int start, int end) {
        if (start > end) return null;

        int mid = (start + end) / 2;

        Node left = constructBST(arr, start, mid - 1);
        Node right = constructBST(arr, mid + 1, end);

        Node node = new Node(arr[mid]);
        node.left = left;
        node.right = right;
        return node;
    }

    private static void display(Node node) {
        if (node == null) return;
        String output = "<- " + node.data + " ->";
        output = (node.left == null ? "." : node.left.data) + output;
        output += node.right == null ? "." : node.right.data;

        System.out.println(output);

        display(node.left);
        display(node.right);
    }

    private static ArrayList<Integer> inorderTraversal(Node node) {
        if (node == null) return new ArrayList<Integer>();

        ArrayList<Integer> left = inorderTraversal(node.left);

        left.add(node.data);

        ArrayList<Integer> right = inorderTraversal(node.right);

        left.addAll(right);
        return left;
    }

    public static int size(Node node) {
        if (node == null) return 0;

        int lSize = node.left == null ? 0 : size(node.left);
        int rSize = node.right == null ? 0 : size(node.right);

        return lSize + rSize + 1;
    }

    public static int sum(Node node) {
        if (node == null) return 0;

        int lSum = sum(node.left);
        int rSum = sum(node.right);

        return lSum + rSum + node.data;
    }

    public static int max(Node node) {
        if (node == null) return 0;
        if (node.right != null) {
            return max(node.right);
        } else {
            return node.data;
        }
    }

    public static int min(Node node) {
        if (node == null) return 0;
        if (node.left != null) {
            return min(node.left);
        } else {
            return node.data;
        }
    }

    public static boolean find(Node node, int data) {
        if (node == null) return false;
        if (node.data == data) return true;
        else if (node.data < data) // look further in right subtree
            return find(node.right, data);
        else // look further in left subtree
            return find(node.left, data);
    }

    public static Node add(Node node, int data) {
        if (node == null) return new Node(data);
        if (node.data < data) // look further in right subtree
            node.right = add(node.right, data);
        else // look further in left subtree
            node.left = add(node.left, data);
        return node;
    }

    static int sum = 0;

    public static void rwsol(Node node) { //travel reverse inorder
        if (node == null) return;

        if (node.right != null) {
            rwsol(node.right);
        }

        int myValue = node.data; // save self value

        // replace self value by sum
        node.data = sum;

        // update sum value
        sum += myValue;

        if (node.left != null) {
            rwsol(node.left);
        }
    }

    public static int lca(Node node, int d1, int d2) {
        if (node == null) return -1;
        if (d1 > node.data && d2 > node.data) {
            // search in right
            return lca(node.right, d1, d2);
        } else if (d1 < node.data && d2 < node.data) {
            // search in left
            return lca(node.left, d1, d2);
        } else {
            return node.data;
        }
    }

    public static void printInRange(Node node, int d1, int d2) {
        if (node == null) return;
        if (d1 > node.data && d2 > node.data) {// check in right
            printInRange(node.right, d1, d2);
        } else if (d1 < node.data && d2 < node.data) { // check in left
            printInRange(node.left, d1, d2);
        } else {
            printInRange(node.left, d1, d2);
            System.out.println(node.data);
            printInRange(node.right, d1, d2);
        }
    }

    // approach - 01 O(nh) space : O(h) h -> height
    public static void targetSumPair01(Node root, Node node, int target) {
        if (node == null) return;

        targetSumPair01(root, node.left, target);

        int n1 = node.data;
        int n2 = target - n1;
        if (n1 < n2 && find(root, n2)) {
            System.out.println(n1 + " " + n2);
        }

        targetSumPair01(root, node.right, target);
    }

    // approach - 02 O(n) space : O(n) fill inorder values inside arraylist and use targetsumPair on arrays
    public static void targetSumPair02(Node node, int target) {
        ArrayList<Integer> list = inorderTraversal(node);

        int lo = 0;
        int hi = list.size() - 1;
        while (lo < hi) {
            int sum = list.get(lo) + list.get(hi);
            if (sum > target) hi -= 1;
            else if (sum < target) lo += 1;
            else System.out.println(list.get(lo) + " " + list.get(hi));
        }
    }

    // approach - 01 O(n) space : O(h) h -> height
    public static void targetSumPair03(Node node, int target) {

    }


    public static Node deleteNode(Node node, int target) {
        if (node == null) return null;

        if (target > node.data) {
           node.right = deleteNode(node.right, target);
        } else if (target < node.data) {
            node.left = deleteNode(node.left, target);
        } else {
            if (node.left != null && node.right != null) {
                // replace current node data with max in left subtree
                int lMax = max(node.left);
                node.data = lMax;

                // delete the max node from the left subtree
                node.left = deleteNode(node.left, lMax);
                return node;
            } else if (node.left != null) {
                return node.left;
            } else if (node.right != null) {
                return node.right;
            } else {
                return null;
            }
        }

        return node;
    }
}
