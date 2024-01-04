package dsa.catalogueOrder.levelUp.trees;

import java.util.ArrayList;
import java.util.List;

public class SingleChildParentBinaryTree {

    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Get all Single Child Nodes
    public static ArrayList<Integer> exactlyOneChild(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        exactlyOneChild_(root, ans);
        return ans;
    }

    private static void exactlyOneChild_(TreeNode root, List<Integer> list) {
        if(root == null || root.left == null && root.right == null) return; // either node is null or it's a leaf node

        if(root.left == null || root.right == null) { // if either of the child is null for current node, then it is one of my answer
            list.add(root.val);
        }

        exactlyOneChild_(root.left, list);
        exactlyOneChild_(root.right, list);
    }

// ----------------------------------------------------------------------------

    // Count all single child nodes
    public static int countExactlyOneChild(TreeNode root) {
        if(root == null || root.left == null && root.right == null) return 0;

        int singleChildNodesInLeft = countExactlyOneChild(root.left);
        int singleChildNodesInRight = countExactlyOneChild(root.right);

        int ans = singleChildNodesInLeft + singleChildNodesInRight;

        if(root.left == null || root.right == null) ans = ans + 1;

        return ans;
    }
}
