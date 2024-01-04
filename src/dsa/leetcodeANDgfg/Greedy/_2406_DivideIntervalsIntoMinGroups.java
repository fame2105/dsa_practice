package dsa.leetcodeANDgfg.Greedy;

import java.util.Arrays;

// https://leetcode.com/contest/weekly-contest-310/problems/divide-intervals-into-minimum-number-of-groups/
// Editorial : https://www.youtube.com/watch?v=OeXoo7DuXxI&ab_channel=BroCoders
// This question is somewhat exactly like : https://www.youtube.com/watch?v=TBlKgdYwQ4Q&t=671s
public class _2406_DivideIntervalsIntoMinGroups {
    public int minGroups(int[][] intervals) {
        int n = intervals.length;

        int[] starts = new int[n];
        int[] ends = new int[n];

        int i = 0;
        for(int[] interval : intervals) {
            starts[i] = interval[0];
            ends[i] = interval[1];
            i++;
        }

        Arrays.sort(starts);
        Arrays.sort(ends);

        i = 1;
        int j = 0;

        int groups = 1;
        int maxGroups = 1;

        while(i < n && j < n) {

            if(starts[i] <= ends[j]) {
                groups++;
                i++;
            } else {
                groups--;
                j++;
            }

            maxGroups = Math.max(maxGroups, groups);
        }

        return maxGroups;
    }
}
