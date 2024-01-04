package dsa.catalogueOrder.foundation.recursion.recursionWithArrays;

import java.util.Scanner;

public class FindIndexFirstOccurance {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        int num = s.nextInt(); // no to search for
        System.out.println(findIndexFirstOccurence(arr, 0, num));
    }

    private static int findIndexFirstOccurence(int[] arr, int index, int num) {
        if (index == arr.length) {
            return -1;
        }

        if (num == arr[index]) {
            return index;
        } else {
            return findIndexFirstOccurence(arr, index + 1, num);
        }
    }
}
