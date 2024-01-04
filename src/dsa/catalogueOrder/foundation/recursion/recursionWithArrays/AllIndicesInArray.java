package dsa.catalogueOrder.foundation.recursion.recursionWithArrays;

import java.util.Scanner;

public class AllIndicesInArray {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        int num = s.nextInt(); // no to search for

        for(int val : allIndexesInArray(arr, 0, num, 0)) {
            System.out.print(val + "\t");
        }
    }

    private static int[] allIndexesInArray(int[] arr, int idx, int num, int countOfNum) {
        if(idx == arr.length) {
            return new int[countOfNum];
        }
        int[] numOccuranceIdxs;
        if(num == arr[idx]) {
            numOccuranceIdxs = allIndexesInArray(arr, idx+1, num, ++countOfNum);
            numOccuranceIdxs[countOfNum - 1] = idx;
        } else {
            numOccuranceIdxs = allIndexesInArray(arr, idx+1, num, countOfNum);
        }

        return numOccuranceIdxs;

    }
}
