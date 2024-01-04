package dsa.leetcodeANDgfg;

import java.util.HashMap;

// https://leetcode.com/problems/compare-strings-by-frequency-of-the-smallest-character/description/
public class _1170_CompareStringsByFrequencyOfTheSmallestCharacter {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        HashMap<String, Integer> q = new HashMap<>();
        HashMap<String, Integer> w = new HashMap<>();
        int[] ans = new int[queries.length];

        for(String str : queries)
            processWord(str, q);

        for(String str : words)
            processWord(str, w);

        for(int i = 0; i < queries.length; i++) {
            int valq = q.get(queries[i]);
            int count = 0;
            for(String str2 : words) {
                if(valq < w.get(str2)) {
                    count += 1;
                }
            }
            ans[i] = count;
        }
        return ans;
    }
    private void processWord(String word, HashMap<String, Integer> map) {
        char smallestChar = 'z';
        int[] freq = new int[26]; // to store the frequency of each of the character in word
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            freq[c-'a']++;
        }
        for(int i = 0; i < 26; i++) {
            if(freq[i] != 0) { // the very first character that has frequency > 0 would be the lexiographically smallest character, store the frequency of this character in the given map against the given word and break from loop
                map.put(word, freq[i]);
                break;
            }
        }
    }
}
