package dsa.catalogueOrder.levelUp.trees.traversalAndViews;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopViewOfBinaryTree {

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

        public Pair(TreeNode node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    private static int minLeft = Integer.MAX_VALUE;
    private static int maxRight = Integer.MIN_VALUE;

    private static int getMaxShadowWidth(TreeNode root) {
        minLeft = Integer.MAX_VALUE;
        maxRight = Integer.MIN_VALUE;
        getMaxShadowWidthHelper(root, 0);
        return maxRight - minLeft + 1;
    }

    private static void getMaxShadowWidthHelper(TreeNode node, int state) {
        if (node == null) return;
        if (minLeft > state) minLeft = state;

        if (maxRight < state) maxRight = state;

        getMaxShadowWidthHelper(node.left, state - 1);
        getMaxShadowWidthHelper(node.right, state + 1);
    }

    public static List<Integer> topView(TreeNode root) {
        int width = getMaxShadowWidth(root);
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            ans.add(null);
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, Math.abs(minLeft)));

        while (!q.isEmpty()) {

            Pair remPair = q.remove();

            if (remPair.node.left != null) q.add(new Pair(remPair.node.left, remPair.state - 1));

            if (remPair.node.right != null) q.add(new Pair(remPair.node.right, remPair.state + 1));

            // add remPair.node in ans
            if (ans.get(remPair.state) == null) ans.set(remPair.state, remPair.node.val);

    }
        return ans;
}
}
