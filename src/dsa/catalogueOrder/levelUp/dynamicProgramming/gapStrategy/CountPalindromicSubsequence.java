package dsa.catalogueOrder.levelUp.dynamicProgramming.gapStrategy;

public class CountPalindromicSubsequence {
    public int countPalindromicSubsequences(String s) {
        int len = s.length();

        int[][] dp = new int[len][len];

        for (int g = 0; g < len; g++) {
            for (int i = 0, j = g; j < len; i++, j++) {
                if (g == 0) {
                    dp[i][j] = 1;
                } else if (g == 1){
                    if(s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = 3;
                    } else {
                        dp[i][j] = 2;
                    }
                } else {
                    if(s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = dp[i+1][j] + dp[i][j-1] + 1;
                    } else {
                        dp[i][j] = dp[i+1][j] + dp[i][j-1] + - dp[i+1][j-1];
                    }
                }
            }
        }

        return dp[0][len-1];
    }
}
