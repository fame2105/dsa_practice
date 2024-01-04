package dsa.catalogueOrder.foundation.string;

import java.util.Scanner;

public class StringWithAsciiDifferenceOfConsecutiveCharacters {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        System.out.println(stringWithAsciiDifferenceOfConsecutiveCharacters(input));
    }

    private static String stringWithAsciiDifferenceOfConsecutiveCharacters(String str) {
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < str.length() - 1; i++) {
            char current = str.charAt(i);
            char next = str.charAt(i+1);
            sb.append(current);
            sb.append(next - current);
        }
        sb.append(str.charAt(str.length() - 1));
        return sb.toString();
    }
}
