package dsa.catalogueOrder.foundation.stackAndQueue;

import java.util.Scanner;

//Leetcode 85
public class MaximalRectangle {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
    }

    private int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[] a = new int[matrix[0].length];
        int res = 0;

        for(int i = 0; i< matrix.length; i++) {
            // prepare array for largest area histogram
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == '0') {
                    a[j] = 0;
                } else {
                    a[j] += matrix[i][j] - '0';
                }
            }
            res = Math.max(res, LargestAreaHistogram.largestAreaHistogram(a));
        }
        return res;
    }
}
