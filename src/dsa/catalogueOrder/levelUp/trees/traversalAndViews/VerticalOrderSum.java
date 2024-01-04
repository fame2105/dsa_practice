package dsa.catalogueOrder.levelUp.trees.traversalAndViews;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class VerticalOrderSum {
    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static class Pair {
        TreeNode node;
        int state;

        Pair(TreeNode node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    private static int minLeft = 0;
    private static int maxRight = 0;

    private static int width(TreeNode node) {
        minLeft = Integer.MAX_VALUE;
        maxRight = Integer.MIN_VALUE;
        widthHelper(node, 0);
        return maxRight - minLeft;
    }

    private static void widthHelper(TreeNode node, int state) {
        if (node == null) return;

        if (minLeft > state) minLeft = state;
        if (maxRight < state) maxRight = state;

        widthHelper(node, state - 1);
        widthHelper(node, state + 1);
    }

    public static ArrayList<Integer> verticalOrderSum(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        int width = width(root);
        for (int i = 0; i < width; i++) {
            ans.add(0);
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, Math.abs(minLeft)));
        while (!q.isEmpty()) {
            Pair remPair = q.remove();

            if (remPair.node.left != null) q.add(new Pair(remPair.node.left, remPair.state - 1));

            if (remPair.node.right != null) q.add(new Pair(remPair.node.right, remPair.state + 1));

            int sumSoFar = ans.get(remPair.state);
            ans.set(remPair.state, sumSoFar + remPair.node.val);
        }

        return ans;
    }

}
