package dsa.catalogueOrder.foundation.recursion.recursionWithArrays;

import java.util.Scanner;

public class LastIndexOccurence {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        int num = s.nextInt(); // no to search for
        System.out.println(lastIndexOccurence(arr, 0, num));
    }

    private static int lastIndexOccurence(int[] arr, int index, int num) {
        if (index == arr.length - 1) {
            if (num == arr[index]) {
                return index;
            } else {
                return -1;
            }
        }

        int loi = lastIndexOccurence(arr, index + 1, num);
        if (loi == -1) {
            if (num == arr[index]) {
                return index;
            } else {
                return -1;
            }
        } else {
            return loi;
        }
    }
}
