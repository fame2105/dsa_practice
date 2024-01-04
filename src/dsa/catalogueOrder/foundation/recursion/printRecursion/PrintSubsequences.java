package dsa.catalogueOrder.foundation.recursion.printRecursion;

import java.util.Scanner;

public class PrintSubsequences {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();

        printSubsequences(input, "");
    }

    private static void printSubsequences(String input, String answer) {
        if(input.equals("")) {
            System.out.println(answer);
            return;
        }

        char currentChar = input.charAt(0);
        String restOfString = input.substring(1);
        printSubsequences(restOfString, answer + "");
        printSubsequences(restOfString, answer + currentChar);
    }
}
