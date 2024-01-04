package dsa.leetcodeANDgfg;

import java.util.Arrays;

// https://leetcode.com/problems/the-number-of-weak-characters-in-the-game/
public class _1993_NumberOfWeakCharactersInTheGame {

    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a, b) -> (a[0] - b[0] == 0) ? b[1] - a[1] : a[0] - b[0]);

        int len = properties.length;
        int count = 0;
        int[] prevProperty = properties[len-1];
        int maxDefense = prevProperty[1];

        for(int i = len - 2; i >= 0 ; i--) {
            int[] currProperty = properties[i];
            if(maxDefense > currProperty[1]) {
                count += 1;
            } else {
                maxDefense = currProperty[1];
            }
        }
        return count;
    }
}
