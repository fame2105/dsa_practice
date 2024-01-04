package dsa.catalogueOrder.foundation.recursion.basics;

import java.util.Scanner;

public class PrintIncreasingDecreasing {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        printDecreasingIncreasing(n);
    }

    private static void printDecreasingIncreasing(int n) {
        if (n < 1) {
            return;
        }

        System.out.println(n);
        printDecreasingIncreasing(n-1);
        System.out.println(n);
    }
}
