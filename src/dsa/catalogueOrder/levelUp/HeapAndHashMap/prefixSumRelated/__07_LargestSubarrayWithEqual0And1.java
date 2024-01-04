package dsa.catalogueOrder.levelUp.HeapAndHashMap.prefixSumRelated;

import java.util.HashMap;
import java.util.Map;

public class __07_LargestSubarrayWithEqual0And1 {
    public static int findMaxLength(int[] arr) {
         // Treat 0's as -1 and 1's as 1.
        // Now maintain hashMap of prefixSum:idx
        // now the entire question has changed to finding longest subarray of sum=0 ... like question no : __05
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // prefixSum:idx
        int ans = 0;
        int prefixSum = 0;
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            num = num == 0 ? -1 : num; // treat 0 as 1
            prefixSum += num;

            if (map.containsKey(prefixSum)) {
                int prevIdx = map.get(prefixSum);
                int len = i - prevIdx;
                ans = Math.max(ans, len);
            } else {
                map.put(prefixSum, i);
            }
        }

        return ans;
    }
}
