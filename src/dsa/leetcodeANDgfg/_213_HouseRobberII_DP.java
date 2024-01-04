package dsa.leetcodeANDgfg;

// Link  : https://leetcode.com/problems/house-robber-ii/description/
/* Since all the houses are arranged in a circle which means 1st and last house are adjacent...
 * therefore use one more parameter (endIdx) to control the access, in houseRobber(198) we used nums.length-1 to control the access
**/
public class _213_HouseRobberII_DP {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];

        Integer[] dp = new Integer[nums.length + 1];
        // if you rob the first house then can't rob the last house, hence endIdx becomes nums.length-2
        int robFirstHouse = robHelper(nums, 0, nums.length-2, dp);

        dp = new Integer[nums.length + 1];
        // if you rob the second house then you have the option to rob the last house as well, hence endIdx becomes nums.length-1
        int notRobFirstHouse = robHelper(nums, 1, nums.length-1, dp);

        return Math.max(robFirstHouse, notRobFirstHouse);
    }

    private int robHelper(int[] nums, int startIdx, int endIdx, Integer[] dp) {
        if(startIdx > endIdx)
            return 0;

        if(dp[startIdx] != null)
            return dp[startIdx];

        int robCurrent = nums[startIdx] + robHelper(nums, startIdx + 2, endIdx, dp);

        int notRobCurrent = robHelper(nums, startIdx + 1, endIdx, dp);

        return dp[startIdx] = Math.max(robCurrent, notRobCurrent);
    }
}
