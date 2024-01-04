package dsa.catalogueOrder.levelUp.dynamicProgramming;

// leet 221 : https://leetcode.com/problems/maximal-square/
public class MaximalSquare {
    public int maximalSquare(char[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;

        int[][] dp = new int[r][c];
        int ans = 0;
        int min = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] - '0';
                    if (dp[i][j] == 1)
                        min = 1;
                } else {
                    if (matrix[i][j] == '0') {
                        dp[i][j] = 0;
                    } else {
                        int left = dp[i][j - 1];
                        int top = dp[i - 1][j];
                        int diagonal = dp[i - 1][j - 1];
                        dp[i][j] = 1 + Math.min(left, Math.min(top, diagonal));

                        ans = Math.max(ans, dp[i][j]);
                    }
                }
            }
        }

        return ans == 0 ? min * min : ans * ans;

    }
}
