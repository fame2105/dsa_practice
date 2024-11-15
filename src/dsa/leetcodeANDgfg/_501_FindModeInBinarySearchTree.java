package dsa.leetcodeANDgfg;

import dsa.utility.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _501_FindModeInBinarySearchTree {
    public int[] findMode(TreeNode root) {
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        populateFrequencyMap(root, map);
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            max = Math.max(max, entry.getValue());
        }

        List<Integer> lst = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() == max) {
                lst.add(entry.getKey());
            }
        }
        int[] ans = new int[lst.size()];
        for(int i = 0; i < lst.size(); i++) {
            ans[i] = lst.get(i);
        }
        return ans;
    }

    private void populateFrequencyMap(TreeNode root, Map<Integer, Integer> fmap) {
        if(root == null)
            return;

        fmap.put(root.val, fmap.getOrDefault(root.val, 0)+1);
        populateFrequencyMap(root.left, fmap);
        populateFrequencyMap(root.right, fmap);
    }
}
