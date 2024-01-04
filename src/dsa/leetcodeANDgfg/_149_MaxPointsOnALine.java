package dsa.leetcodeANDgfg;

import java.util.HashMap;
import java.util.Map;

// Problem Description : https://leetcode.com/problems/max-points-on-a-line/description/
// Solution Article : https://leetcode.com/problems/max-points-on-a-line/solutions/2910679/max-points-on-a-line/?orderBy=most_votes
public class _149_MaxPointsOnALine {
    public int maxPoints(int[][] points) {
        if(points.length == 1)
            return 1;

        int ans = 2; // there will atleast be 2 points that lie in a straight line
        for(int i = 0; i < points.length; i++) {
            // for maintain a mapping of angle made by all the points with i-th point
            Map<Double, Integer> map = new HashMap<>(); // angle : frequency
            for(int j = 0; j < points.length; j++) {
                if(i != j) { // if both points are same then angle will be zero... so no point
                    double angle = Math.atan2(points[j][1] - points[i][1], points[j][0] - points[i][0]);
                    map.put(angle, map.getOrDefault(angle, 0) + 1);
                }
            }
            int maxFreq = 0;
            for(int val : map.values()) {
                maxFreq = Math.max(maxFreq, val);
            }

            /* If there are max X points in the inner loop that make same angle with i-th point then i-th point is that 1 extra
            * point that also lies on the line to be counted */
            ans = Math.max(ans, maxFreq + 1);
        }
        return ans;
    }
}
