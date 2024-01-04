package dsa.catalogueOrder.levelUp.HeapAndHashMap.prefixSumRelated;

import java.util.HashMap;
import java.util.Map;

public class __10_CountOfSubarraySumEqualsK {
    public static int countSubarrayOfSumK(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int ans = 0;
        int prefixSum = 0;
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            prefixSum += num;

            if (map.containsKey(prefixSum - k)) {
                int prevCount = map.get(prefixSum - k);
                ans += prevCount;
            }

            if(!map.containsKey(prefixSum)) {
                map.put(prefixSum, 1);
            } else {
                map.put(prefixSum, map.get(prefixSum) + 1);
            }
        }

        return ans;
    }
}
