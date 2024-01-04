package dsa.catalogueOrder.foundation.array;

import dsa.utility.Util;

import java.util.Scanner;

public class RotateAnArray {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.nextInt();
        }

        int k = s.nextInt();

        Util.display(arr, false);
        rotateArray(arr, k);
        Util.display(arr, false);
    }

    private static void reverse(int[] arr, int li, int ri) {
        while (li < ri) {
            int temp = arr[li];
            arr[li] = arr[ri];
            arr[ri] = temp;
            li++;
            ri--;
        }
    }

    private static void rotateArray(int[] arr, int k) {
        k = k % arr.length;
        if(k < 0)
            k += arr.length;
        
        // reverse part 1
        reverse(arr, 0, arr.length - k -1);
        
        // reverse part 2
        reverse(arr, arr.length - k, arr.length - 1);
        
        // reverse all
        reverse(arr, 0, arr.length - 1);
    }
}
