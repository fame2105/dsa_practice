package dsa.catalogueOrder.foundation.dynamicProgramming;

import java.util.Scanner;

public class _07_TargetSumSubset {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        int targetSum = s.nextInt();

        boolean[][] dp = new boolean[arr.length + 1][targetSum + 1];


        System.out.println(targetSumSubset(arr, targetSum, dp));
    }

    private static boolean targetSumSubset(int[] arr, int target, boolean[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if(i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if(i == 0) {
                    dp[i][j] = false;
                } else if(j == 0) {
                    dp[i][j] = true;
                } else {
                    if(dp[i-1][j] == true) {
                        dp[i][j] = true;
                    } else {
                        int val = arr[i-1];
                        if(j >= val  && dp[i-1][j-val] == true) {
                            dp[i][j] = true;
                        }
                    }
                }
            }
        }

        return dp[arr.length][target];
    }

    private static boolean targetSumSubset_recursive(int[] arr, int index, int target) {
        if(target == 0) return true;
        if(index == arr.length) { return false; }

        boolean result = false;
        if(target - arr[index] >= 0) {
            result = targetSumSubset_recursive(arr, index+1, target-arr[index]);
        }
        result = result || targetSumSubset_recursive(arr, index+1, target);
        return result;
    }
}
