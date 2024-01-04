package dsa.catalogueOrder.levelUp.dynamicProgramming.MatrixChainMultiplication;

public class BurstBaloons {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {3,1,5,8}));
    }
    public static int solution(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];

        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g; j < n; i++, j++) {
                int max = Integer.MIN_VALUE;
                for (int k = i; k <= j; k++) {
                    int left = k == i ? 0 : dp[i][k - 1];
                    int right = k == j ? 0 : dp[k + 1][j];
                    int val = (i == 0 ? 1 : arr[i - 1]) * arr[k] * (j == n - 1 ? 1 : arr[j + 1]);
                    int totalVal = left + right + val;
                    max = Math.max(max, totalVal);
                }
                dp[i][j] = max;
            }
        }

        return dp[0][n - 1];
    }

}
//hennington client
