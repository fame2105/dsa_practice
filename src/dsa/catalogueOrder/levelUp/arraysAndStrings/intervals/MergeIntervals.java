package dsa.catalogueOrder.levelUp.arraysAndStrings.intervals;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/merge-intervals/submissions/
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        List<int[]> overlappingIntervals = new ArrayList<>();
        for (int[] interval : intervals) {
            if (overlappingIntervals.size() == 0) {
                overlappingIntervals.add(interval);
            } else {
                int[] prevInterval = overlappingIntervals.get(overlappingIntervals.size() - 1);
                if (interval[0] > prevInterval[1]) {
                    // no overlap -> can't be merged
                    overlappingIntervals.add(interval);
                } else {
                    // overlap -> need to merge (update ending time of the prev interval, if required)
                    prevInterval[1] = Math.max(prevInterval[1], interval[1]);
                }
            }
        }
        return overlappingIntervals.toArray(new int[overlappingIntervals.size()][]);
    }
}
