package dsa.leetcodeANDgfg;

//    https://leetcode.com/problems/count-good-nodes-in-binary-tree/
public class _1448_BT_CountGoodNodes {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private static int count = 0;

    public int goodNodes(TreeNode root) {
        count = 0; // initialize, since count is declared static.
        preorder(root, Integer.MIN_VALUE);
        return count;
    }


    private void preorder(TreeNode root, int max) {
        if (root == null) return;

        if (root.val >= max) {
            count += 1;
        }

        max = Math.max(max, root.val);
        preorder(root.left, max);
        preorder(root.right, max);
    }
}
