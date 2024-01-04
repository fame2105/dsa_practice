package dsa.catalogueOrder.levelUp.trees;

public class RecoverBST {
    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // using Morris Inorder Traversal
    public static void recoverTree(TreeNode root) {
        TreeNode current = root, prev = null, a = null, b = null;
        while(current != null) {
            TreeNode leftNode = current.left;
            if(leftNode == null) {
                 if(prev != null && prev.val > current.val) {
                     if(a == null)
                         a = prev;
                     b = current;
                 }
                 prev = current;
                current = current.right;
            } else {
                TreeNode rightMostNode = getRightMostNode(leftNode, current);
                if(rightMostNode.right == null) {
                    rightMostNode.right = current;
                    current = current.left;
                } else {
                    rightMostNode.right = null;
                    if(prev.val > current.val) {
                        if(a == null)
                            a = prev;
                        b = current;
                    }
                    prev = current;
                    current = current.right;
                }
            }
        }

        if(a != null) {
            int temp = a.val;
            a.val = b.val;
            b.val = temp;
        }
    }

    private static TreeNode getRightMostNode(TreeNode leftNode, TreeNode current) {
        while(leftNode.right != null && leftNode.right != current) {
            leftNode = leftNode.right;
        }
        return leftNode;
    }

// ---------------------------------------------------------------------------------------


    public static void recoverTreeRecursion(TreeNode root) {

    }
}
