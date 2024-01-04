package dsa.random.dynamic_programming;

// Unbounded Knapsack differs from 0/1 knapsack in a way that we have endless supply (Repetition allowed) of each item
// hence they could be chosen again and again at multiple levels
public class UnboundedKnapsack {
    public static void main(String[] args) {
        int noOfElements = 3;
        int[] wt = new int[]{3, 1, 2};
        int[] values = new int[]{7, 3, 6};
        int bagCapacity = 5;

        int maxProfit = 0;
        maxProfit = unBoundedKnapsackRecursive(wt, values, noOfElements - 1, bagCapacity);
        System.out.println(maxProfit);

        Integer[][] dp1 = new Integer[noOfElements+1][bagCapacity+1];
        maxProfit = unBoundedKnapsackRecursiveMemoized(wt, values, noOfElements - 1, bagCapacity, dp1);
        System.out.println(maxProfit);

        int[][] dp2 = new int[noOfElements+1][bagCapacity+1];
        maxProfit = unBoundedKnapsackTabulation(wt, values, bagCapacity, dp2);
        System.out.println(maxProfit);
    }

    private static int unBoundedKnapsackRecursive(int[] wt, int[] value, int idx, int bagCapacity) {
        if (bagCapacity == 0 || idx == -1) {
            return 0;
        }

        int maxProfit = 0;
        if (wt[idx] <= bagCapacity) {
            maxProfit = value[idx] + unBoundedKnapsackRecursive(wt, value, idx, bagCapacity - wt[idx]); // yes call
        }
        return Math.max(maxProfit, unBoundedKnapsackRecursive(wt, value, idx - 1, bagCapacity));
    }

    private static int unBoundedKnapsackRecursiveMemoized(int[] wt, int[] value, int idx, int bagCapacity, Integer[][] dp) {
        if (bagCapacity == 0 || idx == -1) {
            return dp[idx + 1][bagCapacity] = 0;
        }

        if(dp[idx+1][bagCapacity] != null) return dp[idx+1][bagCapacity];

        int maxProfit = 0;
        if (wt[idx] <= bagCapacity) {
            maxProfit = value[idx] + unBoundedKnapsackRecursiveMemoized(wt, value, idx, bagCapacity - wt[idx], dp); // yes call
            dp[idx + 1][bagCapacity] = maxProfit;
        }
        return dp[idx + 1][bagCapacity] = Math.max(maxProfit, unBoundedKnapsackRecursiveMemoized(wt, value, idx - 1, bagCapacity, dp));
    }

    private static int unBoundedKnapsackTabulation(int[] wt, int[] value, int bagCapacity, int[][] dp) {
        // i -> wt, value  j -> bagCapacity
        for (int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[i].length; j++) {
                if(i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if(j >= wt[i-1]) {
                    dp[i][j] = Math.max(value[i-1] + dp[i][j-wt[i-1]], dp[i-1][j]);
                } else {
                    dp[i][j] = dp[i-1][j];
                }

            }
        }

        return dp[wt.length][bagCapacity];
    }
}
