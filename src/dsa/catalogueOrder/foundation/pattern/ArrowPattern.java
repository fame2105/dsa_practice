package dsa.catalogueOrder.foundation.pattern;

import java.util.Scanner;

// assume that always odd number will be given
public class ArrowPattern {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int space = n / 2;
        int star = 1;

        for (int i = 1; i <= n; i++) {
            // print spaces
            for (int j = 1; j <= space; j++) {
                if (i == n / 2 + 1) {
                    System.out.print("*\t");
                } else {
                    System.out.print("\t");
                }
            }

            for (int j = 1; j <= star; j++) {
                System.out.print("*\t");
            }


            if (i <= n / 2) {
                star++;
            } else {
                star--;
            }
            System.out.println();

        }
    }
}
