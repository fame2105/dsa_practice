package dsa.catalogueOrder.levelUp.trees.construct.bst;

public class ConstructBinarySearchTreeFromPostorder {

    private static class TreeNode {
        int val;
        TreeNode left = null, right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static int idx = 0;
    public static TreeNode bstFromPostorder(int postorder[]) {
        idx = postorder.length - 1;
        int left = -(int) 1e9 - 1;
        int right = (int) 1e9 + 1;

        return buildTreeHelper(postorder, left, right);
    }

    private static TreeNode buildTreeHelper(int[] postorder, int left, int right) {
        if(idx < 0 || postorder[idx] < left || postorder[idx] > right)  return null;

        int root = postorder[idx--];
        TreeNode rootNode = new TreeNode(root);

        rootNode.right = buildTreeHelper(postorder, root, right);
        rootNode.left = buildTreeHelper(postorder, left, root);

        return rootNode;
    }
}
