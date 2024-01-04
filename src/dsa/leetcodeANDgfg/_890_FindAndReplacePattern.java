package dsa.leetcodeANDgfg;

import java.util.*;

// https://leetcode.com/problems/find-and-replace-pattern/  #HashMap
public class _890_FindAndReplacePattern {
    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        for(String word: words) {
            if(isMatching(word, pattern)) result.add(word);
        }

        return result;
    }

    private boolean isMatching(String word, String pattern) {
        // A map and a set is maintained for each word and pattern string to verify the bidirectional mapping for each patterCharacter and a wordCharacter
        HashMap<Character, Character> patternToWordMap = new HashMap<>();

        // we need to maintain a set to contain all the words from Word that are already mapped against some character in the pattern
        Set<Character> alreadyMappedCharFromWords = new HashSet<>();

        for(int i = 0; i < word.length(); i++) {
            char wc = word.charAt(i);
            char pc = pattern.charAt(i);

            // if patternCharacter is present in the map, then we must have mapped
            // the patternCharacter against some wordCharacter, previously
            if(patternToWordMap.containsKey(pc)) {

                // Now that patternCharacter is already mapped then check that the character from word that we are trying to map now
                // is the same character for which the mapping is already present in the map.
                // ex : pattern : "rss"   word : "bad"
                // if 's'->'a' mapping was done previously then we should return false because we are trying to map 's' against 'd' which means that pattern and the word are not matching
                if(patternToWordMap.get(pc) != wc) return false;

            } else {
                // we are checking that :
                // current patternCharacter is not mapped against any character from word,
                // so check if the wordCharacter was already mapped against any of the patternCharacter
                // if true, then it means that a character from word is trying to get mapped against a different character from the pattern
                // ex: pattern : "rs" and word : "aa"
                // we mapped 'r' -> 'a' and we are attempting to match 's' -> 'a'
                // (if same character from word is attempting to match with two different characters from word, then pattern and word are mismatched..... return false)
                if(alreadyMappedCharFromWords.contains(wc)) return false;

                alreadyMappedCharFromWords.add(wc); // add new mapping for patternCharacter to wordCharacter

                // add wordChracter to set, so we know that this character from word is already mapped to some character from pattern
                // this means that for the coming iterations, if this word is duplicated,
                // then we should check that the patternCharacter against which this wordCharacter is mapped is the same patternChracter for
                // every iteration
                patternToWordMap.put(pc, wc);
            }
        }
        return true;
    }
}
