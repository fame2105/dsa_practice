package dsa.catalogueOrder.levelUp.HeapAndHashMap.prefixSumRelated;

import java.util.HashMap;
import java.util.Map;

public class CountSubarraysWithSumDivisbleByK {

    public static int countSubarraysWithSumDivisbleByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = sum % k;
            rem = rem < 0 ? rem + k : rem;
            if(map.containsKey(rem)) {
                int prevCount = map.get(rem);
                ans += prevCount;
                map.put(rem, prevCount + 1);
            } else {
                map.put(rem, 1);
            }
        }
        return ans;
    }
}
