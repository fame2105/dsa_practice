package dsa.catalogueOrder.levelUp.dynamicProgramming;

public class ClimbStairsWithMinMoves {

    public static int climbStairsWithMinMoves(int[] steps) {
        int n = steps.length;
        Integer[] dp = new Integer[n];
        dp[n-1] = 0;
        for(int i = n-2; i >= 0; i--) {
            int stepSize = steps[i];
            int minMoves = Integer.MAX_VALUE;

            for(int j = 1; j <= stepSize && i+j < n; j++) {
                if(dp[i+j] != null)
                    minMoves = Math.min(minMoves, dp[i+j]);
            }

            if(minMoves != Integer.MAX_VALUE) {
                dp[i] = minMoves + 1;
            }
        }
        return dp[0];
    }
}
