package dsa.catalogueOrder.levelUp.trees.pathSum;

public class _1_HasPathSum {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;

        if (root.left == null && root.right == null) {
            return targetSum - root.val == 0;
        }

        int remainingSum = targetSum - root.val;
        boolean canLSTMakeRemainingSum = hasPathSum(root.left, remainingSum);
        boolean canRSTMakeRemainingSum = hasPathSum(root.right, remainingSum);

        return canLSTMakeRemainingSum || canRSTMakeRemainingSum;
    }



}
