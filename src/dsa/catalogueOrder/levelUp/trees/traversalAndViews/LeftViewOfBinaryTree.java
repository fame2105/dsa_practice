package dsa.catalogueOrder.levelUp.trees.traversalAndViews;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeftViewOfBinaryTree {
    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<Integer> leftView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int numberOfNodesOnThisLevel = q.size();
            boolean currentLevelProcessed = false;

            for (int i = 1; i <= numberOfNodesOnThisLevel; i++) {
                TreeNode remNode = q.remove();
                if(currentLevelProcessed == false) {
                    ans.add(remNode.val);
                    currentLevelProcessed = true;
                }

                if(remNode.left != null) q.add(remNode.left);
                if(remNode.right != null) q.add(remNode.right);
            }
        }
        return ans;
    }
}
