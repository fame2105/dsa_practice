package dsa.catalogueOrder.levelUp.trees.traversalAndViews;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BottomViewOfBinaryTree {

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

    /**
     * procedure to get bottom view is exactly same as vertical Order traversal:
     * Vertical Order Traversal
     * 0 -> 0
     * 1 -> 1,4,13
     * 2 -> 3,2,5,12
     * 3 -> 6,15,9,14
     * 4-> 10
     * 5 -> 11
     *
     * Bottom View of the above Vertical Order is the last value of each array list at every idx:
     * 0 -> 0
     * 1 -> 13
     * 2 -> 12
     * 3 -> 14
     * 4 -> 10
     * 5 -> 11
     *
     * therefore, for bottomView, do not make <list<List<Integer>> rather just List<Integer> and keep overriding values
     */
    public static List<Integer> bottomView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        int width = getMaxShadowWidth(root);
        for (int i = 0; i < width; i++) {
            ans.add(null);
        }

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, Math.abs(minLeft)));

        while(!q.isEmpty()) {
            Pair remPair = q.remove();

            if(remPair.node.left != null) q.add(new Pair(remPair.node.left, remPair.state - 1));

            if(remPair.node.right != null) q.add(new Pair(remPair.node.right, remPair.state + 1));

            ans.set(remPair.state, remPair.node.val);
        }

        return ans;
    }
}
