package dsa.catalogueOrder.levelUp.trees.construct.bst;

import java.util.LinkedList;
import java.util.Queue;

public class ConstructBinarySearchTreeFromLevelOrder {

    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static class Pair {
        TreeNode parent;
        int leftBoundary;
        int rightBoundary;

        Pair(){
            this.parent = null;
            this.leftBoundary = -(int) 1e9;
            this.rightBoundary = (int) 1e9;
        }

        Pair(TreeNode parent, int leftBoundary, int rightBoundary) {
            this.parent = parent;
            this.leftBoundary = leftBoundary;
            this.rightBoundary = rightBoundary;
        }
    }

    public static TreeNode buildTree(int[] levelOrder) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair());
        TreeNode root = null;
        int idx = 0;
        while(q.size() > 0 && idx < levelOrder.length) {
            Pair removePair = q.remove();
            int element = levelOrder[idx++];
            if(element < removePair.leftBoundary || element > removePair.rightBoundary) continue;

            TreeNode node = new TreeNode(element);
            if (removePair.parent == null) root = node;
            else {
                TreeNode parent = removePair.parent;
                if(element <= parent.val) parent.left = node;
                else parent.right = node;
            }

            q.add(new Pair(node, removePair.leftBoundary, element));
            q.add(new Pair(node, element, removePair.rightBoundary));
        }

        return root;
    }
}
