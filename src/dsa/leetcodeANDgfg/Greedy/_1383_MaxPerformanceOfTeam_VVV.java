package dsa.leetcodeANDgfg.Greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

// https://leetcode.com/problems/maximum-performance-of-a-team/
// Read the question and Dry run the solution... you will know why each and every step make sense.
public class _1383_MaxPerformanceOfTeam_VVV {
    private class Pair implements Comparable<Pair>{
        long efficiency;
        long speed;
        Pair(long efficiency, long speed) {
            this.efficiency = efficiency;
            this.speed = speed;
        }

        public int compareTo(Pair o) {
            return (int) Long.compare(o.efficiency, this.efficiency);
        }
    }

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        long MOD = 1000000007l;
        Pair[] pairs = new Pair[n];
        for(int i = 0; i < n; i++) {
            Pair p = new Pair(efficiency[i], speed[i]);
            pairs[i] = p;
        }

        Arrays.sort(pairs); // sort by efficiency in decreasing order

        PriorityQueue<Long> pq = new PriorityQueue<>();

        long teamSpeed = 0;
        long performance = 0, maxPerformance = 0;
        for(int i = 0; i < n; i++) {
            Pair p = pairs[i];

            if(pq.size() >= k) {
                teamSpeed -= pq.remove();
            }

            pq.add(p.speed);
            teamSpeed += p.speed;
            performance = teamSpeed * p.efficiency;
            maxPerformance = Math.max(maxPerformance, performance);
        }

        return (int) (maxPerformance % MOD);
    }
}
