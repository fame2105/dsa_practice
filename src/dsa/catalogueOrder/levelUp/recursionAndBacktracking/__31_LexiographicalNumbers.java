package dsa.catalogueOrder.levelUp.recursionAndBacktracking;

import java.util.Scanner;

public class __31_LexiographicalNumbers {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        for (int i = 1; i < 9; i++) {
            lexicographicNumber(i, n);
        }
    }

    private static void lexicographicNumber(int val, int n) {
        if (val > n) {
            return;
        }

        // print self
        System.out.println(val);

        // print family
        for (int i = 0; i < 10; i++) {
            lexicographicNumber(10 * val + i, n);
        }
    }
}
