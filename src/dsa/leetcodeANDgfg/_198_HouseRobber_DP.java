package dsa.leetcodeANDgfg;

// https://leetcode.com/problems/house-robber/
// # Pattern : Max Sum Non Adjacent Elements
public class _198_HouseRobber_DP {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];

        Integer[] dp = new Integer[nums.length + 1];
        return solution(0, nums, dp);
    }

    private int solution(int idx, int[] profits, Integer[] dp) {
        if(idx >= profits.length)
            return 0;

        if(dp[idx] != null) return dp[idx];

        int robCurrHouse = profits[idx] + solution(idx+2, profits, dp);

        int notRobCurrHouse = solution(idx+1, profits, dp);

        return dp[idx] = Math.max(robCurrHouse, notRobCurrHouse);
    }
}
