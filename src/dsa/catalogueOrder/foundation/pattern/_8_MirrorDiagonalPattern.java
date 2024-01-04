package dsa.catalogueOrder.foundation.pattern;

import java.util.Scanner;

public class _8_MirrorDiagonalPattern {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        for (int i = 1; i <= n; i++) {
            // print spaces
            for (int j = 1; j <= n; j++) {
                if (i + j == n + 1) {
                    System.out.print("*");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
}
