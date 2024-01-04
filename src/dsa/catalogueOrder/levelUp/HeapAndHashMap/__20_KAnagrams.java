package dsa.catalogueOrder.levelUp.HeapAndHashMap;

import java.util.HashMap;

public class __20_KAnagrams {
    public static boolean areKAnagrams(String str1, String str2, int k) {
        HashMap<Character, Integer> map = new HashMap<>(); // prepare frequencyMap for str1
        for (char c : str1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : str2.toCharArray()) {
            if(map.getOrDefault(c, 0) == 0) {
                continue;
            } else {
                map.put(c, map.get(c) - 1);
            }
        }

        int count = 0;
        for(char c : map.keySet()) {
            count += map.get(c);
        }

        return count <= k;
    }
}
