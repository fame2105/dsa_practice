package dsa.catalogueOrder.levelUp.dynamicProgramming.gapStrategy;

public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String str) {
        if(str.length() == 1) return 1;
        else if(str.length() == 2) {
            return str.charAt(0) == str.charAt(1) ? 2 : 1;
        }

        int len = str.length();
        int[][] dp = new int[len][len];
        for(int g = 0; g < len; g++) {
            for(int i = 0, j = g; j < len; i++, j++) {
                if(g == 0) {
                    dp[i][j] = 1;
                } else if(g == 1) {
                    if(str.charAt(i) == str.charAt(j)) {
                        dp[i][j] = 2;
                    } else {
                        dp[i][j] = 1;
                    }
                } else {
                    if(str.charAt(i) == str.charAt(j)) {
                        dp[i][j] = 2 + dp[i+1][j-1];
                    } else {
                        dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                    }
                }
            }
        }

        return dp[0][len-1];
    }
}
