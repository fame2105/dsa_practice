package dsa.catalogueOrder.levelUp.dynamicProgramming.buyAndSellStocks;

public class _5_TwoTransactionsAllowed {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp1 = new int[n];
        dp1[0] = 0;
        int buy = prices[0];

        for(int i = 1; i < n; i++) {
            buy = Math.min(buy, prices[i]);
            int profitIfSoldToday = prices[i] - buy;
            dp1[i] = Math.max(profitIfSoldToday, dp1[i-1]);
        }

        int[] dp2 = new int[n];
        int sell = prices[n - 1];
        dp2[n - 1] = 0;
        for(int i = n - 2; i >= 0; i--) {
            sell = Math.max(sell, prices[i]);
            int profitIfBoughtToday = sell - prices[i];
            dp2[i] = Math.max(profitIfBoughtToday, dp2[i+1]);
        }

        int maxProfit = 0;
        for(int i = 0; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, dp1[i] + dp2[i]);
        }
        return maxProfit;
    }
}
