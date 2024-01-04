package dsa.leetcodeANDgfg;

// https://leetcode.com/problems/check-if-there-is-a-valid-partition-for-the-array/
// Editorial : https://www.youtube.com/watch?v=jhvN_OtX7hY
public class _2369_DP_CheckValidPartitionForArray {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n + 1];

        dp[0] = true;
        for (int i = 2; i < dp.length; i++) {
            if (dp[i - 2] == true && nums[i - 1] == nums[i - 2])
                dp[i] = true;
            else if (i >= 3 && dp[i - 3] == true && nums[i - 1] == nums[i - 2] && nums[i - 2] == nums[i - 3])
                dp[i] = true;
            else if (i >= 3 && dp[i - 3] == true && nums[i - 1] - nums[i - 2] == 1 && nums[i - 2] - nums[i - 3] == 1)
                dp[i] = true;
        }

        return dp[n];
    }
}
