package dsa.leetcodeANDgfg;

import java.util.HashMap;
import java.util.HashSet;

// https://leetcode.com/problems/number-of-excellent-pairs/
// #HashMap #BitManiputlation
public class _2354_NumberOfExcellentPairs {
    public long countExcellentPairs(int[] nums, int k) {

        // Key: countOfSetBits   Value : nums that have this count of set bits.
        // we only want to store the unique num from nums so to avoid duplicated pairs
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for(int num : nums) {
            int x = getCountOfSetBits(num);

            HashSet<Integer> set;
            if(map.containsKey(x) == true) {
                set = map.get(x);
            } else {
                set = new HashSet<>();
            }

            set.add(num);
            map.put(x, set);
        }

        HashSet<Integer> visited = new HashSet<>();
        long count = 0l;
        for(int num : nums) {
            if(visited.contains(num) == true) continue;
            else {
                int x = getCountOfSetBits(num);
                int need = Math.max(0, k - x);
                for(int key : map.keySet()) {
                    if(key >= need) {
                        count += (long) map.get(key).size();
                    }
                }
                visited.add(num);
            }
        }

        return count;
    }

    // kernighan's algorithm for counting the number of set bits in a number
    // Complexity : O(count of Set Bits in a number)
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
