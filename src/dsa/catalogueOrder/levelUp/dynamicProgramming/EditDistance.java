package dsa.catalogueOrder.levelUp.dynamicProgramming;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int[][] dp = new int[l1+1][l2+1];

        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                if(i == 0) {
                    dp[i][j] = j;
                } else if(j == 0) {
                    dp[i][j] = i;
                } else {
                    char c1 = word1.charAt(i-1);
                    char c2 = word2.charAt(j-1);

                    if(c1 == c2)
                        dp[i][j] = dp[i-1][j-1];
                    else{
                        int deleteCost = dp[i-1][j] + 1;
                        int replaceCost = dp[i-1][j-1] + 1;
                        int insertCost = dp[i][j-1] + 1;
                        dp[i][j] = Math.min(deleteCost, Math.min(replaceCost, insertCost));
                    }
                }
            }
        }

        return dp[l1][l2];
    }
}
