package dsa.catalogueOrder.foundation.recursion.recursionWithArrays;

import java.util.Scanner;

public class FindMaxInArray {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        System.out.println(findMaxRecursive(arr, 0));
    }

    private static int findMaxRecursive(int[] arr, int index) {
        if (index == arr.length) {
            return Integer.MIN_VALUE;
        }

        return Math.max(arr[index], findMaxRecursive(arr, index + 1));
    }
}
