package dsa.leetcodeANDgfg.Greedy;

import java.util.HashMap;
import java.util.Map;

// Solution Discussion : https://leetcode.com/problems/minimum-rounds-to-complete-all-tasks/solutions/2779140/minimum-rounds-to-complete-all-tasks/
public class _2244_MinimumRoundsToCompleteAllTasks {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int  task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }
        int minRounds = 0;
        for(int freq : map.values()) {
            if(freq == 1)
                return -1;

            if(freq % 3 == 0) {
                // Group all the task in triplets.
                minRounds += freq / 3;
            } else {
                  // If count % 3 = 1; (count / 3 - 1) groups of triplets and 2 pairs.
                  // If count % 3 = 2; (count / 3) groups of triplets and 1 pair.
                minRounds += (freq % 3) + 1;
            }
        }
        return minRounds;
    }
}
