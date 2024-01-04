package dsa.catalogueOrder.levelUp.trees;

public class MaxWidthOfShadowOfBinaryTree {

    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static int maxWidthOfShadow(TreeNode root) {
        if(root == null) return 0;
        maxWidthOfShadowHelper(root, 0);
        return (maxRight - minLeft) + 1;
    }

    private static int minLeft = Integer.MAX_VALUE;
    private static int maxRight = Integer.MIN_VALUE;

    private static void maxWidthOfShadowHelper(TreeNode root, int width) {
        if (root == null) return;

        if (minLeft > width) minLeft = width;

        if (maxRight < width) maxRight = width;

        maxWidthOfShadowHelper(root.left, width - 1);
        maxWidthOfShadowHelper(root.right, width + 1);
    }

}
