package dsa.catalogueOrder.levelUp.trees.pathSum;

import java.util.ArrayList;
import java.util.List;

public class _2_GetAllPathsForGivenSum {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        getPathSum(root, targetSum, new ArrayList<Integer>(), ans);
        return ans;
    }

    private void getPathSum(TreeNode root, int targetSum, List<Integer> path, List<List<Integer>> ans) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            if(targetSum - root.val == 0) {
                path.add(root.val);
                List<Integer> pathCopy = new ArrayList<>(path);
                ans.add(pathCopy);
                path.remove(path.size() - 1); // backtracking
            }
            return;
        }

        path.add(root.val);

        getPathSum(root.left, targetSum - root.val, path, ans);
        getPathSum(root.right, targetSum - root.val, path, ans);

        path.remove(path.size() - 1); // backtracking
    }
}
