package dsa.catalogueOrder.levelUp.HeapAndHashMap;

import java.util.HashMap;

public class __18_CountOfSubStringsWithAtmostKUniqueCharacters {

    public static int countOfSubStringsWithAtmostKUniqueCharacters(String s, int k) {
        int countSubarrays = 0;
        int j = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            while (j < s.length() && map.size() <= k) {
                char c = s.charAt(j);
                map.put(c, map.getOrDefault(c, 0) + 1);
                j++;

                if (map.size() <= k) {
                    int subarraysFormedSoFar = j - i;
                    countSubarrays += subarraysFormedSoFar;
                } else {
                    break;
                }
            }

            if (i < j && map.size() > k) {
                char c = s.charAt(i);
                if (map.get(c) == 1) {
                    map.remove(c);
                } else {
                    map.put(c, map.get(c) - 1);
                }

                if (map.size() == k) {
                    int subarraysFormedSoFar = j - (i+1);
                    countSubarrays += subarraysFormedSoFar;
                }
            }
        }
        return countSubarrays;
    }
}
