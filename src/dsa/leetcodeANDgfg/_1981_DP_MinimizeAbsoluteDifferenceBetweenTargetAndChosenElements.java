package dsa.leetcodeANDgfg;

// https://leetcode.com/problems/minimize-the-difference-between-target-and-chosen-elements/
public class _1981_DP_MinimizeAbsoluteDifferenceBetweenTargetAndChosenElements {
    /**
     * using sum as 4901 because each value in each row of given matrix will never exceed 70 as per constraints
     * therefore in each row a max sum in worst case could be 70 * 70 = 4900
     */
    public int minimizeTheDifference(int[][] mat, int target) {
        int rows = mat.length;
        Integer[][] dp = new Integer[rows+1][4901];
        return getMinDifference(mat, 0, 0, target, dp);
    }

    /**
     *This is typical brute force solution , using dp[][] only to optimize
     */
    private int getMinDifference(int[][] mat, int row, int sum, int target, Integer[][] dp) {
        if(row == mat.length)
            return Math.abs(sum - target);

        if(dp[row][sum] != null)
            return dp[row][sum];

        int minDiff = Integer.MAX_VALUE;

        for(int col = 0; col < mat[row].length; col++) {
            minDiff = Math.min(minDiff, getMinDifference(mat, row + 1, sum + mat[row][col], target, dp));
        }

        dp[row][sum] = minDiff;

        return minDiff;
    }
}
