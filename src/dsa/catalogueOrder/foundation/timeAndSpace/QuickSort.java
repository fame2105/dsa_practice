package dsa.catalogueOrder.foundation.timeAndSpace;

import dsa.utility.Util;

import java.util.Scanner;

public class QuickSort {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        quickSort(arr, 0, arr.length - 1);
        System.out.println( " \n Sorted Array -> ");

        Util.display(arr, false);
    }

    private static void quickSort(int[] arr, int lo, int hi) {
        // base case occurs when there is only single element sent to be sorted
        if (lo >= hi) {
            return;
        }

        int pivot = arr[hi];
        int pivotIndex = partition(arr, lo, hi, pivot);
        quickSort(arr, lo, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, hi);
    }


    // patitioning allows the pivot element to be placed at a position as it would be placed in a sorted array
    // therefore -> whenever partioning procedure is ran, the pivot element gets sorted.
    private static int partition(int[] arr, int lo, int hi, int pivot) {
        int i = lo;
        int j = lo;
        while (i <= hi) {
            if (arr[i] > pivot) {
                i++;
            } else {
                // swap ith element with jth element
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;

                // increment i and j both
                i++;
                j++;
            }
        }
        System.out.println("pivot index -> " + (j - 1));
        return j - 1;
    }


}
