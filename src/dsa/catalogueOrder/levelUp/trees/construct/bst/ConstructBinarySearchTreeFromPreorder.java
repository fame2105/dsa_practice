package dsa.catalogueOrder.levelUp.trees.construct.bst;

// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/
public class ConstructBinarySearchTreeFromPreorder {

    private static class TreeNode {
        int val;
        TreeNode left = null, right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static int idx = 0;
    public static TreeNode bstFromPreorder(int[] preorder) {
        idx = 0;
        int left = -(int)1e8 - 1; //  as per constraints
        int right = (int)1e8 + 1; // as per constraints

        return buildBSTHelper(preorder, left, right);
    }

    private static TreeNode buildBSTHelper(int[] preorder, int left, int right) {
        if(idx >= preorder.length || preorder[idx] > right || preorder[idx] < left) return null;

        int root = preorder[idx++];
        TreeNode rootNode = new TreeNode(root);
        rootNode.left = buildBSTHelper(preorder, left, rootNode.val);
        rootNode.right = buildBSTHelper(preorder, rootNode.val, right);

        return rootNode;
    }
}
