package dsa.catalogueOrder.foundation.array;

import java.util.Scanner;

public class SubArraysOfArray {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        String[] arr = new String[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.next();
        }
        printSubArrays(arr);
    }

    private static void printSubArrays(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                for (int k = i; k <= j; k++) {
                    System.out.println(arr[k] + "\t");
                }
                System.out.println();
            }
        }
    }
}
