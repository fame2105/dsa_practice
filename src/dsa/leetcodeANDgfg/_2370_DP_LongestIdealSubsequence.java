package dsa.leetcodeANDgfg;

// https://leetcode.com/problems/longest-ideal-subsequence/
// Editorial : https://www.youtube.com/watch?v=2xECn26gyOQ&list=PLZwqtTlu3nLHEYTb74WOP7LM99uJGf7oI&ab_channel=PrakharAgrawal
public class _2370_DP_LongestIdealSubsequence {
    public int longestIdealString(String s, int k) {
        int ans = 0;
        int[] dp = new int[150];

        for(int i = 0; i < s.length(); i++) {
            int currMaxLen = 0;
            int currCharVal = s.charAt(i); // Ascii of Current Character
            for(int j = currCharVal - k; j <= (currCharVal + k); j++) {
                currMaxLen = Math.max(currMaxLen, dp[j]);
            }

            dp[currCharVal] = currMaxLen + 1; // for including current Character as a part of the sequence
            ans = Math.max(ans, dp[currCharVal]);
        }
        return ans;
    }
}
