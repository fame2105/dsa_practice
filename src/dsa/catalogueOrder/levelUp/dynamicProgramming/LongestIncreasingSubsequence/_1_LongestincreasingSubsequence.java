package dsa.catalogueOrder.levelUp.dynamicProgramming.LongestIncreasingSubsequence;

import java.util.Scanner;

public class _1_LongestincreasingSubsequence {

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = s.nextInt();
        }

        int maxLength = 0;
        int[] dp = new int[n];        

        for (int i = 0; i < n; i++) {
            int currentMaxLength = 0;

            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    currentMaxLength = Math.max(currentMaxLength, dp[j]);
                }
            }

            dp[i] = currentMaxLength + 1;
            maxLength = Math.max(maxLength, dp[i]);
        }

        System.out.println(maxLength);
    }
}
