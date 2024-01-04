package dsa.catalogueOrder.levelUp.arraysAndStrings;

// https://leetcode.com/problems/maximize-distance-to-closest-person/
public class MaximizeDistanceToClosestPerson {

    public int maxDistToClosest(int[] seats) {
        int dist = 0;
        int zeros = 0;
        int idx = 0;

        // Max distance from left segment zeros
        while (idx < seats.length && seats[idx] != 1) {
            idx++;
            zeros++;
        }
        idx++;
        dist = zeros;

        //Max Distance from mid segments zeros
        while (idx < seats.length) {
            zeros = 0;
            while (idx < seats.length && seats[idx] != 1) {
                zeros++;
                idx++;
            }

            if (idx == seats.length) break;

            dist = Math.max(dist, (zeros + 1) / 2);
            idx++;
        }
        return Math.max(zeros, dist);
    }
}
