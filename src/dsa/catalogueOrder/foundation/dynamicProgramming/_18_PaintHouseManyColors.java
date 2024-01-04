package dsa.catalogueOrder.foundation.dynamicProgramming;

public class _18_PaintHouseManyColors {
    public static void main(String[] args) {
        int[][] cost = new int[][] {
                {1, 5, 7, 2},
                {5, 8, 4, 3},
                {3, 2, 9, 7},
                {1, 4, 2, 5},
                {2, 6, 1, 8}
        };
        int minCost = paintHouseManyColors(cost);
        System.out.println(minCost);
    }

    private static int paintHouseManyColors(int[][] cost) {
        int n = cost.length; // total no. of houses
        int k = cost[0].length; // available colors to paint the house

        int[][] dp = new int[n][k];
        int min = (int)1e9;
        int secondMin = (int)1e9;

        for (int i = 0; i < n; i++) {

            int newMin = (int) 1e9;
            int newSecondMin = (int) 1e9;

            for (int j = 0; j < k; j++) { //  while filling any row in dp[][] except first row, we need only least and secondLeast element to construct next row
                if(i == 0) { // cannot optimize things for house no 1 -> base/initialization case
                    dp[i][j] = cost[i][j];
                } else {
                    if(dp[i-1][j] == min) { // incase the min from previous house for obtained by painting it with same color as for this one,
                                            // this could violate the condition of no consecutive painting allowed, hence we use second min
                        dp[i][j] = cost[i][j] + secondMin;
                    } else {
                        dp[i][j] = cost[i][j] + min;
                    }
                }

                // To maintain min and second min for each row.
                if(dp[i][j] <= newMin) {
                    newSecondMin = newMin;
                    newMin = dp[i][j];
                } else if(dp[i][j] < newSecondMin) {
                    newSecondMin = dp[i][j];
                }
            }
            min = newMin;
            secondMin = newSecondMin;
        }
        return min;
    }
}
