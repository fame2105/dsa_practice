package dsa.catalogueOrder.levelUp.recursionAndBacktracking;

import java.util.HashSet;

public class KWordsSelectionI {
    public static void main(String[] args) {
        String s = "abcabcdd";
        int k = 3;

        String uniqueString = "";
        HashSet<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (set.contains(c) == false) {
                set.add(c);
                uniqueString += c;
            }
        }

        selectKLengthWords(0, uniqueString, 0, k, "");

    }

    private static void selectKLengthWords(int i, String uniqueString, int ssf, int totalLength, String asf) {
        if (i == uniqueString.length()) {
            if (ssf == totalLength) {
                System.out.println(asf);
            }
            return;
        }


        // yes call
        if (i < uniqueString.length()) {
            char currentChar = uniqueString.charAt(i);
            selectKLengthWords(i + 1, uniqueString, ssf + 1, totalLength, asf + currentChar);
        }

        // no call
        selectKLengthWords(i + 1, uniqueString, ssf, totalLength, asf);
    }
}
