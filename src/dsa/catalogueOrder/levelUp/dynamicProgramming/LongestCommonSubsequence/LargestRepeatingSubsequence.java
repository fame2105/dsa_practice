package dsa.catalogueOrder.levelUp.dynamicProgramming.LongestCommonSubsequence;

public class LargestRepeatingSubsequence {

    public static int largestRepeatingSubsequence(String str){
        int len = str.length();
        int[][] dp = new int[len+1][len+1];

        int max = 0;
        for(int i = len-1; i >=0; i--) {
            for(int j = len - 1; j >=0; j--) {
                char c1 = str.charAt(i);
                char c2 = str.charAt(j);

                if(c1 == c2 && i != j) {
                    dp[i][j] = dp[i+1][j+1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j+1]);
                }

                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}
