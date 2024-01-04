package dsa.catalogueOrder.foundation.dynamicProgramming;

import java.util.Scanner;

public class _11_UnboundedKnapsack {
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
        System.out.println(unboundedKnapsack(weights, values, maxAllowedWeight));
    }

    private static int unboundedKnapsack(int[] weights, int[] values, int maxAllowedWeight) {
        int[] dp = new int[maxAllowedWeight + 1];
        dp[0] = 0;

        for (int i = 0; i < weights.length; i++) {
            int currentWeight = weights[i];
            int currentValue = values[i];

            for (int j = 1; j < dp.length; j++) {
                int currentAllowedWeight = j;
                if (currentWeight > currentAllowedWeight) {
                    continue;
                } else {
                    dp[j] = Math.max(dp[j], currentValue + dp[currentAllowedWeight - currentWeight]);
                }
            }
        }
        return dp[maxAllowedWeight];
    }
}
