package dsa.catalogueOrder.levelUp.dynamicProgramming.catalanNumbers;

public class CircleAndChords {
    /**
     * 1. You are given a number N.
     * 2. There are 2*N points on a circle. You have to draw N non-intersecting chords on a circle.
     * 3. You have to find the number of ways in which these chords can be drawn.
     */
    public static long NumberOfChords(int n){
        long[] dp = new long[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i < n+1; i++) {
            long chordsFor_i_points = 0;
            for(int j = 0; j < i; j++) {
                chordsFor_i_points += dp[j] * dp[i-j-1];
            }
            dp[i] = chordsFor_i_points;
        }
        return dp[n];
    }
}
