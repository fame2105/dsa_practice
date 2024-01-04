package dsa.catalogueOrder.levelUp.dynamicProgramming.MatrixChainMultiplication;

public class MatrixChainMultiplication {
    private int lowestCostMultiplication(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n-1][n-1];

        for(int g = 0; g < dp.length; g++) {
            for(int i =0, j = g; j < dp[0].length; i++,j++) {
                if(g == 0) {
                    dp[i][j] = 0;
                } else if(g == 1){
                    dp[i][j] = arr[i] * arr[j] * arr[j+1];
                } else {
                    int minCost = Integer.MAX_VALUE;
                    for(int k = i; k < j; k++) {
                        int leftCost = dp[i][k];
                        int rightCost = dp[k+1][j];
                        int multiplicationCost = arr[i] * arr[k+1] * arr[j+1];
                        minCost = Math.min(minCost, leftCost + rightCost + multiplicationCost);
                    }
                    dp[i][j] = minCost;
                }
            }
        }
        return dp[0][dp.length - 1];
    }
}
