package dsa.catalogueOrder.foundation.recursion.backtracking;

import java.util.Scanner;

public class TargetSumSubset {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n  = s.nextInt();
        int[] arr = new int[n];

        /**
         TestCase 1 :
         input:
         5
         10
         20
         30
         40
         50
         60

         output:
         10	20	30
         10	50
         20	40
         */

        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        int targetSum = s.nextInt();

        printTargetSumSubsets(arr, targetSum, 0, 0, "");
    }

    private static void printTargetSumSubsets(int[] arr, int targetSum, int idx, int sumSoFar, String set) {
        if(idx == arr.length) {
            if(sumSoFar == targetSum) {
                System.out.println(set);
            }
            return;
        }

        int currentNum = arr[idx];
        printTargetSumSubsets(arr,targetSum,idx + 1, sumSoFar + arr[idx], set + arr[idx] + ",");
        printTargetSumSubsets(arr,targetSum,idx + 1, sumSoFar, set);

    }
}
