package dsa.leetcodeANDgfg;

import java.util.Arrays;
import java.util.Stack;

// Problem Description : https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/
public class _452_MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        Stack<int[]> st = new Stack<>();
        for(int[] point : points) {
            if(st.size() == 0) {
                st.push(point);
            } else if(point[0] <= st.peek()[1]) {
                int[] mergedPoint = new int[2];
                mergedPoint[0] = Math.max(point[0], st.peek()[0]);
                mergedPoint[1] = Math.min(point[1], st.peek()[1]);
                st.pop();
                st.push(mergedPoint);
            } else {
                st.push(point);
            }
        }
        return st.size();
    }
}
