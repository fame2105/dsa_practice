package dsa.leetcodeANDgfg;

// Link : https://leetcode.com/problems/lexicographically-smallest-equivalent-string/description/

import java.util.Arrays;

/**
 * Dry run this... it's easier than it looks.... just brush up Union And Find Concepts
 */
public class _1061_LexicographicallySmallestEquivalentString_UnionAndFind {
    int[] headChar;
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        headChar = new int[26];
        Arrays.fill(headChar, -1);
        for(int i = 0; i < s1.length(); i++) {
            int c1 = s1.charAt(i) - 'a';
            int c2 = s2.charAt(i) - 'a';
            union(c1, c2);
        }

        StringBuffer ans = new StringBuffer("");
        for(int i = 0; i < baseStr.length(); i++) {
            int c = baseStr.charAt(i) - 'a';
            int leaderC = find(c);
            if(leaderC != -1) {
                ans.append((char) (leaderC + 'a'));
            } else {
                ans.append((char) (c + 'a'));
            }
        }

        return ans.toString();
    }

    private void union(int x1, int x2) {
        int leaderX1 = find(x1);
        int leaderX2 = find(x2);
        if(leaderX1 != leaderX2) {
            if(leaderX1 < leaderX2) {
                headChar[leaderX2] = leaderX1;
            } else {
                headChar[leaderX1] = leaderX2;
            }
        }
    }

    private int find(int x) {
        if(headChar[x] == -1)
            return x;

        int parentX = find(headChar[x]);
        return parentX;
    }
}
