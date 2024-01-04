package dsa.catalogueOrder.levelUp.trees;

import java.util.ArrayList;
import java.util.List;

public class NodeToRootPathBinaryTree {
    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static boolean findData(TreeNode root, int data, List<TreeNode> ans) {
        if (root == null) return false;

        if (root.val == data) {
            ans.add(root);
            return true;
        }

        boolean foundInSubTree = findData(root.left, data, ans) || findData(root.right, data, ans);

        if (foundInSubTree == true) {
            ans.add(root);
        }

        return foundInSubTree;

    }

    // heapMover method..... since the passed reference to list is present in the heap and reference to that list is being moved around
    public static List<TreeNode> nodeToRootPath_approach1(TreeNode node, int data) {
        List<TreeNode> ans = new ArrayList<>();
        findData(node, data, ans);
        return ans;
    }

    // ----------------------------------------------------------------------------------------------

    // return-type method.
    public static ArrayList<TreeNode> nodeToRootPath_approach2(TreeNode node, int data) {
        if (node == null) return null;

        if (node.val == data) {
            ArrayList<TreeNode> ans = new ArrayList<>();
            ans.add(node);
            return ans;
        }

        ArrayList<TreeNode> leftPath = nodeToRootPath_approach2(node.left, data);

        if (leftPath != null) {
            leftPath.add(node);
            return leftPath;
        }

        ArrayList<TreeNode> rightPath = nodeToRootPath_approach2(node.right, data);

        if (rightPath != null) {
            rightPath.add(node);
        }

        return new ArrayList<>();
    }

}
