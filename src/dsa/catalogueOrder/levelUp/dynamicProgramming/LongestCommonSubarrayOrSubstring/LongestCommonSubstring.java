package dsa.catalogueOrder.levelUp.dynamicProgramming.LongestCommonSubarrayOrSubstring;

// Editorial : https://www.youtube.com/watch?v=NvmJBCn4eQI&ab_channel=Pepcoding

public class LongestCommonSubstring {

    public int lengthOfLongestCommonSubstring(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        int maxLength = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                char c1 = s1.charAt(i - 1);
                char c2 = s2.charAt(j - 1);

                if (c1 != c2) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }

                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }

        return maxLength;
    }
}
