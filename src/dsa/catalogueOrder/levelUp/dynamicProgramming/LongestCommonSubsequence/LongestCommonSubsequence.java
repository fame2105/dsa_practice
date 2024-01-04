package dsa.catalogueOrder.levelUp.dynamicProgramming.LongestCommonSubsequence;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int len1 = text1.length();
        int len2 = text2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                char c1 = text1.charAt(i);
                char c2 = text2.charAt(j);

                if(c1 == c2) {
                    dp[i][j] = dp[i+1][j+1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }
        return dp[0][0];
    }
}
