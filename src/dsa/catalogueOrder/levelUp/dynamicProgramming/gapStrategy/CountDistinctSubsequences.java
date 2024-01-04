package dsa.catalogueOrder.levelUp.dynamicProgramming.gapStrategy;

import java.util.HashMap;

public class CountDistinctSubsequences {

    public long countDistinctSubsequences(String str) {
        int len = str.length();
        long[] dp = new long[len + 1];

        dp[0] = 1; // denote blank subsequence ... base case
        HashMap<Character, Integer> lastOccurence = new HashMap<>();

        for(int i = 1; i < len+1; i++) {
            dp[i] = 2 * dp[i-1];

            char ch = str.charAt(i-1);
            if(lastOccurence.containsKey(ch) == true) {
                int j = lastOccurence.get(ch);
                dp[i] = dp[i] - dp[j-1];
            }
            lastOccurence.put(ch, i);
        }

        return dp[len];
    }
}

