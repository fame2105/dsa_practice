package dsa.catalogueOrder.levelUp.searchingAndSorting;

import java.util.Scanner;

import dsa.catalogueOrder.foundation.timeAndSpace.MergeSort;

public class __17_FindInversionCount {
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.nextInt();
        }

        mergeSort(arr, 0, n - 1);
        System.out.println(inversionCount);
        s.close();
    }

    private static int[] mergeSort(int[] arr, int lo, int hi) {
        if (lo == hi) {
            int[] base = new int[1];
            base[0] = arr[lo];
            return base;
        }

        int mid = (lo + hi) / 2;

        int[] left = mergeSort(arr, lo, mid);
        int[] right = mergeSort(arr, mid + 1, hi);

        return merge(left, right);
    }

    private static int inversionCount = 0;
    private static int[] merge(int[] left, int[] right) {
        int i = 0;
        int j = 0;
        int k = 0;
        int[] ans = new int[left.length + right.length];

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                ans[k] = left[i];
                i++;
                k++;
            } else if (left[i] > right[j]) {
                inversionCount += left.length - i;
                ans[k] = right[j];
                j++;
                k++;
            }
        }

        while (i < left.length) {
            ans[k] = left[i];
            i++;
            k++;
        }

        while (j < right.length) {
            ans[k] = right[j];
            j++;
            k++;
        }

        return ans;
    }
}
