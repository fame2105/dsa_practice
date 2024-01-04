package dsa.catalogueOrder.foundation.array;

import java.util.Scanner;

public class CeilAndFloor {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++)
            arr[i] = s.nextInt();

        int k = s.nextInt();

        ceilAndFloor(arr, k);
    }

    private static void ceilAndFloor(int[] arr, int data) {
        int floor = Integer.MIN_VALUE;
        int ceil = Integer.MAX_VALUE;

        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (data < arr[mid]) {
                hi = mid - 1;
                ceil = arr[mid];
            } else if (data > arr[mid]) {
                lo = mid + 1;
                floor = arr[mid];
            } else {
                ceil = arr[mid];
                floor = arr[mid];
                break;
            }
        }
        System.out.println("Ceil = " + ceil);
        System.out.println("Floor = " + floor);
    }
}
