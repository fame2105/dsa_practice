package dsa.catalogueOrder.foundation.dynamicProgramming;

import java.util.Scanner;

// Exactly Same as TargetSum Subset
public class _10_Knapsack_01 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int[] weights = new int[n];
        int[] values = new int[n];

        for (int i = 0; i < n; i++) {
            values[i] = s.nextInt();
        }

        for (int i = 0; i < n; i++) {
            weights[i] = s.nextInt();
        }

        int maxAllowedWeight = s.nextInt();

        System.out.println(getMaxValueWithinMaxAllowedWeight(weights, values, maxAllowedWeight));
    }

    private static int getMaxValueWithinMaxAllowedWeight(int[] weights, int[] values, int maxAllowedWeight) {
        int[][] dp = new int[weights.length + 1][maxAllowedWeight + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                int currentAllowedWeight = j; // using variable for better clarity and code readability
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    int currentWeight = weights[i-1];
                    int currentValue = values[i-1];
                    if(currentWeight > currentAllowedWeight) {
                        dp[i][j] = dp[i-1][j];
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j], currentValue + dp[i-1][currentAllowedWeight - currentWeight]);
                    }
                }
            }
        }
        return dp[weights.length][maxAllowedWeight];
    }
}
