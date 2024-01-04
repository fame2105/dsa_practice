package dsa.catalogueOrder.levelUp.trees;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/maximum-width-of-binary-tree/  # LevelOrderTraversal
public class _662_MaxWidthOfTree {
    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private class Pair {
        TreeNode node;
        int idx;
        Pair(TreeNode node, int idx) {
            this.node = node;
            this.idx = idx;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        return bfs(root);
    }

    private int bfs(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));

        int maxWidth = 0;
        while(q.size() > 0) {
            int size = q.size();
            int leftMostIdx = q.peek().idx;
            int rightMostIdx = q.peek().idx;
            for(int i = 1; i <= size; i++) {
                Pair rem = q.remove();

                rightMostIdx = rem.idx;

                if(rem.node.left != null) { // push left child in the queue
                    int nodeIdx = (rem.idx * 2) + 1;
                    q.add(new Pair(rem.node.left, nodeIdx));
                }

                if(rem.node.right != null) { // push right child in the queue
                    int nodeIdx = (rem.idx * 2) + 2;
                    q.add(new Pair(rem.node.right, nodeIdx));
                }

                maxWidth = Math.max(maxWidth, rightMostIdx - leftMostIdx + 1);
            }
        }

        return maxWidth;
    }
}
