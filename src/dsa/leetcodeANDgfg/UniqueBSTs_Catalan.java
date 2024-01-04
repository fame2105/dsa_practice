package dsa.leetcodeANDgfg;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/unique-binary-search-trees-ii/
public class UniqueBSTs_Catalan {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val,TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> ans = new ArrayList<>();
        helper(1, n, ans);
        return ans;
    }

    private List<TreeNode> helper(int start, int end, List<TreeNode> ans) {
        if(start > end) {
            List<TreeNode> nullList = new ArrayList<>();
            nullList.add(null);
            return nullList;
        }

        for(int i = start; i <= end; i++) {
            List<TreeNode> left = helper(start, i-1, ans);
            List<TreeNode> right = helper(i+1, end, ans);

            for(TreeNode l : left) {
                for(TreeNode r : right) {
                    TreeNode bstRoot = new TreeNode(i); // make a new node with root value as i
                    bstRoot.left = l;
                    bstRoot.right = r;
                    ans.add(bstRoot);
                }
            }
        }
        return ans;
    }
}
