package dsa.catalogueOrder.levelUp.trees.traversalAndViews;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DiagonalOrderOfBinaryTree {
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
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int numOfComponents = q.size();
            ArrayList<Integer> currentDiagonal = new ArrayList<>();

            for(int i = 1; i <= numOfComponents; i++) { // number of components
                TreeNode remNode = q.remove();

                while(remNode != null) { // iterating on the 1st node of each component
                    currentDiagonal.add(remNode.val);
                    if(remNode.left != null) q.add(remNode.left);

                    remNode = remNode.right;
                }
            }

            ans.add(currentDiagonal);
        }

        return ans;
    }
}
