package dsa.catalogueOrder.competitive.StringProcessing;

import dsa.utility.Util;

public class KMPStringMatchingALgorithm {

    public static void main(String[] args) {
        String pattern = "bba";
        String str = "aaaaa";
//        int[] lps = longestPrefixString(pattern + "#" + str);
        int[] lps = longestPrefixString("abcabcabcabc");
        Util.display(lps, false);
    }

    private static int[] longestPrefixString(String s) {
        int i = 1, len = 0;
        int[] lps = new int[s.length()];
        while(i < s.length()) {
            if(s.charAt(i) == s.charAt(len)) {
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
