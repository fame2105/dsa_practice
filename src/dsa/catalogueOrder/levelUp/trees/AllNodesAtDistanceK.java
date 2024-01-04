package dsa.catalogueOrder.levelUp.trees;

import java.util.ArrayList;
import java.util.List;

public class AllNodesAtDistanceK {

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public static List<Integer> distanceK(TreeNode root, int target, int k) {
        List<Integer> ans = new ArrayList<>();
        distanceKHelper(root, target, k, ans);
        return ans;
    }

    private static int distanceKHelper(TreeNode root, int target, int k, List<Integer> ans) {
        if(root == null) return -1;

        if(root.val == target) {
            kDown(root, null, k, ans);
            return 1;
        }

        int ld = distanceKHelper(root.left, target, k, ans);
        if(ld > -1) {
            kDown(root, root.left, k-ld, ans);
            return ld+1;
        }

        int rd = distanceKHelper(root.right, target, k, ans);

        if(rd > -1) {
            kDown(root, root.right, k - rd, ans);
            return rd+1;
        }

        return -1;
    }

    private static void kDown(TreeNode root, TreeNode blockNode, int k, List<Integer> ans) {
        if(root == null || k < 0 || root == blockNode) return;

        if(k == 0) {
            ans.add(root.val);
            return;
        }

        kDown(root.left, blockNode, k-1, ans);
        kDown(root.right, blockNode, k-1, ans);
    }
}
