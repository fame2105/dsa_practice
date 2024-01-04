package dsa.catalogueOrder.foundation.dynamicProgramming;

import java.util.Scanner;

public class _03_ClimbStairsVariablePath {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int[] jumpsAllowedAtEachPath = new int[n];
        for(int i = 0; i< n; i++) {
            jumpsAllowedAtEachPath[i] = s.nextInt();
        }

        System.out.println(climbStairsVariableJumpsRecursive(0, jumpsAllowedAtEachPath));
        System.out.println(climbStairsVariableJumpsMemoized(0, jumpsAllowedAtEachPath, new int[n+1]));
        System.out.println(climbStairsVariableJumpsTabulation(jumpsAllowedAtEachPath, new int[n+1]));
    }

    // i -> current stair
    // jumps.length -> n (destination stair starting from 0)
    // jumps[] -> jump allowed a ith stair
    private static int climbStairsVariableJumpsRecursive(int i, int[] jumps) {
        if(i == jumps.length) return 1;

        int numPaths = 0;
        for (int jump = 1; jump <= jumps[i] && jump + i <= jumps.length; jump++) {
                numPaths += climbStairsVariableJumpsRecursive(i + jump, jumps);
        }
        return numPaths;
    }

    private static int climbStairsVariableJumpsMemoized(int i, int[] jumps,  int[] dp) {
        if (i == jumps.length){
            return dp[i] = 1; // base case -> there is always 1 path from 0 to 0 or from n to n
        }

        if(dp[i] != 0) return dp[i];

        int numPaths = 0;
        for (int jump = 1; jump <= jumps[i]; jump++) {
            if (i + jump <= jumps.length) {
                numPaths += climbStairsVariableJumpsMemoized(i+jump, jumps, dp);
            }
        }
        return dp[i] = numPaths;
    }

    private static int climbStairsVariableJumpsTabulation(int[] jumps, int[] dp) {
        int n = jumps.length;
        dp[n] = 1; // base case -> number of paths from n to n is 1
        for(int i = n-1; i>=0; i--) {
            for(int jump = 1; jump <= jumps[i] && jump + i <= n; jump++) {
                dp[i] += dp[i+jump];
            }
        }
        return dp[0];
    }

}
