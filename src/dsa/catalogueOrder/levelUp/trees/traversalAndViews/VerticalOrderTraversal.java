package dsa.catalogueOrder.levelUp.trees.traversalAndViews;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class VerticalOrderTraversal {

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

    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode node) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(node == null) return ans;

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(node, 0));

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        while(q.size() > 0) {
            int currentLevelSize = q.size();
            for(int i = 1; i <= currentLevelSize; i++) {
                Pair remPair = q.remove();

                if(minLeft > remPair.state) minLeft = remPair.state;

                if(maxRight < remPair.state) maxRight = remPair.state;

                if(remPair.node.left != null) q.add(new Pair(remPair.node.left, remPair.state-1));

                if(remPair.node.right != null) q.add(new Pair(remPair.node.right, remPair.state+1));

                addNodeInMap(map, remPair);
            }
        }

        // put all the lists from map to ans in ascending order of keys
        for(int i = minLeft; i <= maxRight; i++) {
            ans.add(map.get(i));
        }
        return ans;
    }

    private static void addNodeInMap(HashMap<Integer, ArrayList<Integer>> map, Pair pair) {
        if(map.containsKey(pair.state)) {
            map.get(pair.state).add(pair.node.val);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(pair.node.val);
            map.put(pair.state, list);
        }
    }

    // --------------------------------------------------------------------------- Method 2 when returning array

    private int getMaxShadowWidth(TreeNode root) {
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

    public ArrayList<ArrayList<Integer>> verticalOrderTraversalWithoutHashMap(TreeNode node) {
        int width = getMaxShadowWidth(node);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if(node == null) return ans;

        for(int i = 0; i < width; i++) ans.add(new ArrayList<>());

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(node, Math.abs(minLeft)));
        while(q.size() > 0) {
            int currentLevelSize = q.size();
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 1; i <= currentLevelSize; i++) {
                Pair remPair = q.remove();

                if(remPair.node.left != null) q.add(new Pair(remPair.node.left, remPair.state-1));

                if(remPair.node.right != null) q.add(new Pair(remPair.node.right, remPair.state+1));

                // add remPair.node in ans
                ans.get(remPair.state).add(remPair.node.val);
            }
        }
        return ans;
    }
}
