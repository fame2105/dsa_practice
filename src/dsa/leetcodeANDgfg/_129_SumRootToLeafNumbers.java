package dsa.leetcodeANDgfg;

import java.util.ArrayList;
import java.util.List;

public class _129_SumRootToLeafNumbers {
    private class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    public int sumNumbers(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        dfs(root, new StringBuilder(""), nums);

        int sum = 0;
        for(int num : nums) {
            sum += num;
        }

        return sum;
    }

    private void dfs(TreeNode root, StringBuilder sb, List<Integer> nums) {
        if(root == null) return;

        if(root.left == null && root.right == null) {
            sb.append(root.val);
            nums.add(Integer.parseInt(sb.toString()));
            sb.deleteCharAt(sb.length() - 1);
            return;
        }

        sb.append(root.val);

        dfs(root.left,sb,nums);
        dfs(root.right,sb,nums);

        sb.deleteCharAt(sb.length() - 1);
    }
}
