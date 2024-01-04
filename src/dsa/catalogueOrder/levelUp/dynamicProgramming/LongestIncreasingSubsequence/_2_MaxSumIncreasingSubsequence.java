package dsa.catalogueOrder.levelUp.dynamicProgramming.LongestIncreasingSubsequence;

public class _2_MaxSumIncreasingSubsequence {

    public static int maxSumIncreasingSubsequence(int[] nums) {
        int result = 0;
        int[] dp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int currNum = nums[i];
            int prevMaxSum = 0;

            for (int j = 0; j < i; j++) {
                int prevNum = nums[j];

                if (currNum >= prevNum) {
                    prevMaxSum = Math.max(prevMaxSum, dp[j]);
                }
            }
            dp[i] = prevMaxSum + currNum;

            result = Math.max(result, dp[i]);
        }

        return result;
    }
}
