package dsa.catalogueOrder.foundation.dynamicProgramming;

import java.util.Scanner;

// https://leetcode.com/problems/paint-fence/
public class _19_PaintingFence {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt(); // number of fences
        int k = s.nextInt(); // number of colors available to paint the fence
        System.out.println(countWaysToPaintFence(n, k));

    }

    private static int countWaysToPaintFence(int n,int k) {
        int[][] dp = new int[2][n]; // we don't necessarily need a dp[], this could be optimized to use only 2 variables.
        dp[0][0] = 0;
        dp[1][0] = k;

        for(int i = 1; i < dp[0].length; i++) {
            dp[0][i] = dp[1][i-1];
            dp[1][i] = (dp[0][i-1] + dp[1][i-1]) * (k-1);
        }

        return dp[0][n-1] + dp[1][n-1];
    }
}
