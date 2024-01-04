package dsa.leetcodeANDgfg.Greedy;

import java.util.Arrays;

// https://leetcode.com/problems/non-overlapping-intervals/   #Greedy
public class _435_NonOverlappingIntervals {

    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals.length == 1) return 0;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]); // sort on the basis of start time.... could also be solved is sorted on end time

        int count = 0;
        int prevEnd = intervals[0][1];
        for(int i = 1; i < intervals.length; i++) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];
            if(currStart >= prevEnd) {
                prevEnd = currEnd;
            } else {
                count++;
                // we want to remove the interval which has a larger endValue,
                // because there is greater chance that it could coincide with the upcoming intervals.
                // bigger the end time, bigger would be the stretch of the interval, hence remove the one with
                // larger endTime
                prevEnd = Math.min(prevEnd, currEnd);
            }
        }

        return count;
    }
}
