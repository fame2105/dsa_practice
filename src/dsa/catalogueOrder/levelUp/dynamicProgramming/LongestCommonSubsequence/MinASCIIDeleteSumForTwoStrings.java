package dsa.catalogueOrder.levelUp.dynamicProgramming.LongestCommonSubsequence;

public class MinASCIIDeleteSumForTwoStrings {
    public int minimumDeleteSum(String s1, String s2) {
        int l1 = s1.length();
        int l2 = s2.length();

        int[][] dp = new int[l1+1][l2+1];

        for(int i = l1; i>=0; i--) {
            for(int j = l2; j>=0; j--) {
                if(i == l1 && j == l2) {
                    dp[i][j] = 0;
                } else if(i == l1) {
                    char c2 = s2.charAt(j);
                    dp[i][j] = (int)c2 + dp[i][j+1];
                } else if(j == l2) {
                    char c1 = s2.charAt(i);
                    dp[i][j] = (int)c1 + dp[i+1][j];
                } else {
                    char c1 = s1.charAt(i);
                    char c2 = s2.charAt(j);

                    if(c1 == c2) {
                        dp[i][j] = dp[i+1][j+1];
                    } else {
                        dp[i][j] = Math.min((int)c1 + dp[i+1][j], (int)c2 + dp[i][j+1]);
                    }
                }
            }
        }

        return dp[0][0];
    }
}
