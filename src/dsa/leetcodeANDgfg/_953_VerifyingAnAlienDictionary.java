package dsa.leetcodeANDgfg;
import java.util.HashMap;

// https://leetcode.com/problems/verifying-an-alien-dictionary/   #HashMap -> Upper Easy
public class _953_VerifyingAnAlienDictionary {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < order.length(); i++) {
            char c = order.charAt(i);
            map.put(c, i);
        }

        for(int i = 1; i < words.length; i++) {
            String prev = words[i-1];
            String curr = words[i];

            if(compare(prev, curr, map) == false) return false;
        }

        return true;
    }

    private boolean compare(String prev, String curr, HashMap<Character, Integer> map) {
        int prev_len = prev.length();
        int curr_len = curr.length();
        int i = 0, j = 0;
        boolean sorted = false;
        while(i < prev_len && j < curr_len) {
            char prevc = prev.charAt(i++);
            char currc = curr.charAt(j++);
            if(prevc != currc) {
                if(map.get(prevc) > map.get(currc)) return false;
                else return true;
            }
        }

        if(prev_len > curr_len) return false;

        return true;
    }
}
