package dsa.catalogueOrder.foundation.twoDArray;

import java.util.Scanner;

public class SearchInSorted2DArray {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = s.nextInt();
            }
        }
        int value = s.nextInt();
        searchIn2DSortedArray(a, value);
    }

    private static void searchIn2DSortedArray(int[][] a, int value) {
        boolean flag = false;
        int answerRow = 0;
        int answerColumn = 0;
        for (int i = 0; i < a.length; i++) {
            int rMin = a[i][0];
            int rMax = a[i][a[0].length - 1];
            if (value >= rMin && value <= rMax) {
                int searchResult = binarySearch(a[i], value);
                if (searchResult != -1) {
                    flag = true;
                    answerRow = i;
                    answerColumn = searchResult;
                    break;
                }
            }
        }
        if (flag) {
            System.out.println(answerRow);
            System.out.println(answerColumn);
        } else {
            System.out.println("Not found");
        }
    }

    private static int binarySearch(int[] a, int value) {
        int l = 0;
        int r = a.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (value < a[mid]) {
                r = mid - 1;
            } else if (value > a[mid]) {
                l = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    // more efficient
    private static void searchIn2DSortedArray2(int[][] a, int value) {
        int row = a.length - 1;
        int column = 0;
        while (row > 0 && column < a[0].length) {
            if (a[row][column] == value) {
                System.out.println(row);
                System.out.println(column);
                return;
            } else if (value < a[row][column]) {
                row--;
            } else {
                column++;
            }
        }
        System.out.println("Not Found");
    }
}
