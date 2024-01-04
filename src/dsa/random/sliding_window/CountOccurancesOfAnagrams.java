package dsa.random.sliding_window;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CountOccurancesOfAnagrams {
    public static void main(String[] args) {
        String str = "abababaa"; // expected output : 8
        String pattern = "aba";

        System.out.println(countOccurancesOfAnagrams(str, pattern));


    }

    // using Hashmap  -> we could also do it using array of length 26 for cases where only smallCap english characters are given as input.
    private static List<Integer> countOccurancesOfAnagrams(String str, String pattern) {
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
                    if (sMap.equals(pMap)) {
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
