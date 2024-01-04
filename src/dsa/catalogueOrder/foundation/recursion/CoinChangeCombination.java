package dsa.catalogueOrder.foundation.recursion;

public class CoinChangeCombination {
    public static void main(String[] args) {
        int target = 6;
        int[] coins = new int[]{2, 3, 1, 5};


        int waysRepetitionNotAllowed = coinChangeCombinationRecursiveNORepetitionsAllowed_CountWays(target, 0, coins);
        System.out.println("No of Combinations to pay target :" + target + ", when repetition is not allowed = " + waysRepetitionNotAllowed);

        int[][] dp1 = new int[coins.length + 1][target + 1];
        int waysRepetitionNotAllowedMemoized = coinChangeCombinationRecursiveNORepetitionsAllowed_CountWaysMemoized(target, 0, coins, dp1);
        System.out.println("No of Combinations to pay target :" + target + ", when repetition is not allowed(using memoized method) = " + waysRepetitionNotAllowedMemoized);

        System.out.println("Combinations to pay target : " + target + " with given denominations, when repetition is not allowed");
        coinChangeCombinationRecursiveNORepetitionsAllowed_printCombinations(target, 0, coins, "");

        System.out.println("-------------------------------------------------------------------------------------- ");

        int waysRepetitionAllowed = coinChangeCombinationRecursiveRepetitionAllowed_CountWays(target, 0, coins);
        System.out.println("No of Combinations to pay target : " + target + ", when repetition is allowed = " + waysRepetitionAllowed);

        int[][] dp2 = new int[coins.length+1][target + 1];
        int waysRepetitionAllowedMemoized = coinChangeCombinationRecursiveRepetitionAllowed_CountWaysMemoized(target, 0, coins, dp2);
        System.out.println("No of Combinations to pay target : " + target + ", when repetition is allowed(Memoized Approach) = " + waysRepetitionAllowedMemoized);

        int[] dp3 = new int[target + 1];
        int waysRepetitionAllowedTabulation = coinChangeCombinationRecursiveRepetitionAllowed_CountWaysTabulation(target, coins, dp3);
        System.out.println("No of Combinations to pay target : " + target + ", when repetition is allowed(Tabulation Approach) = " + waysRepetitionAllowed);

        System.out.println("Combinations to pay target : " + target + " with given denominations, when repetition allowed");
        coinChangeCombinationRecursiveRepetitionAllowed_printCombinations(target, 0, coins, "");
    }

    /**
     * NOTE: Any of the coins can be used only once -> there is NO infinite supply of coins
     *
     * @param target -> target to be made with the given coins
     * @param index  -> currently we are processing the coin at this index in coins[]
     * @param coins  -> array denomination of coins available.
     * @return -> no of combinations to pay target value when provided with given coins denomination.
     */
    private static int coinChangeCombinationRecursiveNORepetitionsAllowed_CountWays(int target, int index, int[] coins) {
        if (index == coins.length) {
            if (target == 0) return 1;
            else return 0;
        }

        int count = 0;
        if (target - coins[index] >= 0) {
            count += coinChangeCombinationRecursiveNORepetitionsAllowed_CountWays(target - coins[index], index + 1, coins);
        }

        count += coinChangeCombinationRecursiveNORepetitionsAllowed_CountWays(target, index + 1, coins);
        return count;
    }

    /**
     * NOTE: Any of the coins can be used only once -> there is NO infinite supply of coins
     *
     * @param target -> target to be made with the given coins
     * @param index  -> currently we are processing the coin at this index in coins[]
     * @param coins  -> array denomination of coins available.
     * @param dp     -> array of (coins.length X target + 1) dimensions to store the repetitive call answers
     * @return -> no of combinations to pay target value when provided with given coins denomination.
     * Applying bottom up DP -> Memoization
     */
    private static int coinChangeCombinationRecursiveNORepetitionsAllowed_CountWaysMemoized(int target, int index, int[] coins, int[][] dp) {
        if (index == coins.length) {
            if (target == 0) return dp[index][target] = 1;
            else return dp[index][target] = 0;
        }

        if (dp[index][target] != 0) return dp[index][target];

        int count = 0;
        if (target - coins[index] >= 0) {
            count += coinChangeCombinationRecursiveNORepetitionsAllowed_CountWays(target - coins[index], index + 1, coins);
        }

        count += coinChangeCombinationRecursiveNORepetitionsAllowed_CountWays(target, index + 1, coins);
        return dp[index][target] = count;
    }

    /**
     * NOTE: Any of the coins can be used only once -> there is NO infinite supply of coins
     *
     * @param target -> target to be made with the given coins
     * @param coins  -> array denomination of coins available.
     * @param dp     -> array of (coins.length X target + 1) dimensions to store the repetitive call answers
     * @return -> no of combinations to pay target value when provided with given coins denomination.
     * Applying bottom up DP -> Memoization
     */
    private static int coinChangeCombinationRecursiveNORepetitionsAllowed_CountWaysTabulation(int target, int[] coins, int[] dp) {
        return 0;
    }

    /**
     * NOTE: Any of the coins can be used only once -> there is NO infinite supply of coins
     *
     * @param target -> target to be made with the given coins
     * @param index  -> currently we are processing the coin at this index in coins[]
     * @param coins  -> array denomination of coins.
     * @param psf    -> path so far
     * @return -> void
     * prints the combinations to pay target value with given number of coin denominations
     */
    private static void coinChangeCombinationRecursiveNORepetitionsAllowed_printCombinations(int target, int index, int[] coins, String psf) {
        if (index == coins.length) {
            if (target == 0) {
                System.out.println(psf);
            }
            return;
        }

        if (target - coins[index] >= 0) {
            coinChangeCombinationRecursiveNORepetitionsAllowed_printCombinations(target - coins[index], index + 1, coins, psf + coins[index] + " ");
        }

        coinChangeCombinationRecursiveNORepetitionsAllowed_printCombinations(target, index + 1, coins, psf);
    }


    /**
     * NOTE: Any of the coins could be used infinite number of times to form the target -> there is infinite supply of each denomination
     *
     * @param target -> target to be made with the given coins
     * @param index  -> currently we are processing the coin at this index in coins[]
     * @param coins  -> array denomination of coins.
     * @return -> no of combinations to pay target value when provided with given coins denomination.
     */
    private static int coinChangeCombinationRecursiveRepetitionAllowed_CountWays(int target, int index, int[] coins) {
        if (index == coins.length) {
            if (target == 0) return 1;
            else return 0;
        }

        int count = 0;
        if (target - coins[index] >= 0) {
            count += coinChangeCombinationRecursiveRepetitionAllowed_CountWays(target - coins[index], index, coins);
        }

        count += coinChangeCombinationRecursiveRepetitionAllowed_CountWays(target, index + 1, coins);
        return count;
    }

    /**
     * NOTE: Any of the coins could be used infinite number of times to form the target -> there is infinite supply of each denomination
     * @param target -> target to be made with the given coins
     * @param index  -> currently we are processing the coin at this index in coins[]
     * @param coins  -> array denomination of coins available.
     * @param dp     -> array of (coins.length X target + 1) dimensions to store the repetitive call answers
     * @return -> no of combinations to pay target value when provided with given coins denomination.
     * Applying bottom up DP approach -> Memoization
     */
    private static int coinChangeCombinationRecursiveRepetitionAllowed_CountWaysMemoized(int target, int index, int[] coins, int[][] dp) {
        if (index == coins.length) {
            if (target == 0) return dp[index][target] = 1;
            else return dp[index][target] = 0;
        }

        if (dp[index][target] != 0) return dp[index][target];

        int count = 0;
        if (target - coins[index] >= 0) {
            count += coinChangeCombinationRecursiveRepetitionAllowed_CountWaysMemoized(target - coins[index], index, coins, dp);
        }

        count += coinChangeCombinationRecursiveRepetitionAllowed_CountWaysMemoized(target, index + 1, coins, dp);
        return dp[index][target] = count;
    }

    /**
     * NOTE: Any of the coins could be used infinite number of times to form the target -> there is infinite supply of each denomination
     *
     * @param target -> target to be made with the given coins
     * @param coins  -> array denomination of coins available.
     * @param dp     -> array of (target + 1) length
     * @return -> no of combinations to pay target value when provided with given coins denomination.
     * Applying top down DP approach -> Tabulation
     */
    private static int coinChangeCombinationRecursiveRepetitionAllowed_CountWaysTabulation(int target, int[] coins, int[] dp) {
        dp[0] = 1;
        for (int coin : coins) {
            if (target - coin >= 0) {
                for (int i = coin; i <= target; i++) {
                    dp[i] += dp[i - coin];
                }
            }
        }
        return dp[target];
    }

    /**
     * NOTE: Any of the coins could be used infinite number of times to form the target -> there is infinite supply of each denomination
     *
     * @param target -> target to be made with the given coins
     * @param index  -> currently we are processing the coin at this index in coins[]
     * @param coins  -> array denomination of coins.
     * @param psf    -> path so far
     * @return -> void
     * prints the combinations to pay target value with given number of coin denominations
     */
    private static void coinChangeCombinationRecursiveRepetitionAllowed_printCombinations(int target, int index, int[] coins, String psf) {
        if (index == coins.length) {
            if (target == 0) {
                System.out.println(psf);
            }
            return;
        }

        if (target - coins[index] >= 0) {
            coinChangeCombinationRecursiveRepetitionAllowed_printCombinations(target - coins[index], index, coins, psf + coins[index] + " ");
        }

        coinChangeCombinationRecursiveRepetitionAllowed_printCombinations(target, index + 1, coins, psf);
    }
}
