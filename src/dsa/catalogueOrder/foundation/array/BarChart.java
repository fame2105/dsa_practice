package dsa.catalogueOrder.foundation.array;

import java.util.Scanner;

public class BarChart {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = s.nextInt();
        }

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i])
                max = arr[i];
        }

        for (int i = max; i >= 1; i--) {
            for (int j = 0; j < arr.length; j++) {
                if(arr[j] >= i) {
                    System.out.print("* \t");
                } else {
                    System.out.print("\t");
                }
            }
            System.out.println();
        }
    }
}
