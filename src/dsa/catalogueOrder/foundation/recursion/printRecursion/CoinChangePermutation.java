package dsa.catalogueOrder.foundation.recursion.printRecursion;

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
}
