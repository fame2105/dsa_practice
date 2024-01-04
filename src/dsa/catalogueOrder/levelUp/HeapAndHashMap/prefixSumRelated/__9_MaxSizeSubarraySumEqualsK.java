package dsa.catalogueOrder.levelUp.HeapAndHashMap.prefixSumRelated;

import java.util.HashMap;
import java.util.Map;

public class __9_MaxSizeSubarraySumEqualsK {
    public static int maxLenSubarray(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int ans = 0;
        int prefixSum = 0;
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            prefixSum += num;

            if (map.containsKey(prefixSum - k)) {
                int prevIdx = map.get(prefixSum - k);
                int len = i - prevIdx;
                ans = Math.max(ans, len);
            }

            if(!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
        }

        return ans;
    }
}
