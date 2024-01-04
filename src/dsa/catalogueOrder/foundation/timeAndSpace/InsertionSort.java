package dsa.catalogueOrder.foundation.timeAndSpace;

import dsa.utility.Util;

import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        insertionSort(arr);
        Util.display(arr, false);

    }

    private static void insertionSort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int current = arr[i];
            int j = i-1;
            while(j >= 0 && arr[j] > current) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = current;
        }
    }
}
