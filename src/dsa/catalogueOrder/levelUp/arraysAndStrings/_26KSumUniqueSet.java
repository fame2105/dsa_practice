package dsa.catalogueOrder.levelUp.arraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _26KSumUniqueSet {
    public static void main(String[] args) {
        int[] arr = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = kSum(arr, 0, 3);
        System.out.println(result);
    }

    public static List<List<Integer>> kSum(int[] arr, int target, int k) {
        Arrays.sort(arr);
        return kSumHelper(arr, target, k, 0);
    }

    private static List<List<Integer>> kSumHelper(int[] arr, int target, int k, int startIndex) {
        if (k == 2) { // base case
            return twoSum(arr, target, startIndex);
        }

        int n = arr.length;
        List<List<Integer>> kSumSet = new ArrayList<>();
        if (n - startIndex < k) { // k is larger than the effective number of elements in the array
            return kSumSet;
        }

        for (int i = startIndex; i <= n - k; i++) {
            if (i > startIndex && arr[i] == arr[i - 1])
                continue;

            int val1 = arr[i];
            List<List<Integer>> subResult = kSumHelper(arr, target - val1, k - 1, i + 1);

            for (List<Integer> list : subResult) {
                list.add(val1);
                kSumSet.add(list);
            }
        }
        return kSumSet;
    }

    private static List<List<Integer>> twoSum(int[] arr, int target, int startIndex) {
        int n = arr.length;
        List<List<Integer>> uniqueTwoSumPairs = new ArrayList<>();
        if (n - startIndex < 2) {
            return uniqueTwoSumPairs;
        }

        int left = startIndex;
        int right = arr.length - 1;

        while (left < right) {
            if (left > startIndex && arr[left] == arr[left - 1]) {
                left++;
                continue;
            }

            int sum = arr[left] + arr[right];
            if (sum == target) {
                List<Integer> pair = new ArrayList<>();
                pair.add(arr[left]);
                pair.add(arr[right]);
                uniqueTwoSumPairs.add(pair);

                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return uniqueTwoSumPairs;
    }
}
