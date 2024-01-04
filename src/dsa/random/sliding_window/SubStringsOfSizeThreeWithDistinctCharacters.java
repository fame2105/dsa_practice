package dsa.random.sliding_window;

import java.util.HashSet;

// https://leetcode.com/problems/substrings-of-size-three-with-distinct-characters/
public class SubStringsOfSizeThreeWithDistinctCharacters {
    public static void main(String[] args) {
        String s = "xyzzaz";
        countGoodSubstrings(s);
    }
    public static int countGoodSubstrings(String s) {
        int k = 3;
        int count = 0;
        int j = 0;

        for(int i = 0; i <= s.length() - k; i++) {
            while(j < s.length() && j-i+1 <= k) {
                if(j-i+1 == k) {
                    if(s.charAt(j) != s.charAt(j-1) && s.charAt(j) != s.charAt(j-2) && s.charAt(j-1) != s.charAt(j-2)) count++;
                }

                j++;
            }
        }

        return count;
    }
}
