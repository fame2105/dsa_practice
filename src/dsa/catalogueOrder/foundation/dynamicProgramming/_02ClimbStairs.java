package dsa.catalogueOrder.foundation.dynamicProgramming;

import java.util.Scanner;

/**
 * 1. You are given a number n, representing the number of stairs in a staircase.
 * 2. You are on the 0th step and are required to climb to the top.
 * 3. In one move, you are allowed to climb 1, 2 or 3 stairs.
 * 4. You are required to print the number of different paths via which you can climb to the top.
 *
 * Input Format
 *
 * A number n
 *
 * Output Format
 *
 * A number representing the number of ways to climb the stairs from 0 to top.
 */
public class _02ClimbStairs {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

//        System.out.println(climbStairsRecursive(n));

        int[] dp = new int[n+1];
        System.out.println(climbStairsMemoized(n, dp));
    }

    // n -> destination stair starting from 0
    private static int climbStairsRecursive(int n) {
        if (n == 0) return 1; // base case -> there is always 1 path from 0 to 0 or from n to n

        int numPaths = 0;
        for (int jump = 1; jump <= 3; jump++) {
            if (n - jump >= 0) {
                numPaths += climbStairsRecursive(n - jump);
            }
        }
        return numPaths;
    }

    private static int climbStairsMemoized(int n, int[] dp) {
        if (n == 0){
            return dp[n] = 1; // base case -> there is always 1 path from 0 to 0 or from n to n
        }

        if(dp[n] != 0) return dp[n];

        int numPaths = 0;
        for (int jump = 1; jump <= 3; jump++) {
            if (n - jump >= 0) {
                numPaths += climbStairsRecursive(n - jump);
            }
        }
        return dp[n] = numPaths;
    }

    private static int climbStairsTabulation(int n, int[] dp) {
        dp[n] = 1; // base case -> number of paths from n to n is 1
        for(int i = n-1; i>=0; i--) {
            if(i == n-1) {
                dp[i] = dp[i+1];
            } else if(i == n-2) {
                dp[i] = dp[i+1] + dp[i+2];
            } else {
                dp[i] = dp[i+1] + dp[i+2] + dp[i+3];
            }
        }
        return dp[n];
    }
}
