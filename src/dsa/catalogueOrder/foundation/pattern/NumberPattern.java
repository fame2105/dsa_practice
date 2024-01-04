package dsa.catalogueOrder.foundation.pattern;

import java.util.Scanner;

public class NumberPattern {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int space = 2*n - 3;
        for (int i = 1; i <= n ; i++) {
            // print num
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "\t");
            }

            // print spaces
            for (int j = 1; j <= space ; j++) {
                System.out.print("\t");
            }

            // print num
            int val = i;
            int j=1;
            if(i == n) {
                j = 2;
                val--;
            }
            for (; j <= i; j++) {
                System.out.print(val-- + "\t");
            }


            space -= 2;
            System.out.println();

        }

    }
}
