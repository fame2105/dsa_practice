package dsa.catalogueOrder.competitive.StringProcessing;

// https://leetcode.com/problems/repeated-substring-pattern/
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        if(null == s || s.trim().length() == 0){
            return false;
        }

        int[] lps = LPS(s);
        int patternLength = s.length() - lps[lps.length - 1];

        if(patternLength  == s.length()) return false;
        if(s.length() % patternLength != 0) return false;

        return true;
    }

    // Generate LPS -> KMP String matching algorithm
    private int[] LPS(String str) {
        int[] lps = new int[str.length()];
        int i = 1, len = 0;
        while(i < str.length()) {
            if(str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if(len > 0) {
                    len = lps[len-1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
