package dsa.catalogueOrder.foundation.timeAndSpace;

import dsa.utility.Util;

import java.util.Scanner;

public class RadixSort {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
    }

    private static void radixSort(int[] a) {
        int max = Util.getMaxElementInArray(a);

        int exp = 1;
        while(exp < max) {

        }
    }

    private static int[] countSortStable(int[] a, int min, int max) {
        // Generate frequencyMap
        int[] fmap = new int[max - min + 1];
        for (int i = 0; i < a.length; i++) {
            int value = a[i];
            int index = value - min;
            fmap[index] += 1;
        }

        // Traverse fmap to create PrefixSumArray
        int[] psa = new int[fmap.length];
        psa[0] = fmap[0];
        for (int i = 1; i < fmap.length; i++) {
            int value = fmap[i];
            psa[i] = psa[i - 1] + value;
        }

        int[] newArray = new int[a.length];

        // Traverse original array from back and fill newArray in a stable sorted manner
        for (int i = a.length - 1; i >= 0; i--) {
            int idx = a[i] - min;
            int newIdx = psa[idx] - 1;
            newArray[newIdx] = a[i];
            psa[idx]--;
        }
        return newArray;
    }


}
