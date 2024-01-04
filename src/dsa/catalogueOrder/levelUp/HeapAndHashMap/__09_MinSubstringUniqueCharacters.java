package dsa.catalogueOrder.levelUp.HeapAndHashMap;

import java.util.HashMap;
import java.util.HashSet;
public class __09_MinSubstringUniqueCharacters {
    public static int minWindowUniqueSubString(String str){
        HashSet<Character> unique = new HashSet<>();
        for(char c : str.toCharArray()) {
            if(!unique.contains(c)) {
                unique.add(c);
            }
        }

        int ans = Integer.MAX_VALUE;
        int j = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int cCount = 0;

        for(int i = 0; i < str.length(); i++) {
            while(j < str.length() && map.size() < unique.size()) {
                char c = str.charAt(j);
                map.put(c, map.getOrDefault(c, 0) + 1);
                j++;
            }

            if(i < j && map.size() == unique.size()) {
                int potentialLength = j - i;
                if(ans > potentialLength) {
                    ans = potentialLength;
                }

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
