package dsa.catalogueOrder.foundation.recursion.printRecursion;

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
