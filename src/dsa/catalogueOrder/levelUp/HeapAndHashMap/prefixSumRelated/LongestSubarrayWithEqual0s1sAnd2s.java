package dsa.catalogueOrder.levelUp.HeapAndHashMap.prefixSumRelated;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayWithEqual0s1sAnd2s {
    public static int longestSubarrayWithEqual0s1sAnd2s(int[] arr) {
        Map<String, Integer> map = new HashMap<>();
        map.put("0#0", -1); // key = count(1's)-count(0's)#count(1's)-count(0's)
        int[] counts = new int[3]; // to hold counts of 0's , 1's and 2's
        int ans = 0;
        for(int i = 0; i < arr.length; i++) { // arr will contain only 0's, 1's and 2's
            int num = arr[i];
            counts[num]++;
            int keydiff1 = counts[1] - counts[0];
            int keydiff2 = counts[2] - counts[1];
            String key = keydiff1 + "#" + keydiff2;

            if(map.containsKey(key)) {
                int prevIdx = map.get(key);
                ans = Math.max(ans, i - prevIdx);
            } else {
                map.put(key, i);
            }
        }
        return ans;
    }
}
