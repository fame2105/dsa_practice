package dsa.catalogueOrder.levelUp.HeapAndHashMap;

import java.util.HashMap;

public class __10_LongestSubstringWithNoRepeatingCharacters {
    public static void main(String[] args) {
        String s = "aabcbcdbca";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        int ans = Integer.MIN_VALUE;
        int j = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        boolean acquire = true;

        for (int i = 0; i < s.length(); i++) {
            while(j < s.length() && acquire == true) {
                char c = s.charAt(j++);
                map.put(c, map.getOrDefault(c, 0) + 1);
                if(map.get(c) == 2) {
                    acquire = false;
                    break;
                } else {
                    int len = j-i;
                    ans = Math.max(ans, len);
                }
            }

            if(i < j) {
                char c = s.charAt(i);
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 1) {
                    acquire = true;
                }
            }
        }

        return ans;
    }
}
