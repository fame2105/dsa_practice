package dsa.leetcodeANDgfg;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/word-subsets/  #HashMap, logic
public class _916_WordSubsets {
    public List<String> wordSubsets(String[] words1, String[] words2) {

        // max_freq[] represents a combined word that has the maximum count of characters from words in words2[]
        // ex: words2[] = {arr, wo, ro} ... a:1 r:2 w:1 o:1  (this is not the sum of occurence of characters, rather the
        // max count of a character among all the characters in words2[])
        // 'r' has max occurence of 2 among all the words in words2[]
        // 'w' has 1 , 'o' has 1, 'a' has 1
        // If we store the maxOccurence of characters then we have essentially combined all those characters from words2[] to form a giant word, say for ex : "arrow"
        // now we don't need to check each and every word individually rather just check the count of characters in this giant word
        // If any word from words1[] has the freqOfEachChar >= maxFreqOfEachChar in giantWord then we add that word from words1[] in result

        int[] max_freq = new int[26];
        for(String word : words2) {
            int[] freq_word = getFrequencies(word);
            for(int i = 0; i < 26; i++) {
                max_freq[i] = Math.max(max_freq[i], freq_word[i]);
            }
        }

        ArrayList<String> res = new ArrayList<>();
        for(String word : words1) {
            int[] freq_word = getFrequencies(word);
            boolean isUniversal = true;
            for(int i = 0; i < 26; i++) {
                if(freq_word[i] < max_freq[i]) {
                    isUniversal = false;
                    break;
                }
            }

            if(isUniversal == true) {
                res.add(word);
            }
        }

        return res;

    }

    private int[] getFrequencies(String word) {
        int[] freq = new int[26];
        for(char c : word.toCharArray())
            freq[c - 'a']++;

        return freq;
    }
}
