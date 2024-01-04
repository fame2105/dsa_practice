package dsa.leetcodeANDgfg;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordBreakII {
    public static void main(String[] args) {
        String s = "dsa/leetcodeANDgfg";

        List<String> dictionary = new ArrayList<>();
        dictionary.add("leet");
        dictionary.add("code");

        System.out.println(wordBreak(s, dictionary));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        int maxLength = 0;
        for(String word : wordDict) {
            set.add(word);
            maxLength += word.length();
        }
        return wordBreakHelper(s, set, maxLength);
    }

    public static boolean wordBreakHelper(String s, HashSet<String> wordDict, int maxLength) {
        if(s.length() > maxLength) return false;

        if(s.isEmpty()) return true;

        String current = "";
        boolean result = false;
        for(int i = 0; i <s.length(); i++) {
            current += s.charAt(i);
            String ros = s.substring(i+1);
            boolean internalResult = false;
            if(wordDict.contains(current)) {
                result = wordBreakHelper(ros, wordDict, maxLength);
                if(result) return true;
            }
        }
        return result;
    }
}
