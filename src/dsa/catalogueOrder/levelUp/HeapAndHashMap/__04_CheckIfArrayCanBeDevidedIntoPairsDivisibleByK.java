package dsa.catalogueOrder.levelUp.HeapAndHashMap;

import java.util.HashMap;
import java.util.Map;

//Leetcode : 1497 https://leetcode.com/problems/check-if-array-pairs-are-divisible-by-k/
public class __04_CheckIfArrayCanBeDevidedIntoPairsDivisibleByK {
    public static void main(String[] args) {
        int[] nums = {-1,1,-2,2,-3,3,-4,4};
        int k = 3;

        boolean ans = canArrange(nums, k);
        System.out.println(ans);
    }

    public static boolean canArrange(int[] arr, int k) {
        // Prepare frequency map of remainders
        Map<Integer, Integer> freq = new HashMap<>();
        for(int val : arr) {
            int rem = val % k;
            rem = rem < 0 ? rem + k: rem; // remainder could be -ve if val is -ve
            freq.put(rem, freq.getOrDefault(rem, 0) + 1);
        }

        for(int val : arr) {
            int rem = val % k;
            rem = rem < 0 ? rem + k: rem;
            if(rem == 0 || 2*rem == k) { // special case : if remainder is 0 or (rem == k-rem ... or k == 2 * rem) then check that freq of remainder is even
                int freqX = freq.get(rem);
                if(freqX % 2 == 1) return false;
            } else {
                int freq1 = freq.get(rem);
                int freq2 = freq.getOrDefault(k-rem, 0);
                if(freq1 != freq2) return false;
            }
        }
        return true;
    }
}
