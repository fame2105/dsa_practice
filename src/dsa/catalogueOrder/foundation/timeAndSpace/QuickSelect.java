package dsa.catalogueOrder.foundation.timeAndSpace;

import java.util.Scanner;

// This problem demands that we get kth smallest element from the

public class QuickSelect {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        int k = s.nextInt();
//        System.out.println(arr[quickSelect2(arr, 0, arr.length - 1, k - 1)]);
        System.out.println(quickSelect(arr, 0, arr.length - 1, k - 1));

    }

    // find kth smallest element.
    //kth smallest element will lie at (k-1)th index in a sorted array.
    private static int quickSelect(int[] arr, int lo, int hi, int k) {
        int pivot = arr[hi];
        int pivotIndex = partition(arr, lo, hi, pivot);
        if (pivotIndex > k) {
            // search again in the left half
            return quickSelect(arr, lo, pivotIndex - 1, k);
        } else if(k < pivotIndex) {
            // search again in the right half
            return quickSelect(arr, pivotIndex + 1, hi, k);
        } else {
            return pivot;
        }
    }


    private static int partition(int[] arr, int lo, int hi, int pivot) {
        int i = lo;
        int j = lo;
        while (i <= hi) {
            if (arr[i] > pivot) {
                i++;
            } else {
//                swap i and j in array
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j++;
            }
        }
        return j - 1;
    }

    public static int quickSelect2(int[] arr, int lo, int hi, int k) {
        int pi = partition(arr, lo, hi, arr[hi]);
        int ans = 0;

        if(pi == k) {
            ans = pi;
        } else if(pi <  k) {
            // search in right of pi
            ans = quickSelect2(arr, pi + 1, hi, k);
        } else {
            // search in left of pi
            ans = quickSelect2(arr, lo, pi - 1, k);
        }

        return ans;
    }
}
