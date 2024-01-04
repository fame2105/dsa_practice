package dsa.catalogueOrder.levelUp.dynamicProgramming.buyAndSellStocks;

public class _2_InfiniteTransactionsAllowed {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
    public static int maxProfit(int[] prices) {
        int buyDay = 0;
        int sellDay = 0;
        int profit = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] >= prices[i-1]) {
                sellDay = i;
            } if(prices[i] < prices[i-1]) {
                profit += prices[sellDay] - prices[buyDay];
                buyDay = i;
                sellDay = i;
            }
        }
        profit += prices[sellDay] - prices[buyDay];
        return profit;
    }
}
