package dsa.leetcodeANDgfg.Greedy;

import java.util.Arrays;
import java.util.HashMap;

// https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
public class _1296_DivideArrayInSetsOfKConsecutiveIntegers {
    public boolean isPossibleDivide(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        Arrays.sort(nums);

        for(int num : nums) {
            if(map.get(num) > 0) {
                int temp = num;
                while(temp < num + k) {

                    if(map.containsKey(temp) == false || map.get(temp) == 0)
                        return false;
                    else
                        map.put(temp, map.get(temp) - 1);

                    temp += 1;
                }
            }
        }

        return true;
    }
}
