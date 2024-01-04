package dsa.catalogueOrder.foundation.timeAndSpace;

import dsa.utility.Util;

import java.util.Scanner;

// a sort is unstable if the duplicated elements are not naturally ordered as in the given original array
public class UnstableCountSort {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = Util.takeInputAndReturnArray(s, n);
        int max = Util.getMaxElementInArray(a);
        int min = Util.getMinxElementInArray(a);
        countSortUnstable(a, min, max);
        Util.display(a, false);
    }

    private static void countSortUnstable(int[] a, int min, int max) {
        // Generate frequencyMap
        int[] fmap = new int[max - min + 1];
        for (int i = 0; i < a.length; i++) {
            int value = a[i];
            int index = value - min;
            fmap[index] += 1;
        }

        int index = 0;
        for (int i = 0; i < fmap.length; i++) {
            int fq = fmap[i];
            int value = i + min;

            for (int j = 0; j < fq; j++) {
                a[index] = value;
                index++;
            }
        }
    }

}
