package dsa.catalogueOrder.foundation.timeAndSpace;

import dsa.utility.Util;

import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        bubbleSort(arr);
        Util.display(arr, false);
    }

    private static void bubbleSort(int[] arr) {
        // n-1 iterations for n numbers to be sorted.. since at the end of each iteration, one of the number is placed in its correct position,
        // hence n-1 digits be placed at right position and therefore the nth element is already placed at the correct position

        for (int i = 0; i < arr.length - 1 ; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

}
