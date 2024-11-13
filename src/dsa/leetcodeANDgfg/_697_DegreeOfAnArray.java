package dsa.leetcodeANDgfg;

import java.util.HashMap;

public class _697_DegreeOfAnArray {

    // Easy - but good question
    public int findShortestSubArray(int[] nums) {
        int degree = 0, result = 0;
        HashMap<Integer, Integer> frequencyMap = new HashMap<>(), firstOccurance = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            frequencyMap.put(nums[i], frequencyMap.getOrDefault(nums[i], 0) + 1);
            firstOccurance.putIfAbsent(nums[i], i);
            if(frequencyMap.get(nums[i]) > degree) {
                degree = frequencyMap.get(nums[i]);
                result = i - firstOccurance.get(nums[i]) + 1;
            } else if(frequencyMap.get(nums[i]) == degree) {
                result = Math.min(result, i - firstOccurance.get(nums[i]) + 1);
            }
        }
        return result;
    }
}
