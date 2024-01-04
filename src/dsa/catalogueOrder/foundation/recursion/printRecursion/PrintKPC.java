package dsa.catalogueOrder.foundation.recursion.printRecursion;

import java.util.Scanner;

public class PrintKPC {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();

        printKeyPadCombinations(input, "");
    }


    static String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};

    private static void printKeyPadCombinations(String input, String answer) {
        if (input.equals("")) {
            System.out.print(answer + "\t");
            return;
        }

        char c = input.charAt(0);
        int keypadValue = c - '0';
        String ros = input.substring(1);

        String codeAtCurrentChar = codes[keypadValue];
        for (char ch : codeAtCurrentChar.toCharArray()) {
            printKeyPadCombinations(ros, answer + ch);
        }

    }
}
