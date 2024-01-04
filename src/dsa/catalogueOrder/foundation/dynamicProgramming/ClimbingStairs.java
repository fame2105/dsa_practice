package dsa.catalogueOrder.foundation.dynamicProgramming;

import java.util.Scanner;

public class ClimbingStairs {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        System.out.println(countWaysClimbingStairsRecursive02(n));
        System.out.println(countWaysClimbingStairsTabulationDp(n, new int[n + 1]));
    }

         // i -> ith stair
        // n -> reach destination stair
       //  jumps[] -> jumps allowed at ith step
    private static int climbStairsVariableJumpsRecursive(int i, int n, int[] jumps) {
        if(i == n) return 1;

        int count = 0;
        for(int jump = 1; (jump <= jumps[i] && jump + i <= n); jump++) {
            count += climbStairsVariableJumpsRecursive(i + jump, n, jumps);
        }
        return count;
    }

    private static int climbStairsVariableJumpsMemoization(int i, int n, int[] jumps, int[] dp) {
        if(i == n) return dp[i] = 1;

        if(dp[i] != 0) {
            return dp[i];
        }

        int count = 0;
        for(int jump = 1; (jump <= jumps[i] && jump + i <= n); jump++) {
            count += climbStairsVariableJumpsMemoization(i + jump, n, jumps, dp);
        }
        return dp[i] = count;
    }

    private static int countWaysClimbingStairsTabulationDp(int n, int[] dp) {

        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            if (i == 1) {
                dp[i] = dp[i - 1];
            } else if (i == 2) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
        }

        return dp[n];
    }

    private static int countWaysClimbingStairMemoized(int n, int[] dp) {
        if(n == 0) return 1;

        if(dp[n] != 0) {
            return dp[n];
        }

        int count = 0;
        for(int i = 1; i <= 3; i++) {
            if(n-i >= 0) {
                count += countWaysClimbingStairMemoized(n-i, dp);
            }
        }
        return dp[n] = count;
    }

    private static int countWaysClimbingStairsRecursive01(int n) {
        if (n == 0) {
            return 1;
        }

        if (n < 0) {
            return 0;
        }

        return countWaysClimbingStairsRecursive01(n - 1) + countWaysClimbingStairsRecursive01(n - 2) + countWaysClimbingStairsRecursive01(n - 3);
    }

    private static int countWaysClimbingStairsRecursive02(int n) {
        if (n == 0) {
            return 1;
        }

        int count = 0;
        for(int i = 1; i <= 3; i++) {
            if(n-i >= 0) {
                count += countWaysClimbingStairsRecursive02(n-i);
            }
        }
        return count;
    }
}
