package dsa.catalogueOrder.foundation.dynamicProgramming;

import java.util.Scanner;

public class DescentStairWithVariableDrops {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int[] weight = new int[n];

        for (int i = 0; i < n; i++) {
            weight[i] = s.nextInt();
        }

        int[] dp = new int[n+1];

        System.out.println(descentStairWithVariableDrops(n, weight, dp));
    }

    private static int descentStairWithVariableDrops(int n, int[] weight, int[] dp) {
        dp[n] = 1;

        for (int i = n-1; i >= 0 ; i--) {
            for (int j = 1; j <= weight[i] && i+j < dp.length ; j++) {
                dp[i] += dp[i+j];
            }
        }

        return dp[0];
    }
}
