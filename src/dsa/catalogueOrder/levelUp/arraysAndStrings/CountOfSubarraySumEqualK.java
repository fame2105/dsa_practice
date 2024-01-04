package dsa.catalogueOrder.levelUp.arraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class CountOfSubarraySumEqualK {
    public static void main(String[] args) {
        int[] input1 = new int[] {1};
        int k1 = 0;
        System.out.println(getCountOfSubArraysOfSumK(input1, k1));

        int[] input2 = new int[] {1, 2, 3};
        int k2 = 3;
        System.out.println(getCountOfSubArraysOfSumK(input2, k2));

        int[] input3 = new int[] {1, 1, 1};
        int k3 = 2;
        System.out.println(getCountOfSubArraysOfSumK(input3, k3));
    }

    public static int getCountOfSubArraysOfSumK(int[] nums, int k) {
        int prefixSum = 0;
        Map<Integer, Integer> map = new HashMap<>(); // prefixSum : frequency
        map.put(0, 1);
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            if(map.containsKey(prefixSum - k)) count+= map.get(prefixSum - k);

            if (map.containsKey(prefixSum))
                map.put(prefixSum, map.get(prefixSum) + 1);
            else
                map.put(prefixSum, 1);
        }
        return count;
    }
}
