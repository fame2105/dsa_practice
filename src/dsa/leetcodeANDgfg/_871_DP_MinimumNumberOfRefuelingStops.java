package dsa.leetcodeANDgfg;

// https://leetcode.com/problems/minimum-number-of-refueling-stops/  #DP

// could also be done using a Greedy Method via PriorityQueue
public class _871_DP_MinimumNumberOfRefuelingStops {

    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int N = stations.length;

        // dp[i] denotes maxReachableDistance when noOfStops taken is i;
        int[] dp = new int[N + 1];

        dp[0] = startFuel; // we can go at max startFuelDistance with 0 stops.

        /**
         * The only way we could use minimal number of refueling stops to reach our destination is
         * if we use those refuelingStations that provide maximum fuel, given the station is
         * reachable from where we are standing.
         * Inner loop is updating dp[] with maxDistances if we find that we could reach a farther distance with
         * the station at i->currentStationBeingCOnsidered or the station we used in the past....
         * this would maximize reachableDistance at every refueling stop.
         */

        for (int i = 0; i < N; i++) {
            for (int t = i; t >= 0; t--) { // loop is backwards so we can update the maxDistanceReachable incase

                int maxDistanceReachableWithTStops = dp[t];
                int distanceOfIthStationFromStart = stations[i][0];
                boolean isIthStationWithinRange = maxDistanceReachableWithTStops >= distanceOfIthStationFromStart;

                if (isIthStationWithinRange == true) {
                    // I can use this stop to refuel and update maxDsitanceReachable
                    dp[t + 1] = Math.max(dp[t + 1], dp[t] + stations[i][1]);
                }
            }
        }
        int ans = -1;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] >= target) {
                ans = i;
                break;
            }
        }
        return ans;
    }

}
