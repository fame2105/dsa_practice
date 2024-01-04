package dsa.catalogueOrder.levelUp.HeapAndHashMap;

import java.util.HashMap;
import java.util.HashSet;

// https://leetcode.com/problems/isomorphic-strings/   (Easy)
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;

        int len = s.length();
        HashMap<Character, Character> map = new HashMap<>(); // mapping of character s : t
        HashSet<Character> alreadyMapped = new HashSet<>(); // tracks the characters mapped from t
        for(int i = 0; i < len; i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if(map.containsKey(cs) == false) {
                if(alreadyMapped.contains(ct) == false) {
                    map.put(cs, ct);
                    alreadyMapped.add(ct);
                } else { // if the chracter in String t is already mapped to some other character from s then it has come to be mapped to some other different character from s, so return false
                    return false;
                }
            } else {
                if(map.get(cs) != ct) return false; //
            }
        }

        return true;
    }
}
