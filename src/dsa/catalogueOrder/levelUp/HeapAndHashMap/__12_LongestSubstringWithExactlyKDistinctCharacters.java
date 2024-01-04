package dsa.catalogueOrder.levelUp.HeapAndHashMap;

import java.util.HashMap;

public class __12_LongestSubstringWithExactlyKDistinctCharacters {
    public static void main(String[] args) {
        String s = "aabcbcdbca";
        System.out.println(longestSubstringWithExactlyKDistinctCharacters(s, 2));
        HashMap<Character, Integer> map = new HashMap<>();
    }

    public static int longestSubstringWithExactlyKDistinctCharacters(String s, int k) {
        int ans = 0;
        int j = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            while (j < s.length() && map.size() <= k) {
                char c = s.charAt(j);
                map.put(c, map.getOrDefault(c, 0) + 1);
                j++;
                if (map.size() == k && ans < j - i) {
                    ans = j - i;
                }
            }

            if (i < j && map.size() > k) {
                char c = s.charAt(i);

                if (map.get(c) == 1) {
                    map.remove(c);
                } else {
                    map.put(c, map.get(c) - 1);
                }
            }
        }

        return ans;
    }
}
