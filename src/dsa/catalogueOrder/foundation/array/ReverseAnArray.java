package dsa.catalogueOrder.foundation.array;

import dsa.utility.Util;

import java.util.Scanner;

// Reverse the input pepcoding.foundation.array in single pass and using no extra memory
public class ReverseAnArray {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.nextInt();
        }
        Util.display(arr, false);
        reverse(arr);
        Util.display(arr, false);

    }

    private static void reverse(int[] arr) {
        for (int i = 0, j = arr.length-1; i<=j; i++, j--) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

}
