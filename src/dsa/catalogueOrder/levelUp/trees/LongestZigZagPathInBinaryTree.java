package dsa.catalogueOrder.levelUp.trees;

public class LongestZigZagPathInBinaryTree {
    private static class TreeNode {
        int val;
        TreeNode left = null, right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static class Pair {
        int forwardSlopeLength = -1;
        int backwardSlopeLength = -1;
        int maxLengthSoFar = -1;
    }

    public int longestZigZag_approach01(TreeNode root) {
        Pair result = longestZigZagHelper_approach01(root);
        return result.maxLengthSoFar;
    }

    private Pair longestZigZagHelper_approach01(TreeNode root) {
        if (root == null) return new Pair();

        Pair leftResult = longestZigZagHelper_approach01(root.left);
        Pair rightResult = longestZigZagHelper_approach01(root.right);

        Pair myResult = new Pair();
        myResult.forwardSlopeLength = leftResult.backwardSlopeLength + 1;
        myResult.backwardSlopeLength = rightResult.forwardSlopeLength + 1;

        int potentialMaxLength = Math.max(myResult.backwardSlopeLength, Math.max(myResult.forwardSlopeLength, Math.max(leftResult.maxLengthSoFar, rightResult.maxLengthSoFar)));

        myResult.maxLengthSoFar = potentialMaxLength;
        return myResult;
    }

// --------------------------------------------------------------------------------------------------

    private static int maxLen = -1;
    public int longestZigZag_approach02(TreeNode root) {
        longestZigZagHelper_approach02(root);
        return maxLen;
    }

    // int[0] -> forwardSlopeLengthSoFar
    // int[1] -> backwardSlopeLengthSoFar
    private int[] longestZigZagHelper_approach02(TreeNode root) {
        if (root == null) return new int[]{-1, -1};

        int[] leftResult = longestZigZagHelper_approach02(root.left);
        int[] rightResult = longestZigZagHelper_approach02(root.right);

        int[] myResult = new int[2];
        myResult[0] = leftResult[1] + 1;
        myResult[1] = rightResult[0] + 1;

        maxLen = Math.max(myResult[0], Math.max(myResult[1], maxLen));
        return myResult;
    }
}
