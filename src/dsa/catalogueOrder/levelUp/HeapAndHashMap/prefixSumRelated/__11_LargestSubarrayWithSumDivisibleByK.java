package dsa.catalogueOrder.levelUp.HeapAndHashMap.prefixSumRelated;

import java.util.HashMap;
import java.util.Map;

public class __11_LargestSubarrayWithSumDivisibleByK {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1); // remainder:idx
        int sum = 0;
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = sum % k;
            rem = rem < 0 ? rem + k : rem;
            if(map.containsKey(rem)) {
                int prevIdx = map.get(rem);
                ans = Math.max(ans, i - prevIdx);
            } else {
                map.put(rem, i);
            }
        }
        return ans;
    }
}
