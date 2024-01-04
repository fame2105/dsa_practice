package dsa.catalogueOrder.levelUp.trees.construct.bst;

// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
public class ConstructBinarySearchTreeFromInorder {

    private static class TreeNode {
        int val;
        TreeNode left = null, right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static TreeNode constructBSTFromInOrder(int[] inorder) {
         return buildTreeHelper(inorder, 0, inorder.length - 1);
    }

    private static TreeNode buildTreeHelper(int[] inorder, int lo, int hi) {
        if(lo > hi) return null;

        int mid = hi - (hi - lo)/2;
        TreeNode root = new TreeNode(inorder[mid]);

        root.left = buildTreeHelper(inorder, lo, mid-1);
        root.right = buildTreeHelper(inorder, mid+1, hi);
        return root;
    }
}
