package dsa.catalogueOrder.foundation.dynamicProgramming;

import java.util.Scanner;

public class _05_MinCostPathInMaze {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int row = s.nextInt();
        int column = s.nextInt();

        int[][] cost = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                cost[i][j] = s.nextInt();
            }
        }

        System.out.println(getMinCostPathInMaze(cost));
    }

    private static int getMinCostPathInMaze(int[][] cost) {
        int[][] dp = new int[cost.length][cost[0].length];

        for (int i = dp.length - 1; i >= 0; i--) {
            for (int j = dp[0].length - 1; j >= 0; j--) {
                if (i == dp.length - 1 && j == dp[0].length - 1) {
                    dp[i][j] = cost[i][j];
                } else if (i == dp.length - 1) {
                    dp[i][j] = cost[i][j] + dp[i][j + 1];
                } else if (j == dp[0].length - 1) {
                    dp[i][j] = cost[i][j] + dp[i + 1][j];
                } else {
                    dp[i][j] = cost[i][j] + Math.min(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }

        return dp[0][0];
    }
}
