package dsa.catalogueOrder.foundation.dynamicProgramming;

import java.util.Scanner;

public class ClimbingStairsWithMinMoves {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt(); //-> final destination
        int[] moveSize = new int[n];

        for (int i = 0; i < n; i++) {
            moveSize[i] = s.nextInt();
        }

        Integer[] dp = new Integer[n + 1];

        System.out.println(climbStairsWithMinMoves(n, moveSize, dp));

    }

    private static Integer climbStairsWithMinMoves(int n, int[] moveSize, Integer[] dp) {
        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (moveSize[i] > 0) {
                int min = Integer.MAX_VALUE;
                for (int j = 1; j <= moveSize[i] && i + j < dp.length; j++) {
                    if (dp[i + j] != null && dp[i + j] < min) {
                        min = dp[i + j];
                    }
                }

                if (min != Integer.MAX_VALUE) {
                    dp[i] = min + 1;
                }
            }
        }
        return dp[0];
    }
}
