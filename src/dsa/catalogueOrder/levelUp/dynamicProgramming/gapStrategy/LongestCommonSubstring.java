package dsa.catalogueOrder.levelUp.dynamicProgramming.gapStrategy;

public class LongestCommonSubstring {

    public static int longestCommonSubstring(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        int max = 0;
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                char c1 = s1.charAt(i - 1);
                char c2 = s2.charAt(j - 1);

                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
