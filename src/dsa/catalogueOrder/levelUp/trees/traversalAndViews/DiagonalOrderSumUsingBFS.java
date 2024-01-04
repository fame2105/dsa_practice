package dsa.catalogueOrder.levelUp.trees.traversalAndViews;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DiagonalOrderSumUsingBFS {

    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<Integer> diagonalOrderSum(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {

            int numOfComponents = q.size();
            int currentDiagonalSum = 0;

            for (int i = 1; i <= numOfComponents; i++) {
                TreeNode remNode = q.remove();

                while (remNode != null) {
                    if (remNode.left != null) q.add(remNode.left);
                    currentDiagonalSum += remNode.val;
                    remNode = remNode.right;
                }
            }

            ans.add(currentDiagonalSum);
        }
        return ans;
    }
}
