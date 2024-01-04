package dsa.leetcodeANDgfg;

// Link : https://leetcode.com/problems/maximum-product-of-the-length-of-two-palindromic-subsequences/description/

/**
 * Question is relatively easy... just explore all the possibilities using brute force via recursion...
 * Input string length constraints is that length won't exceed 12 hence brute force is possible
 */
public class _2002_MaximumProductOfLengthOfTwoPalindromicSubsequences_Recursion {
    int max;
    public int maxProduct(String s) {
        max = 1;
        dfs(s.toCharArray(), 0, "", "");
        return max;
    }

    private void dfs(char[] carr, int idx, String s1, String s2) {
        if(idx >= carr.length) {
            if(isPalindrome(s1) && isPalindrome(s2)) {
                max = Math.max(max, s1.length() * s2.length());
            }
            return;
        }


        dfs(carr, idx + 1, s1 + carr[idx], s2);
        dfs(carr, idx + 1, s1, s2 + carr[idx]);
        dfs(carr, idx + 1, s1, s2);
    }

    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while(i < j) {
            if(s.charAt(i) != s.charAt(j))
                return false;

            i++;
            j--;
        }
        return true;
    }
}
