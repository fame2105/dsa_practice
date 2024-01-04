package dsa.catalogueOrder.foundation.twoDArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpiralTraversal {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        int rows = s.nextInt();
        int cols = s.nextInt();

        int[][] matrix = new int[rows][cols];

        // Taking Input inside Matrix:

        for(int i = 0; i < rows;i++) {
            for(int j = 0; j < cols; j++) {
                matrix[i][j] = s.nextInt();
            }
        }

        List<Integer> list = new ArrayList<>();
        int minRow = 0;
        int minCol = 0;
        int maxRow = matrix.length - 1;
        int maxCol = matrix[0].length - 1;

        int totalElements = (maxRow + 1) * (maxCol + 1);

        while(totalElements > 0) {
            // Top Wall
            for(int r = minRow, c = minCol; c <= maxCol && totalElements > 0; c++) {
                list.add(matrix[r][c]);
                totalElements--;
            }
            minRow++;

            // Right Wall
            for(int r = minRow, c = maxCol; r <= maxRow && totalElements > 0; r++) {
                list.add(matrix[r][c]);
                totalElements--;
            }
            maxCol--;

            // Bottom Wall
            for(int r = maxRow, c = maxCol; c >= minCol && totalElements > 0; c--) {
                list.add(matrix[r][c]);
                totalElements--;
            }
            maxRow--;

            // Left Wall
            for(int r = maxRow, c = minCol; r >= minRow && totalElements > 0; r--) {
                list.add(matrix[r][c]);
                totalElements--;
            }
            minCol++;
        }

        System.out.println(list);
    }
}
