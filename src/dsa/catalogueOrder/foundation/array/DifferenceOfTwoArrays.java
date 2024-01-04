package dsa.catalogueOrder.foundation.array;

import java.util.Scanner;

public class DifferenceOfTwoArrays {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n1 = s.nextInt();
        int[] arr1 = new int[n1];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = s.nextInt();
        }

        //Question Assumption: number formed by arr2 > arr1
        int n2 = s.nextInt();
        int[] arr2 = new int[n2];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = s.nextInt();
        }

        int[] result = new int[n2];

        int i = arr1.length - 1;
        int j = arr2.length - 1;
        int k = result.length - 1;
        int carry = 0;

        while(k >= 0) {
            int digit1 = 0;
            if (i >= 0) {
                digit1 = arr1[i];
            }
            int digit2 = 0;
            if (j >= 0) {
                digit2 = arr2[j];
                digit2 += carry;
            }

            if(digit2 < digit1) {
                digit2 += 10;
                carry = -1;
            }
            int difference = digit2 - digit1;
            result[k] = difference;

            i--;
            j--;
            k--;
        }

        // we do not want to print leading zeros in the result.
        // processing idx to find out first non-zero term index.
        int idx = 0;
        while(idx < result.length) {
            if(result[idx] == 0)
                idx++;
            else
                break;
        }

        // print resultant array values from idx to array.length
        for(int l = idx; l < result.length; l++) {
            System.out.println(result[l]);
        }

        // if idx == arr.length-1 then resultant array contained 0 as output since both arr1 and arr2 contained same numbers -> hence 0 output.
        if(idx == result.length) {
            System.out.println(0);
        }
    }
}
