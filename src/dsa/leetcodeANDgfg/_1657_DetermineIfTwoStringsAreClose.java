package dsa.leetcodeANDgfg;

import java.util.Arrays;

// https://leetcode.com/problems/determine-if-two-strings-are-close/ (medium) - Google
public class _1657_DetermineIfTwoStringsAreClose {
    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length()) return false;

        /* to check if frequency of each character is same or not, once we sort both frequency array, then f1 should be equal to f2 if both have same characters and each character has same frequency in both words */
        int[] f1 = new int[26], f2 = new int[26];
        boolean[] v1 = new boolean[26], v2 = new boolean[26]; // to check if both words have exactly same characters

        int len = word1.length(); // any word could be used for length.

        for(int i = 0; i < len; i++) {
            f1[word1.charAt(i) - 'a']++;
            f2[word2.charAt(i) - 'a']++;
            v1[word1.charAt(i) - 'a'] = true;
            v2[word2.charAt(i) - 'a'] = true;
        }

        Arrays.sort(f1);
        Arrays.sort(f2);

        if(Arrays.equals(f1, f2) == true && Arrays.equals(v1, v2) == true) return true;

        return false;
    }
}
