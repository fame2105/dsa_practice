package dsa.catalogueOrder.levelUp.arraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _23TwoSumTargetSumUniquePairs {
    public static List<List<Integer>> twoSum(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> uniquePairs = new ArrayList<>();
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (left != 0 && arr[left] == arr[left - 1]) {
                left++;
                continue;
            }
            if (arr[left] + arr[right] == target) {
                List<Integer> pair = new ArrayList<>();
                pair.add(arr[left]);
                pair.add(arr[right]);
                uniquePairs.add(pair);
                left++;
                right--;
            } else if (arr[left] + arr[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return uniquePairs;
    }
}
