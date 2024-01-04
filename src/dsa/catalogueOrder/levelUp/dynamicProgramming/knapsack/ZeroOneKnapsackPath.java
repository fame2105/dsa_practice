package dsa.catalogueOrder.levelUp.dynamicProgramming.knapsack;

import java.util.ArrayDeque;
import java.util.Queue;

public class ZeroOneKnapsackPath {

    private static class Pair {
        int i;
        int j;
        String path;

        public Pair(int i, int j, String path) {
            this.i = i;
            this.j = j;
            this.path = path;
        }
    }

    private void printMaxValuePaths(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        int[][] dp = new int[n + 1][capacity + 1];

        for (int i = 1; i < n + 1; i++) { // wt and value on rows
            for (int j = 1; j < capacity + 1; j++) { // allowedCapacitie on columns
                int currWt = weights[i - 1];
                int currVal = values[i - 1];
                int allowedCapacity = j;

                if (currWt > allowedCapacity) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    int maxVal = Math.max(currVal + dp[i - 1][allowedCapacity - currWt], dp[i - 1][j]);
                    dp[i][j] = maxVal;
                }
            }
        }

        System.out.println(dp[n][capacity]);

        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(n, capacity, ""));

        while (q.size() > 0) {
            Pair rem = q.remove();
            if (rem.i == 0 || rem.j == 0) {
                System.out.println(rem.path);
            } else {
                int currMaxProfit = dp[rem.i][rem.j];
                int currWt = weights[rem.i - 1];
                int currVal = values[rem.i - 1];
                int allowedWt = rem.j;

                if(allowedWt >= currWt) {
                    int inc = dp[rem.i-1][allowedWt - currWt] + currVal;
                    if(inc == currMaxProfit) {
                        q.add(new Pair(rem.i - 1, allowedWt - currWt, rem.i-1 + " " + rem.path));
                    }
                }

                int exc = dp[rem.i-1][rem.j];

                if(exc == currMaxProfit) {
                    q.add(new Pair(rem.i - 1, rem.j, rem.path));
                }
            }
        }
    }
}
