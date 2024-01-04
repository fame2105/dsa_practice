package dsa.catalogueOrder.levelUp.HeapAndHashMap.remaining;

import java.util.HashMap;

public class __13_CountOfSubstringWithKDistinctCharacters {
    public static void main(String[] args) {
        String s = "aabcbcdbca";
        int k = 2;
        System.out.println(solution(s, k));
    }
    public static int solution(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int j = 0;
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            while (j < s.length() && map.size() <= k) {
                char c = s.charAt(j++);
                map.put(c, map.getOrDefault(c, 0) + 1);

                if (map.size() > k) {
                    map.remove(c);
                    j--;
                    break;
                }

                if (map.size() == k) {
                    count += 1;
                }
            }

            while (i < j && map.size() == k) {
                char c = s.charAt(i++);

                if (map.get(c) == 1) {
                    map.remove(c);
                } else {
                    map.put(c, map.getOrDefault(c, 0) - 1);
                }

                if(map.size() == k) {
                    if (i < s.length() && s.charAt(i) == c) {
                        count += count;
                    } else {
                        count += 1;
                    }
                }
            }
        }

        return count;
    }
}
