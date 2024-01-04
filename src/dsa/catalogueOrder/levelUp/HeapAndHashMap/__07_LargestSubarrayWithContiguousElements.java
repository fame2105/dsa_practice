package dsa.catalogueOrder.levelUp.HeapAndHashMap;

import java.util.HashSet;

public class __07_LargestSubarrayWithContiguousElements {

    public static int lengthOfLargestSubarrayWithContiguousElements(int[] arr) {
        int maxLength = 1; // base case, if array contains a single element then it will be considered contiguous

        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int max = arr[i];

            HashSet<Integer> checkDuplicate = new HashSet<>();
            checkDuplicate.add(arr[i]);

            for (int j = i + 1; j < arr.length; j++) {
                if (checkDuplicate.contains(arr[j])) {
                    break;
                }

                checkDuplicate.add(arr[j]);
                min = Math.min(min, arr[j]);
                max = Math.max(max, arr[j]);

                if (max - min == j - i) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }
        return maxLength;
    }
}
