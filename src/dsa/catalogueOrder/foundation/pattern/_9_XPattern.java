package dsa.catalogueOrder.foundation.pattern;

import java.util.Scanner;

public class _9_XPattern {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        for (int i = 1; i <= n; i++) {
            // print spaces
            for (int j = 1; j <= n; j++) {
                if ((i + j == n + 1) || (i == j)) {
                    System.out.print("*\t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
}
