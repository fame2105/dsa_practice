package dsa.catalogueOrder.foundation.twoDArray;

import java.util.Scanner;

public class RingRotate {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        int r = s.nextInt();
        int c = s.nextInt();

        int[][] a = new int[r][c];

        // Taking Input inside Matrix:

        for(int i = 0; i < r;i++) {
            for(int j = 0; j < c; j++) {
                a[i][j] = s.nextInt();
            }
        }

        // input shell nos
        int shell = s.nextInt();

        // input rotation nos
        int rotations = s.nextInt();

        ringRotate(a, shell, rotations);
        display(a);
    }

    public static void ringRotate(int[][] a, int s, int r) {
        // fill 1D from 2-D array
        int[] la = fill1DArray(a, s);


        // rotate 1-D array
        rotateArray(la, r);


        // fill2DArray(a, la, s);
        fill2DArray(a, la, s);

    }

    public static int[] fill1DArray(int[][] a, int s) {

        int minRow = s-1;
        int maxRow = a.length - s;
        int minCol = s-1;
        int maxCol = a[0].length - s;

        int size = 2 * (maxRow - minRow + maxCol - minCol);
        int[] la = new int[size];

        int index = 0;

        // left boundary
        for(int i = minRow, j=minCol; i<=maxRow; i++) {
            la[index++] = a[i][j];
        }
        minCol++;

        // bottom boundary
        for(int i = maxRow, j=minCol; j<=maxCol; j++) {
            la[index++] = a[i][j];
        }
        maxRow--;

        // Right boundary
        for(int i = maxRow, j=maxCol; i>=minRow; i--) {
            la[index++] = a[i][j];
        }
        maxCol--;

        // top boundary
        for(int i = minRow, j = maxCol; j>=minCol; j--) {
            la[index++] = a[i][j];
        }
        minRow++;

        return la;
    }

    public static void fill2DArray(int[][] a, int[] la, int s) {
        int minRow = s-1;
        int maxRow = a.length - s;
        int minCol = s-1;
        int maxCol = a[0].length - s;

        int index = 0;

        // left boundary
        for(int i = minRow, j=minCol; i<=maxRow; i++) {
            a[i][j] = la[index++];
        }
        minCol++;

        // bottom boundary
        for(int i = maxRow, j=minCol; j<=maxCol; j++) {
            a[i][j] = la[index++];
        }
        maxRow--;

        // Right boundary
        for(int i = maxRow, j=maxCol; i>=minRow; i--) {
            a[i][j] = la[index++];
        }
        maxCol--;

        // top boundary
        for(int i = minRow, j = maxCol; j>=minCol; j--) {
            a[i][j] = la[index++];
        }
        minRow++;
    }

    public static void rotateArray(int[] a, int r) {
        r = r % a.length;
        if(r < 0) {
            r = r + a.length;
        }

        // reverse complete array
        reverse(a, 0, a.length - 1);

        reverse(a, 0, r-1);

        reverse(a, r, a.length-1);
    }

    public static void reverse(int[] a, int l, int r) {
        while(l < r) {
            int temp = a[l];
            a[l] = a[r];
            a[r] = temp;

            l++;
            r--;
        }
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
