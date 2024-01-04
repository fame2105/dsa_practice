package dsa.catalogueOrder.foundation.recursion.basics;

import java.util.Scanner;

public class PrintIncreasing {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        printIncreasing(n);
    }

    private static void printIncreasing(int n) {
        if(n < 1) {
            return;
        }
        printIncreasing(n-1);
        System.out.println((n));
    }
}
