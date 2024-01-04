package dsa.catalogueOrder.foundation.dynamicProgramming;

import java.util.Scanner;

public class _09CoinChangePermutation {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        // int n = s.nextInt();
        // int[] coins = new int[n];

        // input coins array
        /*for (int i = 0; i < n; i++) {
            coins[i] = s.nextInt();
        }*/

        int target = 7;
        int coins[] = new int[]{2, 3, 5, 6};

//        System.out.println(coinChangePermutationRecursive(coins, target));

//        int[] dp = new int[target + 1];
//        System.out.println(coinChangePermutationMemoization(coins, target, dp));

        int[] dp = new int[target + 1];
        System.out.println(coinChangePermutationTabulation(coins, target, dp));
    }

    private static int coinChangePermutationRecursive(int[] coins, int target) {
        if (target == 0) {
            return 1;
        }

        int count = 0;
        for (int coin : coins) {
            if (target - coin >= 0) {
                count += coinChangePermutationRecursive(coins, target - coin);
            }
        }
        return count;
    }

    private static int coinChangePermutationMemoization(int[] coins, int target, int[] dp) {
        if (target == 0) {
            return dp[target] = 1;
        }

        if (dp[target] != 0) return dp[target];

        int count = 0;
        for (int coin : coins) {
            if (target - coin >= 0) {
                count += coinChangePermutationMemoization(coins, target - coin, dp);
            }
        }
        return dp[target] = count;
    }

    private static int coinChangePermutationTabulation(int[] coins, int target, int[] dp) {
        dp[0] = 1; // base case
        for (int i = 1; i <= target; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) dp[i] += dp[i - coin];
            }
        }

        return dp[target];
    }
}
