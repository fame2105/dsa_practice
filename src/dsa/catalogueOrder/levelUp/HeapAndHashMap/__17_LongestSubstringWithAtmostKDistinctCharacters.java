package dsa.catalogueOrder.levelUp.HeapAndHashMap;

import java.util.HashMap;

public class __17_LongestSubstringWithAtmostKDistinctCharacters {

    public static int longestSubStringAtmostKuniqueCharacters(String str, int k) {
        int ans = 0;
        int j = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < str.length(); i++) {
            while(j < str.length() && map.size() <= k) {
                char c = str.charAt(j++);
                map.put(c, map.getOrDefault(c, 0) + 1);
                if(map.size() <= k) {
                    int len = j - i;
                    ans = Math.max(ans, len);
                } else {
                    break;
                }
            }

            if(i < j && map.size() > k) {
                char c = str.charAt(i);
                if(map.get(c) == 1) {
                    map.remove(c);
                } else {
                    map.put(c, map.get(c) - 1);
                }
            }
        }

        return ans;
    }
}
