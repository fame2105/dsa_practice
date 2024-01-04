package dsa.leetcodeANDgfg.Greedy;

import java.util.PriorityQueue;

// https://leetcode.com/problems/minimum-number-of-refueling-stops/  #Greedy

// Also has a DP implementation o(n^2) -> but Greedy is better, more optimized
public class _871_MinimumNumberOfRefuelingStops {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int N = stations.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b-a);

        int currFuel = startFuel;
        int i = 0;
        int count = 0;
        while(currFuel < target) {
            // Add the fuel provided by all those stations in the PriorityQueue that can be reached with the amount of fuel that
            // we currently have
            while(i < N && currFuel >= stations[i][0]) {
                pq.add(stations[i][1]);
                i++;
            }

            /**
             * If this condition is met, then it means that we didn't had enough fuel to reach even a single station
             * from currFuel position to nearest station hence none of stationFuels were added in the PriorityQueue
             */

            if(pq.size() == 0) {
                return -1;
            }

            currFuel += pq.remove(); // we get to refuel at the station that provides maxFuel and is also within range
            count += 1;
        }

        return count;
    }
}