package dsa.catalogueOrder.levelUp.recursionAndBacktracking;

import java.util.HashMap;

public class AllPalindromicPermutations {
    public static void main(String[] args) {
        String input = "aaabb";

        HashMap<Character, Integer> fmap = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (fmap.containsKey(c)) {
                fmap.put(c, fmap.get(c) + 1);
            } else {
                fmap.put(c, 1);
            }
        }

        Character oddChar = null;
        int oddCharNum = 0;
        int len = 0;

        for (Character ch : fmap.keySet()) {
            int freq = fmap.get(ch);
            if (freq % 2 != 0) {
                oddChar = ch;
                oddCharNum++;
            }

            fmap.put(ch, freq / 2);
            len += freq / 2;
        }

        if (oddCharNum > 1) {
            System.out.println(-1);
            return;
        }

        allPalindromicPermutations(len, fmap, oddChar, "");
    }

    private static void allPalindromicPermutations(int ts, HashMap<Character, Integer> fmap, Character oddChar, String asf) {
        if (ts == 0) {
            String rev = "";
            for (int i = asf.length() - 1; i >= 0; i--) {
                rev += asf.charAt(i);
            }

            String result = asf;
            if (oddChar != null) {
                result += oddChar;
            }

            result += rev;
            System.out.println(result);
            return;
        }

        for (Character ch : fmap.keySet()) {
            int oldFreq = fmap.get(ch);
            if (oldFreq > 0) {
                fmap.put(ch, oldFreq - 1);
                allPalindromicPermutations(ts-1, fmap, oddChar, asf + ch);
                fmap.put(ch, oldFreq);
            }
        }
    }
}
