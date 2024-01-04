package dsa.catalogueOrder.levelUp.trees;

import java.util.ArrayList;

public class MorrisTraversal {

    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<Integer> morrisInOrderTraversal(TreeNode node) {
        ArrayList<Integer> ans = new ArrayList<>();
        TreeNode current = node;

        while(current != null) {
            TreeNode leftNode = current.left;
            if(leftNode == null) {
                ans.add(current.val);
                current = current.right;
            } else {
                TreeNode rightMostNode = getRightMostNode(leftNode, current);

                if(rightMostNode.right == null) { // Create Thread
                    rightMostNode.right = current;
                    current = current.left;
                } else { // Remove already existing Thread
                    rightMostNode.right = null;
                    ans.add(current.val);
                    current = current.right;
                }
            }
        }

        return ans;
    }

    public static ArrayList<Integer> morrisPreOrderTraversal(TreeNode node) {
        ArrayList<Integer> ans = new ArrayList<>();
        TreeNode current = node;

        while(current != null) {
            TreeNode leftNode = current.left;
            if(leftNode == null) {
                ans.add(current.val);
                current = current.right;
            } else {
                TreeNode rightMostNode = getRightMostNode(leftNode, current);

                if(rightMostNode.right == null) { // Create Thread
                    rightMostNode.right = current;
                    ans.add(current.val);
                    current = current.left;
                } else { // Remove already existing Thread
                    rightMostNode.right = null;
                    current = current.right;
                }
            }
        }

        return ans;
    }

    private static TreeNode getRightMostNode(TreeNode leftNode, TreeNode current) {
        while(leftNode.right != null && leftNode.right != current) {
            leftNode = leftNode.right;
        }
        return leftNode;
    }

}
