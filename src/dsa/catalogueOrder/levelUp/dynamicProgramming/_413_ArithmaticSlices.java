package dsa.catalogueOrder.levelUp.dynamicProgramming;

// Question Link: https://leetcode.com/problems/arithmetic-slices/description/
// Editorial : In Smasung notes OR https://www.youtube.com/watch?v=rSi4MpGEz1M&ab_channel=Pepcoding
public class _413_ArithmaticSlices {
    public static int solution(int[] arr) {
        int[] dp = new int[arr.length];
        int ans = 0;
        for(int i = 2; i < arr.length; i++) {
            if(arr[i] - arr[i-1] == arr[i-1] - arr[i-2]) {
                dp[i] = dp[i-1] + 1;
                ans += dp[i];
            }
        }

        return ans;
    }
}
