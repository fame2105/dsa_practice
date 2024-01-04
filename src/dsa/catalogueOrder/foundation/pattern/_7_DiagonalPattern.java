package dsa.catalogueOrder.foundation.pattern;

import java.util.Scanner;

public class _7_DiagonalPattern {

    // Method 1
    /*public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        // n should always be odd and >= 3 for this pepcoding.foundation.pattern.
        int n = s.nextInt();

        int space = 0;
        for (int i = 1; i <= n; i++) {
            // print spaces
            for (int j = 1; j <= space; j++) {
                System.out.print("\t");
            }
                space++;
            // print star
            System.out.print("*");
            System.out.println();
        }
    }*/

    // Method 2
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        // n should always be odd and >= 3 for this pepcoding.foundation.pattern.
        int n = s.nextInt();

        for (int i = 1; i <= n; i++) {
            // print spaces
            for (int j = 1; j <= n; j++) {
                if (i == j) {
                    System.out.print("*");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
}
