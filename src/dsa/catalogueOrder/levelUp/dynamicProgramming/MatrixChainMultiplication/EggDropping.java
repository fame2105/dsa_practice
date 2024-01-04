package dsa.catalogueOrder.levelUp.dynamicProgramming.MatrixChainMultiplication;

public class EggDropping {
    public int superEggDrop(int k, int n) {
        Integer[][] dp = new Integer[k+1][n+1];
        int minAttempts =  solve(k, n, dp);
        return minAttempts;
    }

    private int solve(int e, int n, Integer[][] dp) {
        if(n == 0 || n == 1) return n;
        if(e == 0) return 0;
        if(e == 1) return n;

        if(dp[e][n] != null) return dp[e][n];

        int min = Integer.MAX_VALUE;
        for(int k = 2; k <= n; k++) {

            int eggBreaks = 0;
            if(dp[e-1][k-1] != null) {
                eggBreaks = dp[e-1][k-1];
            } else {
                eggBreaks = solve(e-1, k-1, dp);
                dp[e-1][k-1] = eggBreaks;
            }

            int eggNotBreak = 0;
            if(dp[e][n-k] != null) {
                eggNotBreak = dp[e][n-k];
            } else {
                eggNotBreak = solve(e, n-k, dp);
                dp[e][n-k] = eggNotBreak;
            }

            int attempt = 1 + Math.max(eggBreaks, eggNotBreak);
            min = Math.min(min, attempt);
        }
        dp[e][n] = min;
        return dp[e][n];
    }
}
