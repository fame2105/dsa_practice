package dsa.catalogueOrder.levelUp.dynamicProgramming.catalanNumbers;

public class FindNthCatalanNumber {
    public int nthCatalanNumber(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i < n+1; i++) {
            int ithCatalan = 0;
            for(int j = 0; j < i; j++) {
                ithCatalan += dp[j] * dp[i-j-1];
            }
            dp[i] = ithCatalan;
        }

        return dp[n];
    }
}
