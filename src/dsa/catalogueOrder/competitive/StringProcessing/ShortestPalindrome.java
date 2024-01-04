package dsa.catalogueOrder.competitive.StringProcessing;

//https://leetcode.com/problems/shortest-palindrome/
public class ShortestPalindrome {
    public String shortestPalindrome(String s) {
        if (null == s || s.isEmpty() || s.length() == 0) return s;
        String sdash = s + "#" + new StringBuilder(s).reverse().toString();
        int longestPalindromicPrefix = LPS(sdash);

        String ans = new StringBuilder(s.substring(longestPalindromicPrefix)).reverse().toString() + s;

        return ans;
    }

    private int LPS(String s) {
        int[] lps = new int[s.length()];
        int len = 0, i = 1;

        while (i < s.length()) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len > 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps[lps.length - 1];
    }
}
