package dsa.leetcodeANDgfg;

// https://leetcode.com/problems/binary-tree-pruning/
public class _814_BinaryTreePruning {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val,TreeNode left,TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public TreeNode pruneTree(TreeNode root) {
        boolean pruneRoot = prune(root);
        if(pruneRoot == false) root = null;
        return root;
    }

    /**
     * Decesion for each node is done on the basis of its LeftSubTree result, current Node's value and its RightSubTree result
     * For a leaf node, we would get false for its null childs, hence placing the check for null while removing left and right childs
     */
    private boolean prune(TreeNode root) {
        if(root == null) return false;

        boolean myAns = false;
        if(root.val == 1)
            myAns = true;

        boolean left = prune(root.left);
        if(left == false && root.left != null)
            root.left = null;

        boolean right = prune(root.right);
        if(right == false && root.right != null)
            root.right = null;

        return left || myAns || right;
    }
}
