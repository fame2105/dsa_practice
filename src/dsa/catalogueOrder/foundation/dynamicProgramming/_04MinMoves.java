package dsa.catalogueOrder.foundation.dynamicProgramming;

import java.util.Scanner;

public class _04MinMoves {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] steps = new int[n];
        for(int i = 0; i < n; i++) {
            steps[i] = s.nextInt();
        }

        Integer[] dp = new Integer[n+1];

        dp[n] = 0; // min. 0 number steps needed to reach destination while standing at destination
        for(int i = n-1; i >= 0; i--) {
            // if allowed jumps from a certain position is 0, we can't move anywhere from that position, so only process if step[i] > 0
            if(steps[i] > 0) {
                // calculate min. Steps needed to reach at n from i.
                int minJumpsNeeded = Integer.MAX_VALUE;
                for(int jump = 1; jump <= steps[i] && i + jump < dp.length; jump++) {
                    if(dp[i+jump] != null)
                        minJumpsNeeded = Math.min(minJumpsNeeded, dp[i + jump]);
                }

                if(minJumpsNeeded == Integer.MAX_VALUE) dp[i] = null;
                else dp[i] = minJumpsNeeded + 1;
            }
        }

        System.out.println(dp[0]);
    }
}
