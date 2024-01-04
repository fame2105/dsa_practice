package dsa.catalogueOrder.levelUp.dynamicProgramming;

public class __01_LargestSquareSubMatrix {

    public int maximalSquare(char[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;

        /*
        // each cell in DP denotes the
        largest square possible when constructed assuming it is the bottom right corner of the square.
         */
        int[][] dp = new int[r][c];
        int ans = 0;
        int min = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = matrix[i][j] - '0';
                    if (dp[i][j] == 1)
                        min = 1; // min variable is important so that if matrix contains all zeros, we could manage that case.
                }  else {
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
