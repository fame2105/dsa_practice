package dsa.catalogueOrder.levelUp.HeapAndHashMap;

import java.util.HashMap;

public class __11_CountOfSubstringHavingAllUniqueCharacters {
    public static void main(String[] args) {
        String s = "aabcbcdbca";
        System.out.println(countOfSubstringHavingAllUniqueCharacters(s));
    }

    public static int countOfSubstringHavingAllUniqueCharacters(String s) {
        int ans = 0;
        int i = 0;
        int j = 0;
        HashMap<Character, Integer> map = new HashMap<>(); // frequency map

        while (i < s.length()) {
            while (j < s.length()) {
                char c = s.charAt(j++);
                map.put(c, map.getOrDefault(c, 0) + 1);
                if (map.get(c) == 2) {
                    break;
                } else {
                    int count = j - i;
                    ans += count;
                }
            }

            while (i < j) {
                char c = s.charAt(i++);
                map.put(c, map.get(c) - 1);

                if (map.get(c) == 1) { //  this check works bcz this was the character that caused the duplicacy of characters and as soon as we removed it ,... our string is valid
                    int count = j - i;
                    ans += count;
                    break;
                }
            }
        }

        return ans;
    }
}
