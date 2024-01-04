package dsa.catalogueOrder.levelUp.HeapAndHashMap.prefixSumRelated;

import java.util.HashMap;

public class __06_CountSubArraysWithZeroSum {
    public int countSubArrayWithZeroSum(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>(); //prefixSum : freq
        map.put(0, 1); // default case
        int sum = 0;
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if(map.containsKey(sum)) {
                int freq = map.get(sum);
                count += freq;
                map.put(sum, freq + 1);
            } else {
                map.put(sum, 1);
            }
        }

        return count;
    }
}
