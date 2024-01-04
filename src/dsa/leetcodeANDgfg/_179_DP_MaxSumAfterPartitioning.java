package dsa.leetcodeANDgfg;

// https://leetcode.com/problems/partition-array-for-maximum-sum/
// recursion tree drawn in Samsung Notes
public class _179_DP_MaxSumAfterPartitioning {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        Integer[] dp = new Integer[arr.length+1];
        return rec(arr, k, 0, dp);
    }

    private int rec(int[] arr, int k, int idx, Integer[] dp) {
        if(idx >= arr.length) return 0;

        if(dp[idx] != null) {
            return dp[idx];
        }

        int max = Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        int len = 0;

        for(int i = idx; i < idx + k && i < arr.length; i++) {
            len += 1;
            max = Math.max(max, arr[i]);
            sum = (len * max) + rec(arr, k, i+1, dp);
            maxSum = Math.max(sum, maxSum);
        }

        return dp[idx] = maxSum;
    }
}
