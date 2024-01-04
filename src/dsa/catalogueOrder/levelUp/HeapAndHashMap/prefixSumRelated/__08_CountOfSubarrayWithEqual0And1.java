package dsa.catalogueOrder.levelUp.HeapAndHashMap.prefixSumRelated;

import java.util.HashMap;
import java.util.Map;

public class __08_CountOfSubarrayWithEqual0And1 {
    public static int solution(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // prefixSum:frequency

        int ans = 0;
        int prefixSum = 0;

        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            num = num == 0 ? -1 : num;
            prefixSum += num;

            if (map.containsKey(prefixSum)) {
                int prevCount = map.get(prefixSum);
                ans += prevCount;
                map.put(prefixSum, prevCount + 1);
            } else {
                map.put(prefixSum, 1);
            }
        }

        return ans;
    }
}
