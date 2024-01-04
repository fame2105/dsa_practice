package dsa.catalogueOrder.levelUp.trees.pathSum;

public class MaxPathSumBetweenTwoLeaves {

    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Approach -> 01
    public static int maxPathSum_approach01(TreeNode root) {
        int[] ans = maxPathSumHelper_approach01(root);
        return ans[0];
    }

    // We could also create a Pair class to store the value of [0] and [1] positioned variables
    // [0] -> Leaf To Leaf Max Path Sum
    // [1] -> Leaf To Node Max pat Sum
    static int min = -(int) 1e3 - 1;

    public static int[] maxPathSumHelper_approach01(TreeNode root) {
        if (root == null) return new int[]{min, min};

        if (root.left == null && root.right == null) return new int[]{min, root.val};   // it's a leaf node

        int[] leftResult = maxPathSumHelper_approach01(root.left);
        int[] rightResult = maxPathSumHelper_approach01(root.right);

        int[] myAns = new int[2];

        if (root.left != null && root.right != null) {
            myAns[0] = Math.max(Math.max(leftResult[0], rightResult[0]), leftResult[1] + rightResult[1] + root.val);
        } else {
            myAns[0] = Math.max(leftResult[0], rightResult[0]);
        }

        myAns[1] = Math.max(leftResult[1], rightResult[1]) + root.val;

        return myAns;
    }

// ----------------------------------------------------------------------------------------------------

    // Approach -> 02 using static variable
    private static int maxPathSumLeafToLeaf = -(int)1e9 - 1;
    public static int maxPathSum_approach02(TreeNode root) {
        maxPathSumHelper_approach02(root);
        return maxPathSumLeafToLeaf;
    }

    // returns maxPathSumFromLeafToNode
    private static int maxPathSumHelper_approach02(TreeNode root) {
        if(root == null) return -(int)1e9 - 1;

        if(root.left == null && root.right == null) return root.val;

        int leftMaxSumLeafToNode =  maxPathSumHelper_approach02(root.left);
        int rightMaxSumLeafToNode = maxPathSumHelper_approach02(root.right);

        if(root.left != null && root.right != null) {
            maxPathSumLeafToLeaf = Math.max(maxPathSumLeafToLeaf, leftMaxSumLeafToNode + rightMaxSumLeafToNode + root.val);
        }

        return Math.max(leftMaxSumLeafToNode, rightMaxSumLeafToNode) + root.val;
    }
}
