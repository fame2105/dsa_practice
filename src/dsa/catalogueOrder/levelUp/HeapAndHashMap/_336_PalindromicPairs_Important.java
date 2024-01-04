package dsa.catalogueOrder.levelUp.HeapAndHashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

// https://leetcode.com/problems/palindrome-pairs/
public class _336_PalindromicPairs_Important {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        if (words.length == 1) return ans;

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        // Case  1 : there is an empty string in words[] and therefore it could combine with all the Strings in words[] that are palindrome
        if (map.containsKey("") == true) {
            int blankIdx = map.get("");
            for (int i = 0; i < words.length; i++) {
                if (i == blankIdx) continue;
                boolean isWordPalindrome = isPalindrome(words[i]);
                if (isWordPalindrome == true) {
                    ans.add(Arrays.asList(blankIdx, i));
                    ans.add(Arrays.asList(i, blankIdx));
                }
            }
        }

        // Case  2 : reverse of a certain word exists in words[] ex: [abc, cba]
        for (int i = 0; i < words.length; i++) {
            String reversedWord = new StringBuilder(words[i]).reverse().toString();
            if (map.containsKey(reversedWord) && map.get(reversedWord) != i)
                ans.add(Arrays.asList(map.get(reversedWord), i));
        }

        // Case 3: this has 2 subcases
        /**
         * 1. Cut a word at each index .. ex : 1 character, 2 cahracters and so on...
         * 2. If Prefix is a palindrome and reverse of suffix is present in map... then we have found 2 Strings that can combine to provide a palindrome
         * 3. If suffix is a palindrome and reverse of Prefix is present in map... then we have found 2 Strings that can combine to provide a palindrome
         **/
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            for (int cut = 1; cut < word.length(); cut++) {
                String prefix = word.substring(0, cut);
                String suffix = word.substring(cut);

                if (isPalindrome(prefix)) {
                    String revSuffix = new StringBuilder(suffix).reverse().toString();
                    if (map.containsKey(revSuffix)) {
                        ans.add(Arrays.asList(map.get(revSuffix), i));
                    }
                }

                if (isPalindrome(suffix)) {
                    String revPrefix = new StringBuilder(prefix).reverse().toString();
                    if (map.containsKey(revPrefix)) {
                        ans.add(Arrays.asList(i, map.get(revPrefix)));
                    }
                }
            }
        }

        return ans;
    }

    private boolean isPalindrome(String word) {
        int left = 0, right = word.length() - 1;
        while (left < right) {
            if (word.charAt(left) != word.charAt(right))
                return false;

            left++;
            right--;
        }
        return true;
    }
}
