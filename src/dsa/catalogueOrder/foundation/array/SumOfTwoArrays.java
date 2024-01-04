package dsa.catalogueOrder.foundation.array;

import java.util.Scanner;

public class SumOfTwoArrays {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n1 = s.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = s.nextInt();
        }

        int n2 = s.nextInt();
        int[] arr2 = new int[n2];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = s.nextInt();
        }

        int n3 = n1 > n2 ? n1 : n2;
        int[] result = new int[n3];

        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int k = result.length - 1;
        int carry = 0;

        while (k >= 0) {
            int digit1 = 0;
            if (i >= 0) {
                digit1 = arr1[i];
            }
            int digit2 = 0;
            if (j >= 0) {
                digit2 = arr2[j];
            }

            int sum = digit1 + digit2 + carry;
            result[k] = sum % 10;
            carry = sum / 10;

            i--;
            j--;
            k--;
        }

        if (carry != 0) {
            System.out.print(carry);
        }
        for (int l = 0; l < result.length; l++) {
            System.out.print(result[l]);
        }
    }
}
