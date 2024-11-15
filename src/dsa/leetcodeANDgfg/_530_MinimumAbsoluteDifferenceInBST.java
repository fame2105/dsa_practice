package dsa.leetcodeANDgfg;

import dsa.utility.TreeNode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/minimum-absolute-difference-in-bst/description/
// https://leetcode.com/problems/minimum-distance-between-bst-nodes/

// same as _783
public class _530_MinimumAbsoluteDifferenceInBST {
    public int minDiffInBST(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        minDiffInBSTHelper(root, list);
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < list.size() - 1; i++) {
            min = Math.min(min, list.get(i+1) - list.get(i));
        }
        return min;
    }

    private void minDiffInBSTHelper(TreeNode root, List<Integer> list) {
        if(root == null) return;

        minDiffInBSTHelper(root.left, list);
        list.add(root.val);
        minDiffInBSTHelper(root.right, list);
    }
}
