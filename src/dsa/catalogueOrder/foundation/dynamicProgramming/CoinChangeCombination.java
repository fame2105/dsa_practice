package dsa.catalogueOrder.foundation.dynamicProgramming;

import java.util.Scanner;

public class CoinChangeCombination {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = s.nextInt();
        }

        int targetSum = s.nextInt();

        printCoinChangeCombinationRecursive(coins, 0, 0, targetSum, "");

        int[] dp = new int[targetSum + 1];
        printCoinChangeCombinationDP(coins, dp, targetSum);
    }

    private static void printCoinChangeCombinationDP(int[] coins, int[] dp, int targetSum) {
        dp[0] = 1;

        // for generating combinations each coin should be iterated through entire DP array one at a time through,
        // otherwise we would generate permutations instead of combinations

        // array for coins
        for (int i = 0; i < coins.length; i++) {
            // iterating on dp array one coin at a time.
            for (int j = coins[i]; j <dp.length ; j++) {
                int currentCoin = coins[i];
                int amount = j;
                // using amount and currentCoin variable for clarity purpose.
                dp[amount] = dp[amount] + dp[amount - currentCoin];
            }
        }
        System.out.println(dp[targetSum]);
    }

    private static void printCoinChangeCombinationRecursive(int[] coins, int index, int sumSoFar, int targetSum, String result) {

        if (index == coins.length) {
            if (targetSum == 0) {
                System.out.print(result + "\t");
            }
            return;
        }

        if (targetSum < 0) {
            return;
        }

        printCoinChangeCombinationRecursive(coins, index, sumSoFar + coins[index], targetSum - coins[index], result + coins[index] + " ");
        printCoinChangeCombinationRecursive(coins, index + 1, sumSoFar, targetSum, result);
    }
}
