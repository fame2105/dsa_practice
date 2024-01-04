package dsa.catalogueOrder.levelUp.HeapAndHashMap.prefixSumRelated;

import java.util.HashMap;
import java.util.Map;

public class __12_CountOfSubarrayWithEqual0s1sAnd2s {
    public static int countOfSubarrayWithEqual0s1sAnd2s(int[] arr) {
        Map<String, Integer> map = new HashMap<>();
        map.put("0#0", 1);
        int[] counts = new int[3];
        int ans = 0;
        for(int i = 0; i < arr.length; i++) {
            int num = arr[i];
            counts[num]++;
            int keydiff1 = counts[1] - counts[0];
            int keydiff2 = counts[2] - counts[1];
            String key = keydiff1 + "#" + keydiff2;

            if(map.containsKey(key)) {
                int prevCount = map.get(key);
                ans += prevCount;
                map.put(key, prevCount + 1);
            } else {
                map.put(key, 1);
            }
        }
        return ans;
    }
}
