package dsa.catalogueOrder.foundation.timeAndSpace;

import dsa.utility.Util;

import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < 5; i++) {
            arr[i] = s.nextInt();
        }

        Util.display(mergeSort(arr, 0, arr.length - 1), false);

    }

    private static int[] mergeSort(int[] arr, int begin, int end) {
        if (begin == end) {
            int[] a = new int[1];
            a[0] = arr[begin];
            return a;
        }

        int mid = (begin + end) / 2;
        int[] firstHalfSorted = mergeSort(arr, begin, mid);
        int[] secondHalfSorted = mergeSort(arr, mid + 1, end);
        int[] fullSortedArray = mergeTwoSortedArrays(firstHalfSorted, secondHalfSorted);
        return fullSortedArray;
    }

    private static int[] mergeTwoSortedArrays(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];

        int i = 0;
        int j = 0;
        int k = 0;
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                result[k++] = a[i++];
            } else {
                result[k++] = b[j++];
            }
        }

        while (j < b.length) {
            result[k++] = b[j++];
        }

        while (i < a.length) {
            result[k++] = a[i++];
        }
        return result;
    }
}
