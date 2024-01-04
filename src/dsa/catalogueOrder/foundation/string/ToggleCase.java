package dsa.catalogueOrder.foundation.string;

import java.util.Scanner;

public class ToggleCase {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String input = s.nextLine();

        System.out.println(toggleCase(input));
    }

    private static String toggleCase(String str) {
        StringBuilder sb = new StringBuilder(str);

        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c >= 'a' && c <= 'z') {
                char upperCase = (char) (c - 'a' + 'A');
                sb.setCharAt(i, upperCase);
            } else if(c >= 'A' && c <= 'Z'){
                char lowerCase = (char) (c - 'A' + 'a');
                sb.setCharAt(i, lowerCase);
            }
        }

        return sb.toString();
    }
}
