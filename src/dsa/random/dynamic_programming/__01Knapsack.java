package dsa.random.dynamic_programming;

public class __01Knapsack {
    public static void main(String[] args) {
        int noOfElements = 3;
        int[] wt = new int[]{3, 1, 2};
        int[] value = new int[]{7, 3, 6};
        int bagCapacity = 5;
        System.out.println(zeroOneKnapsack(wt, value, bagCapacity, noOfElements - 1));

        Integer[][] dp1 = new Integer[noOfElements + 1][bagCapacity + 1];
        System.out.println(zeroOneKnapsackMemoized(wt, value, bagCapacity, noOfElements - 1, dp1));

        int[][] dp2 = new int[noOfElements + 1][bagCapacity + 1];
        System.out.println(zeroOneKnapsackTabulation(wt, value, dp2));
    }

    // W -> bag capacity
    private static int zeroOneKnapsack(int[] wt, int[] value, int W, int idx) {
        if (W == 0 || idx == -1) {
            return 0;
        }

        int maxVal = 0;
        if (W - wt[idx] >= 0) {
            maxVal = value[idx] + zeroOneKnapsack(wt, value, W - wt[idx], idx - 1);
        }

        return Math.max(maxVal, zeroOneKnapsack(wt, value, W, idx - 1));
    }

    private static int zeroOneKnapsackMemoized(int[] wt, int[] value, int W, int idx, Integer[][] dp) {
        if (W == 0 || idx == -1) {
            return dp[idx + 1][W] = 0;
        }

        if (dp[idx + 1][W] != null) return dp[idx + 1][W];

        int maxVal = 0;
        if (W - wt[idx] >= 0) {
            maxVal = value[idx] + zeroOneKnapsackMemoized(wt, value, W - wt[idx], idx - 1, dp);
        }

        return dp[idx + 1][W] = Math.max(maxVal, zeroOneKnapsackMemoized(wt, value, W, idx - 1, dp));
    }

    private static int zeroOneKnapsackTabulation(int[] wt, int[] value, int[][] dp) {
        // initialization
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                if (i == 0 || j == 0) { // Initialization .. same as base condition in recursive function
                    dp[i][j] = 0;
                    continue;
                }

                if (j >= wt[i-1]) {
                    dp[i][j] = Math.max(dp[i-1][j - wt[i-1]] + value[i-1], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[wt.length][dp[0].length-1];
    }
}
