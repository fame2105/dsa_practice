package dsa.catalogueOrder.levelUp.dynamicProgramming;

// leetcode 1986 : https://leetcode.com/problems/minimum-falling-path-sum/
public class MinFallingPathSum_I {
    public int minFallingPathSum(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;

        int[][] dp = new int[rows][cols];

        for(int i = rows-1; i>=0; i--) {
            for(int j = 0; j < cols; j++) {
                if(i == rows-1) {
                    dp[i][j] = matrix[i][j];
                } else {
                    int prevVal = matrix[i][j];

                    int costLeft = (j-1 >= 0) ? dp[i+1][j-1] : Integer.MAX_VALUE;

                    int costCenter = dp[i+1][j];

                    int costRight = (j+1 < cols) ? dp[i+1][j+1] : Integer.MAX_VALUE;


                    dp[i][j] = prevVal + Math.min(costLeft, Math.min(costCenter, costRight));
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int j = 0; j < cols; j++) {
            min = Math.min(min, dp[0][j]);
        }

        return min;
    }
}
