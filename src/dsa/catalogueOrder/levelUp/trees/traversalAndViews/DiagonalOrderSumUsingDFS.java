package dsa.catalogueOrder.levelUp.trees.traversalAndViews;

import java.util.ArrayList;

public class DiagonalOrderSumUsingDFS {

    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<Integer> diagonalOrderSum(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        dfs(root, 0, ans);
        return ans;
    }

    // We could get diagonalOrderSum using DFS because the order of nodes within the diagonal doesn't matter as it does during DiagonalOrderTraversal
    private static void dfs(TreeNode root, int diagonalNumber, ArrayList<Integer> ans) {
        if(root == null)
            return;

        if(ans.size() == diagonalNumber) {
            ans.add(0);
        }

        ans.set(diagonalNumber, ans.get(diagonalNumber) + root.val);

        dfs(root.left, diagonalNumber+1, ans);
        dfs(root.right, diagonalNumber, ans);
    }
}
