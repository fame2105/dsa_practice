package dsa.leetcodeANDgfg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Link : https://leetcode.com/problems/find-all-anagrams-in-a-string/description/

public class _438_FindAllAnagramsInAString_SlidingWindow {
    public List<Integer> findAnagrams(String str, String pattern) {
        List<Integer> result = new ArrayList<>();
        if (str.length() < pattern.length()) return result;

        HashMap<Character, Integer> pMap = new HashMap<>();
        for (Character c : pattern.toCharArray()) {
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> sMap = new HashMap<>();

        int j = 0;
        int windowSize = pattern.length();
        for (int i = 0; i <= str.length() - windowSize; i++) {
            while (j - i + 1 <= windowSize) {
                char currentChar = str.charAt(j);
                sMap.put(currentChar, sMap.getOrDefault(currentChar, 0) + 1);

                if (j - i + 1 == windowSize) {
                    if (sMap.equals(pMap)) { // we could write our own hashMapCompare function but equals in hashmap is overriden to provide comparision
                        result.add(i);
                    }

                    char removeChar = str.charAt(i);
                    if (sMap.get(removeChar) == 1) {
                        sMap.remove(removeChar);
                    } else {
                        sMap.put(removeChar, sMap.get(removeChar) - 1);
                    }
                }

                j++;
            }
        }
        return result;
    }
}