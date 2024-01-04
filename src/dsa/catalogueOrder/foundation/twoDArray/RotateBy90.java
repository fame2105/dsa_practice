package dsa.catalogueOrder.foundation.twoDArray;

import java.util.Scanner;

public class RotateBy90 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] a = new int[n][n];

        // Taking Input inside Matrix:
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = s.nextInt();
            }
        }

        display(a);
        System.out.println("---------------");
        rotate90Clockwise(a);
    }

    private static void transposeMatrix(int[][] a) {

        // transpose matrix
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a[0].length; j++) {
                int temp = a[i][j];
                a[i][j] = a[j][i];
                a[j][i] = temp;
            }
        }
    }

    public int[][] transpose(int[][] A) { // we need additional space for a new matrix if for given matrix rows != columns
        int rows = A.length;
        int columns = A[0].length;
        int[][] ATranspose = new int[columns][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                ATranspose[j][i] = A[i][j];
            }
        }
        return ATranspose;
    }

    private static void rotate90Clockwise(int[][] a) {
        transposeMatrix(a);
       // Reverse Columns by reversing the elements of rows
        for (int i = 0; i < a.length; i++) {
            int l = 0;
            int r = a[0].length - 1;
            while(l < r) {
                int temp = a[i][l];
                a[i][l] = a[i][r];
                a[i][r] = temp;
                l++;
                r--;
            }
        }
        display(a);
    }

    private static void rotate90AntiClockwise(int[][] a) {
        transposeMatrix(a);
       // Reverse Columns by reversing the elements of rows
        for (int column = 0; column < a[0].length; column++) {
            int l = 0;
            int r = a.length - 1;
            while(l < r) {
                int temp = a[l][column];
                a[l][column] = a[r][column];
                a[r][column] = temp;
                l++;
                r--;
            }
        }
        display(a);
    }

    public static void display(int[][] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[0].length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}


