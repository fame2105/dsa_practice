package dsa.catalogueOrder.levelUp.dynamicProgramming;

public class RodCuttingProblem {
    public static int rodCuttingProblem(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n + 1];
        dp[1] = prices[0];

        for(int i = 2; i < dp.length; i++) {
            int maxPrice = prices[i-1];

            for(int j = 1; j <= i/2; j++) {
                int price = dp[j] + dp[i-j];
                maxPrice = Math.max(maxPrice, price);
            }
            dp[i] = maxPrice;
        }

        return dp[n];
    }
}
