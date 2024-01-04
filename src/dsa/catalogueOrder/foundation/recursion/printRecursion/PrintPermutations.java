package dsa.catalogueOrder.foundation.recursion.printRecursion;

import java.util.Scanner;

public class PrintPermutations {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String input = s.next();
        printPermutations(input, "");
//        System.out.println("hello".substring(0,0));

    }

    private static void printPermutations(String input, String answer) {
        if(input.isEmpty()) {
            System.out.print(answer + "\t");
            return;
        }

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            String ros = input.substring(0, i) + input.substring(i+1);
            printPermutations(ros, answer + c);
        }
    }
}
