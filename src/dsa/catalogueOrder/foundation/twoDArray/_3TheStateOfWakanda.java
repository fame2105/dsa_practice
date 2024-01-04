package dsa.catalogueOrder.foundation.twoDArray;

import java.util.Scanner;

public class _3TheStateOfWakanda {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int rows = s.nextInt();
        int cols = s.nextInt();

        int[][] matrix = new int[rows][cols];

        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[rows][cols] = s.nextInt();
            }
        }

        for (int i = 0; i < cols; i++) {
            if(i % 2 == 0) {
                for (int j = 0; j < rows; j++) {
                    System.out.println(matrix[i][j]);
                }
            } else {
                for (int j = rows-1; j >= 0; j--) {
                    System.out.println(matrix[i][j]);
                }
            }
        }
    }
}
