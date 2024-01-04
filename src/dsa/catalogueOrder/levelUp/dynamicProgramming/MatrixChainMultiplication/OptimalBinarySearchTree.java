package dsa.catalogueOrder.levelUp.dynamicProgramming.MatrixChainMultiplication;

public class OptimalBinarySearchTree {

    private static int optimalBST(int[] keys, int[] frequency, int n) {
        int[][] dp = new int[n][n];

        for(int g = 0; g < n; g++) {
            for(int i = 0, j = g; j < n; i++, j++) {
                if(g == 0) {
                    dp[i][j] = frequency[i];
                } else if(g == 1) {
                    int val1 = frequency[i] + 2* frequency[j];
                    int val2 = 2 * frequency[i] + frequency[j];
                    dp[i][j] = Math.min(val1, val2);
                } else {
                    int balancingFactor = 0;
                    int min = Integer.MAX_VALUE;
                    for(int k = i; k <=j; k++) {
                        int left = i == k ? 0 : dp[i][k-1];
                        int right = k == j ? 0 : dp[k+1][j];
                        balancingFactor += frequency[k];
                        min = Math.min(min, left + right);
                    }
                    dp[i][j] = min + balancingFactor;
                }
            }
        }
        return dp[0][n-1];
    }
}
