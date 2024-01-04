package dsa.catalogueOrder.foundation.timeAndSpace;

import dsa.utility.Util;

import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        selectionSort(arr);
        Util.display(arr, false);

    }

    private static void selectionSort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int minSoFar = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minSoFar]) {
                    minSoFar = j;
                }
            }
            // swapping ith element with minSoFar
            int temp = arr[i];
            arr[i] = arr[minSoFar];
            arr[minSoFar] = temp;
        }
    }
}
