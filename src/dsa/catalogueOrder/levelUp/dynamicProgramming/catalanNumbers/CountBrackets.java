package dsa.catalogueOrder.levelUp.dynamicProgramming.catalanNumbers;

public class CountBrackets {
    public int countBrackets(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i < n+1; i++) {
            int inside = i-1; // 3
            int outside = 0; // 0

            int bracketWays = 0;

            while(inside >= 0) {
                bracketWays += dp[inside] * dp[outside];
                inside--;
                outside++;
            }
            dp[i] = bracketWays;
        }

        return dp[n];
    }
}
