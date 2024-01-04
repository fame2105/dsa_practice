package dsa.catalogueOrder.levelUp.trees.pathSum;

import java.util.HashMap;
import java.util.Map;

// PreRequisite : CountOfSubarraySumEqualK
public class PathSumEqualToGivenValue {

    private static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private static int count = 0;
    public static int pathSumCount(TreeNode root, int targetSum) {
        Map<Integer, Integer> map = new HashMap<>(); // prefixSum : frequency
        map.put(0, 1);
        pathSumCountHelper(root, targetSum, 0, map);
        return count;
    }

    private static void pathSumCountHelper(TreeNode root, int targetSum, int prefixSum, Map<Integer, Integer> map) {
        if(root == null) return;

        prefixSum += root.val;

        int key = prefixSum - targetSum;
        if(map.containsKey(key)) count += map.get(key);

        if (map.containsKey(prefixSum))
            map.put(prefixSum, map.get(prefixSum) + 1);
        else
            map.put(prefixSum, 1);

        pathSumCountHelper(root.left, targetSum, prefixSum, map);
        pathSumCountHelper(root.right, targetSum, prefixSum, map);

        map.put(prefixSum, map.get(prefixSum) - 1);
        if(map.get(prefixSum) <= 0) map.remove(prefixSum);
    }
}
