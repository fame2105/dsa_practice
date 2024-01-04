package dsa.catalogueOrder.levelUp.HeapAndHashMap.prefixSumRelated;

import java.util.HashMap;

public class __05_LargestSubArrayWithZeroSum {

    public int largestSubArrayWithZeroSum(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>(); //prefixSum:index
        map.put(0, -1); // if prefix sum comes up as zero then we need this position to get the length of the array
        int sum = 0;
        int maxLength = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(map.containsKey(sum)) {
                // do not put the new position of (sum : idx) because we want the largest subarray of sum 0
                // entering a new position of the same sum will shorten the length of the result if the same sum is encountered again during traversal
                int prevPos = map.get(sum);
                maxLength = Math.max(maxLength, i - prevPos);
            } else {
                map.put(sum, i);
            }
        }

        return maxLength;
    }
}
