package dsa.catalogueOrder.foundation.pattern;

import java.util.Scanner;

public class RhombusPattern {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int outerSpace = n / 2;
        int innerSpace = -1;

        for (int i = 1; i <= n; i++) {
            // print outer spaces
            for (int j = 1; j <= outerSpace; j++) {
                System.out.print("\t");
            }

            // print star
            System.out.print("*\t");

            // print inner space
            for (int j = 1; j <= innerSpace; j++) {
                System.out.print("\t");
            }

            // print star -> this condition exists because 1st and last row will always have only 1 star
            if (i > 1 && i < n)
                System.out.print("*\t");


            if (i <= n / 2) {
                outerSpace--;
                innerSpace += 2;
            } else {
                outerSpace++;
                innerSpace -= 2;
            }
            System.out.println();
        }
    }
}
