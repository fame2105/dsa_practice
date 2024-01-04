package dsa.catalogueOrder.levelUp.trees.construct.binaryTree;

import java.util.ArrayList;
import java.util.HashSet;

// https://practice.geeksforgeeks.org/problems/construct-tree-from-inorder-and-levelorder/1

public class ConstructBinaryTreeFromLevelOrderAndInorder {

    static private class TreeNode {
        int val;
        TreeNode left = null, right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    TreeNode buildTree(int inorder[], int level[]){
        ArrayList<Integer> lvlList = new ArrayList<>();

        for(int i : level) lvlList.add(i);

        return buildTreeHelper(inorder, lvlList, 0, inorder.length - 1);

    }

    TreeNode buildTreeHelper(int[] inorder, ArrayList<Integer> level, int isi, int iei) {
        if(level.isEmpty() || isi > iei) return null;

        int root = level.get(0);
        int idx = isi;
        HashSet<Integer> leftSubTree = new HashSet<>();
        while(inorder[idx] != root) {
            leftSubTree.add(inorder[idx]);
            idx++;
        }

        ArrayList<Integer> left = new ArrayList<>();
        ArrayList<Integer> right = new ArrayList<>();

        for(int i = 1; i < level.size(); i++) {
            int val = level.get(i);

            if (leftSubTree.contains(val)) left.add(val);

            else right.add(val);
        }

        TreeNode rootNode = new TreeNode(root);
        rootNode.left = buildTreeHelper(inorder, left, isi, idx-1);
        rootNode.right = buildTreeHelper(inorder, right, idx+1, iei);
        return rootNode;
    }
}
