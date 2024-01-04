package dsa.catalogueOrder.foundation.timeAndSpace;

import dsa.utility.Util;

import java.util.Scanner;

public class Sort01 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }

        /*Util.display(a, false);
        sort01(a);
        Util.display(a, false);*/

        Util.display(a, false);
        sort012(a);
        Util.display(a, false);

        /*Util.display(a, false);
        segreggateOddEven1(a);
        Util.display(a, false);*/

        /*Util.display(a, false);
        segreggateOddEven2(a);
        Util.display(a, false);*/
    }

    private static void sort01(int[] a) {
        int i = 0;
        int j = 0;
        while (i < a.length) {
            if (a[i] == 1) {
                i++;
            } else {
                swap(a, i, j);
                i++;
                j++;
            }
        }
    }

    private static void sort012(int[] a) {
        int i = 0; // first unsolved
        int j = 0; // first 1
        int k = a.length - 1; // last unsolved
        while (i <= k) {
            if (a[i] == 1) {
                i++;
            } else if (a[i] == 0) {
                swap(a, i, j);
                i++;
                j++;
            } else {
                swap(a, i, k);
                k--;
            }
        }
    }

    // in this version of implementation the order of odd numbers is maintained only.
    private static void segreggateOddEven1(int[] a) {
        int i = 0;
        int j = 0;
        while (i < a.length) {
            if (a[i] % 2 == 0) {
                i++;
            } else {
                swap(a, i, j);
                i++;
                j++;
            }
        }
    }

    // in this version of implementation the order of even numbers is maintained only .
    private static void segreggateOddEven2(int[] a) {
        int i = 0;
        int j = 0;
        while (i < a.length) {
            if (a[i] % 2 == 0) {
                i++;
            } else {
                swap(a, i, j);
                i++;
                j++;
            }
        }
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
