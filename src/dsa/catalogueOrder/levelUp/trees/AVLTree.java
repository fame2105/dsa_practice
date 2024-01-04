package dsa.catalogueOrder.levelUp.trees;

public class AVLTree {
    private static class TreeNode {
        int val;
        TreeNode left = null;
        TreeNode right = null;

        int balance;
        int height;

        TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
            this.balance = 0;
            this.height = 0;
        }
    }

    private static void updateHeightAndBalance(TreeNode node) {
        int leftHeight = node == null ? -1 : node.left.height;
        int rightHeight = node == null ? -1 : node.right.height;

        node.balance = leftHeight - rightHeight;
        node.height = Math.max(leftHeight, rightHeight) + 1;
    }

    private static TreeNode rightRotation(TreeNode A) {
        TreeNode B = A.left;
        A.left = B.right;
        B.right = A;

        updateHeightAndBalance(A);
        updateHeightAndBalance(B); // since B is the new Root, correct its height and balance after correcting A's height and balance
        return B;
    }

    private static TreeNode leftRotation(TreeNode A) {
        TreeNode B = A.right;
        A.right = B.left;
        B.left = A;

        updateHeightAndBalance(A);
        updateHeightAndBalance(B); // since B is the new Root, correct its height and balance after correcting A's height and balance
        return B;
    }

    public static TreeNode getRotation(TreeNode node) {
        updateHeightAndBalance(node);

        if (node.balance == 2) {
            if (node.left.balance == 1) {
                // LL Structure
                return rightRotation(node);
            } else if (node.left.balance == -1) {
                //LR Structure
                node.left = leftRotation(node.left);
                return rightRotation(node);
            }
        } else if (node.balance == -2) {
            if (node.left.balance == 1) {
                // RL Structure
                node.right = rightRotation(node.right);
                return leftRotation(node);
            } else if (node.left.balance == -1) {
                // RR Structure
                return leftRotation(node);
            }
        }

        return node;
    }

    public static TreeNode add(TreeNode root, int data) {
        if (root == null) {
            root = new TreeNode(data);
            return root;
        }

        if (data > root.val) {
            root.right = add(root.right, data);
        } else if (data < root.val) {
            root.left = add(root.left, data);
        }

        return getRotation(root);
    }

    public static TreeNode delete(TreeNode node, int data) {
        return null;
    }

    public static void display(TreeNode node) {

    }
}
