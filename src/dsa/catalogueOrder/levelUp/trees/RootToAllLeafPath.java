package dsa.catalogueOrder.levelUp.trees;

import dsa.catalogueOrder.levelUp.trees.pathSum.MaxPathSumBetweenTwoLeaves;

import java.util.ArrayList;

public class RootToAllLeafPath {
    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static ArrayList<ArrayList<Integer>> rootToAllLeafPath(TreeNode root) {
        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        rootToAllLeafPathHelper(root, new ArrayList<>(), paths);
        return paths;
    }

    private static void rootToAllLeafPathHelper(TreeNode root, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> paths) {
        if (root == null) return;
        if (root.left == null && root.right == null) {
            path.add(root.val);
            ArrayList<Integer> pathCopy = new ArrayList<>(path);
            paths.add(pathCopy);
            path.remove(path.size() - 1);
            return;
        }

        path.add(root.val);
        rootToAllLeafPathHelper(root.left, path, paths);
        rootToAllLeafPathHelper(root.right, path, paths);
        path.remove(path.size() - 1);
    }
}
