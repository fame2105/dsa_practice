package dsa.catalogueOrder.levelUp.HeapAndHashMap;

import java.util.HashMap;
import java.util.HashSet;

// https://leetcode.com/problems/word-pattern/ (Easy) - Almost exactly like Isomorphic Strings question
public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        String[] str = s.split(" ");
        if(pattern.length() != str.length) return false;

        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> processedWords = new HashSet<>();
        for(int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String word = str[i];

            if(map.containsKey(c)) {
                boolean isMappingCorrect = map.get(c).equals(word);
                if(isMappingCorrect == false) return false;
            } else {
                if(processedWords.contains(word) == true) {
                    return false;
                } else {
                    map.put(c, word);
                    processedWords.add(word);
                }
            }
        }

        return true;
    }
}
