package dsa.catalogueOrder.foundation.pattern;

import java.util.Scanner;

public class _12_FibonacciTriangle {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int counter = 1;
        int a = 0;
        int b = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(a + "\t");
                int c = a + b;
                a = b;
                b = c;
            }

            System.out.println();
//            counter++;
        }
    }
}

