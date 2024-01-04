package dsa.catalogueOrder.levelUp.dynamicProgramming.buyAndSellStocks;

public class _1_OneTransactionAllowed {

    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++) {
            buy = Math.min(buy, prices[i]);

            int profit = prices[i] - buy;
            maxProfit = Math.max(maxProfit, profit);
        }
        return maxProfit;
    }
}
