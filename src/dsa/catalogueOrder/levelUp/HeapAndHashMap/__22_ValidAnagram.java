package dsa.catalogueOrder.levelUp.HeapAndHashMap;

import java.util.HashMap;

public class __22_ValidAnagram {

    public static boolean validAnagram(String s1, String s2) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s1.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : s2.toCharArray()) {
            if (map.containsKey(c) == false) return false;

            if (map.get(c) == 1) {
                map.remove(c);
            } else {
                map.put(c, map.get(c) - 1);
            }
        }

        return map.size() == 0;
    }
}
