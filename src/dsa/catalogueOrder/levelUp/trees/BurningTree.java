package dsa.catalogueOrder.levelUp.trees;

public class BurningTree {

    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static int burningTime = 0;
    public static int burningTree(TreeNode root, int fireNode) {
        burningTreeHelper(root, fireNode);
        return burningTime;
    }

    private static int burningTreeHelper(TreeNode root, int fireNode) {
        if (root == null) return -1;

        if (root.val == fireNode) {
            kDown(root, null, 0);
            return 1;
        }

        int ld = burningTreeHelper(root.left, fireNode);
        if (ld > -1) {
            kDown(root, root.left, ld);
            return ld + 1;
        }

        int rd = burningTreeHelper(root.right, fireNode);
        if (rd > -1) {
            kDown(root, root.right, rd);
            return rd + 1;
        }

        return -1;
    }

    private static void kDown(TreeNode node, TreeNode blockage, int k) {
        if (node == null || node == blockage) return;

        if (k > burningTime) burningTime = k;

        kDown(node.left, blockage, k + 1);
        kDown(node.right, blockage, k + 1);
    }
}
