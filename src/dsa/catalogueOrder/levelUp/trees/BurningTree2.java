package dsa.catalogueOrder.levelUp.trees;

import java.util.ArrayList;
import java.util.List;

public class BurningTree2 {

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static List<List<Integer>> burningTree(TreeNode root, int data) {
        List<List<Integer>> ans = new ArrayList<>();
        burningTreeHelper(root, data, ans);
        return ans;
    }

    private static int burningTreeHelper(TreeNode root, int fireNode, List<List<Integer>> ans) {
        if (root == null) return -1;

        if (root.val == fireNode) {
            kDown(root, null, 0, ans);
            return 1;
        }

        int ld = burningTreeHelper(root.left, fireNode, ans);
        if (ld != -1) {
            kDown(root, root.left, ld, ans);
            return ld + 1;
        }

        int rd = burningTreeHelper(root.right, fireNode, ans);
        if (rd != -1) {
            kDown(root, root.right, rd, ans);
            return rd + 1;
        }

        return -1;
    }

    private static void kDown(TreeNode node, TreeNode blockage, int k, List<List<Integer>> ans) {
        if (node == null || node == blockage) return;

        if (k == ans.size()) ans.add(new ArrayList<>());

        ans.get(k).add(node.val);

        kDown(node.left, blockage, k + 1, ans);
        kDown(node.right, blockage, k + 1, ans);
    }

}
