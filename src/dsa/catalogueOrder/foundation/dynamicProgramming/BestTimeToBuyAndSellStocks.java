package dsa.catalogueOrder.foundation.dynamicProgramming;

public class BestTimeToBuyAndSellStocks {
    public static void main(String[] args) {
        int[] prices = new int[]{10, 15, 17, 20, 16, 18, 22, 20, 22, 20, 23, 25};
        int profit = bestTimeToBuyAndSellStockInfiniteTransactionsWithCooldown(prices);
        System.out.println(profit);
    }

    private static int bestTimeToBuyAndSellStockSingleTransaction(int[] prices) {
        int overallProfit = 0;

        int profitIfSoldToday = 0;
        int leastBuyingDay = (int) 1e9; // integer max

        for (int i = 0; i < prices.length; i++) {

            if (prices[i] < leastBuyingDay) { // update and maintain the least buying price
                leastBuyingDay = prices[i];
            }

            // check everyday profit if sold at this day
            profitIfSoldToday = prices[i] - leastBuyingDay;

            if (overallProfit < profitIfSoldToday) {
                overallProfit = profitIfSoldToday;
            }
        }
        return overallProfit;
    }

    private static int bestTimeToBuyAndSellStockInfiniteTransactions(int[] prices) {
        int buyingDay = 0;
        int sellingDay = 0;
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= prices[i - 1]) {
                sellingDay++; // keep pushing the selling day forward because we are on an up-stroke of prices
            } else {
                // collect profit
                profit += prices[sellingDay - buyingDay];

                // update the buying and selling day to this(ith) day... since we are on a down-stroke of prices
                buyingDay = sellingDay = i;
            }
        }

        //since we are collecting profits only when experiencing dips in prices,
        // hence we won't be able to collect profit in case there was an increase/upstrokes in prices during the last day
        // collect the profits of the last sell and buy day separately.
        profit += prices[sellingDay - buyingDay];

        return profit;
    }

    private static int bestTimeToBuyAndSellStockInfiniteTransactionsWithFee(int[] prices, int transactionFee) {
        int buyStateCost = prices[0]; // we need to minimize the buy state cost
        int sellStateProfit = 0;// initially sell state profits = 0, because we can't/won't sell the stock the same day

        for (int i = 1; i < prices.length; i++) {
            int newBuyStateCost = 0; // we need to check and update the buyStateCost for everyday price in order to minimize the cost while buying stocks
            int newSellStateProfit = 0; // we need to check and update the sellStateProfit for everyday price in order to maximize the profit while buying stocks

            if (prices[i] - sellStateProfit < buyStateCost) { // update now.. we have a better buy state
                newBuyStateCost = prices[i] - sellStateProfit;
            } else {
                newBuyStateCost = buyStateCost; // we are retaining the stock bought on some previous day, since buying at today's(ith) price is costing us more than some earlier day stock value
            }

            if (prices[i] - buyStateCost - transactionFee > sellStateProfit) {
                newSellStateProfit = prices[i] - buyStateCost - transactionFee;
            } else {
                newSellStateProfit = sellStateProfit; // we are not selling the stock today at ith price since selling at today's(ith) price is providing us higher profit than selling it at some earlier day stock value.
            }

            buyStateCost = newBuyStateCost;
            sellStateProfit = newSellStateProfit;
        }

        return sellStateProfit;
    }

    private static int bestTimeToBuyAndSellStockInfiniteTransactionsWithCooldown(int[] prices) {
        int buyStateCost = prices[0]; // we need to minimize the buy state cost
        int sellStateProfit = 0; // initially sell state profits = 0, because we can't/won't sell the stock the same day
        int cooldownStateProfit = 0; // initially cool down state profits = 0

        for (int i = 1; i < prices.length; i++) {
            int newBuyStateCost = 0; // we need to check and update the buyStateCost for everyday price in order to minimize the cost while buying stocks
            int newSellStateProfit = 0; // we need to check and update the sellStateProfit for everyday price in order to maximize the profit while buying stocks
            int newCoolDownStateProfit = 0;

            // Check and update buy cost for ith day's price
            if (prices[i] - cooldownStateProfit < buyStateCost) { // update now.. we have a better buy state
                newBuyStateCost = prices[i] - cooldownStateProfit;
            } else {
                newBuyStateCost = buyStateCost; // we are retaining the stock bought on some previous day, since buying at today's(ith) price is costing us more than some earlier day stock value
            }

            // Check and update sell state profit for ith day's price
            if (prices[i] - buyStateCost > sellStateProfit) {
                newSellStateProfit = prices[i] - buyStateCost;
            } else {
                newSellStateProfit = sellStateProfit; // we are not selling the stock today at ith price since selling at today's(ith) price is providing us higher profit than selling it at some earlier day stock value.
            }

            // Check and update cooldown state profit for ith day's price
            if (sellStateProfit > cooldownStateProfit) {
                newCoolDownStateProfit = sellStateProfit;
            } else {
                newCoolDownStateProfit = cooldownStateProfit;
            }

            buyStateCost = newBuyStateCost;
            sellStateProfit = newSellStateProfit;
            cooldownStateProfit = newCoolDownStateProfit;

        }

        return sellStateProfit;
    }

    private static int bestTimeToBuyAndSellStockTwoTransactions(int[] prices) {
        return 0;
    }
}
