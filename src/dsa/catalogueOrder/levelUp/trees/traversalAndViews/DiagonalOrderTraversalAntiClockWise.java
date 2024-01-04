package dsa.catalogueOrder.levelUp.trees.traversalAndViews;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DiagonalOrderTraversalAntiClockWise {
    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }
    public static List<List<Integer>> diagonalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {

            int numOfComponents = q.size();
            ArrayList<Integer> currentDiagonal = new ArrayList<>();

            for(int i = 1; i <= numOfComponents; i++) {
                TreeNode remNode = q.remove();

                while(remNode != null) {
                    if(remNode.right != null) q.add(remNode.right);
                    currentDiagonal.add(remNode.val);
                    remNode = remNode.left;
                }
            }

            ans.add(currentDiagonal);
        }
        return ans;
    }

}
