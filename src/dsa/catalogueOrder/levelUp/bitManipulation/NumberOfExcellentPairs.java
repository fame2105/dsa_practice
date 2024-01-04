package dsa.catalogueOrder.levelUp.bitManipulation;

import java.util.HashMap;
import java.util.HashSet;

public class NumberOfExcellentPairs {
    public long countExcellentPairs(int[] nums, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<Integer> iset = new HashSet<>();
        int ans = 0;
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < nums.length; j++) {
                if(map.containsKey("" + nums[i] + nums[j]) == false) {
                    int co = getCountOfSetBits(nums[i] | nums[j]);
                    int ca = getCountOfSetBits(nums[i] & nums[j]);
                    if(ca + co >= k) ans++;
                }
                iset.add(nums[i]);
            }
        }
        return ans;
    }

    private int getCountOfSetBits(int n) {
        int count = 0;
        while(n > 0)  {
            count++;
            int rsbm = n & -n;
            n = n - rsbm;
        }
        return count;
    }
}
