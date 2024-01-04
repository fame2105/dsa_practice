package dsa.catalogueOrder.foundation.string;

import java.util.Scanner;

public class PalindromicSubstrings {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        printPalindromicStrings(input);
    }

    private static void printPalindromicStrings(String input) {
        // Generate all substrings
        for (int i = 0; i < input.length(); i++) {
            for (int j = i; j < input.length(); j++) {
                String substring = input.substring(i, j);
                if (isPalindrome(substring)) {
                    System.out.println(substring);
                }
            }
        }
    }

    private static boolean isPalindrome(String str) {
        int i = 0;
        int j = str.length() - 1;

        while (i <= j) {
            char ch1 = str.charAt(i++);
            char ch2 = str.charAt(j--);

            if (ch1 != ch2) {
                return false;
            }
        }

        return true;
    }
}
