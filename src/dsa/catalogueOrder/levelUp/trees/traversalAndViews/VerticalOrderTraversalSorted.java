package dsa.catalogueOrder.levelUp.trees.traversalAndViews;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class VerticalOrderTraversalSorted {
    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static class Pair{
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
        if(node == null) return ;
        if(minLeft > state) minLeft = state;

        if(maxRight < state) maxRight = state;

        getMaxShadowWidthHelper(node.left, state-1);
        getMaxShadowWidthHelper(node.right, state+1);
    }

    public static ArrayList<ArrayList<Integer>> verticalOrderTraversalII(TreeNode root) {
        int width = getMaxShadowWidth(root);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < width; i++) {
            ans.add(new ArrayList<>());
        }

        PriorityQueue<Pair> mainQ = new PriorityQueue<>((p1, p2) -> p1.node.val - p2.node.val);
        PriorityQueue<Pair> childQ = new PriorityQueue<>((p1, p2) -> p1.node.val - p2.node.val);

        mainQ.add(new Pair(root, Math.abs(minLeft)));
        while(!mainQ.isEmpty()) {
            while(!mainQ.isEmpty()) {
                Pair rem = mainQ.remove();

                if(rem.node.left != null) childQ.add(new Pair(rem.node.left, rem.state - 1));

                if(rem.node.right != null) childQ.add(new Pair(rem.node.right, rem.state + 1));

                ans.get(rem.state).add(rem.node.val);
            }
            // swap mainQ and childQ
            PriorityQueue<Pair> temp = mainQ;
            mainQ = childQ;
            childQ = temp;
        }
        return ans;
    }

}
