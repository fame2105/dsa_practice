package dsa.catalogueOrder.foundation.twoDArray;

import java.util.Scanner;

public class MatrixMultiplication {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int m1 = s.nextInt();
        int n1 = s.nextInt();

        int[][] a = new int[m1][n1];

        // take input for 1st matrix
        for (int i = 0; i < m1; i++) {
            for (int j = 0; j < n1; j++) {
                a[i][j] = s.nextInt();
            }
        }

        int m2 = s.nextInt();
        int n2 = s.nextInt();

        int[][] b = new int[m2][n2];
        // take input for 1st matrix
        for (int i = 0; i < m2; i++) {
            for (int j = 0; j < n2; j++) {
                b[i][j] = s.nextInt();
            }
        }

        if(n1 != m2) {
            System.out.println("Invalid input");
            return;
        }

        int[][] c = new int[m1][n2];

        // c.length = m1 = row length of 1st matrix
        for (int i = 0; i < c.length; i++) {

            // c[0].length = n2 = column count of 2nd matrix
            for (int j = 0; j < c[0].length; j++) {
                // this inner loop runs n1 or m2 number of times since both n1 and m2 are equal
                for (int k = 0; k < n1; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        // Display the product pepcoding.foundation.array
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[0].length; j++) {
                System.out.print(c[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
