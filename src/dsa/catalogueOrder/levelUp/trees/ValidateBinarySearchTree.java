package dsa.catalogueOrder.levelUp.trees;

public class ValidateBinarySearchTree {

    private static class TreeNode {
        int val;
        TreeNode left = null, right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private TreeNode prev = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        if (isValidBST(root.left) == false) return false;

        if (prev != null && prev.val >= root.val) return false; // using inorder property -> we know that no element would be greater than the previous element

        prev = root;

        if (isValidBST(root.right) == false) return false;

        return true;
    }
}
