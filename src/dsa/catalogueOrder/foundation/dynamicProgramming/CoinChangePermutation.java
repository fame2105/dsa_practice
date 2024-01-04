package dsa.catalogueOrder.foundation.dynamicProgramming;

import java.util.Scanner;

public class CoinChangePermutation {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = s.nextInt();
        }

        int targetSum = s.nextInt();
        System.out.println(printCoinChangePermutationDP(coins, targetSum));

        System.out.println(printCoinChangePermutationRecursive(coins, targetSum));
    }

    private static int printCoinChangePermutationRecursive(int[] coins, int targetSum) {

        if(targetSum == 0) {
            return 1;
        } else if(targetSum < 0) {
            return 0;
        }

        int currentCoinContribution = 0;
        for (int i = 0; i < coins.length; i++) {
            int currentCoin = coins[i];
            currentCoinContribution += printCoinChangePermutationRecursive(coins, targetSum - currentCoin);
        }

        return currentCoinContribution;
    }

    private static int printCoinChangePermutationDP(int[] coins, int targetSum) {
        int[] dp = new int[targetSum + 1];
        dp[0] = 1;
        for (int i = 0; i < dp.length; i++) {
            int amount = i; // using variable for more clarity instead of i and j
            for (int j = 0; j < coins.length; j++) {
                int currentCoin = coins[j];

                if (currentCoin > amount) {
                    continue;
                }

                dp[amount] = dp[amount] + dp[amount - currentCoin];
            }
        }
        return dp[targetSum];
    }
}
