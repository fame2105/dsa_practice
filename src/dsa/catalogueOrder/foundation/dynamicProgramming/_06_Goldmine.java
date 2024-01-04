package dsa.catalogueOrder.foundation.dynamicProgramming;

import java.util.Scanner;

public class _06_Goldmine {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int row = s.nextInt();
        int column = s.nextInt();

        int[][] gold = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                gold[i][j] = s.nextInt();
            }
        }

//        System.out.println(goldmineTabulation(gold));

    }


    private static int goldmineTabulation(int[][] gold) {
        int[][] dp = new int[gold.length][gold[0].length];

        // j -> column
        for (int j = dp[0].length - 1; j >= 0; j--) {
            // i -> row
            for (int i = 0; i < dp.length; i++) {
                // if in last column
                if (j == dp[0].length - 1) {
                    dp[i][j] = gold[i][j];
                } else if (i == 0) { // if in 1st row
                    dp[i][j] = gold[i][j] + Math.max(dp[i][j + 1], dp[i + 1][j + 1]);
                } else if (i == dp.length - 1) { // if in last row
                    dp[i][j] = gold[i][j] + Math.max(dp[i][j + 1], dp[i - 1][j + 1]);
                } else {
                    dp[i][j] = gold[i][j] + Math.max(dp[i + 1][j + 1], Math.max(dp[i][j + 1], dp[i - 1][j + 1]));
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            if (max < dp[i][0])
                max = dp[i][0];
        }
        return max;
    }

}
