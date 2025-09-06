package dsa.catalogueOrder.levelUp.arraysAndStrings.intervals;

import java.util.ArrayList;
import java.util.List;
 // Link : https://leetcode.com/problems/insert-interval/description/
// Video Editorial : https://www.youtube.com/watch?v=dxbRB6gWCqg&t=51s&ab_channel=Pepcoding
public class _57_InsertInterval {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();

        int idx = 0;
        while (idx < intervals.length && intervals[idx][0] < newInterval[0]) {
            ans.add(intervals[idx]);
            idx++;
        }

        if (ans.size() == 0 || ans.get(ans.size() - 1)[1] < newInterval[0]) {
            ans.add(newInterval);
        } else {
            int[] lastInterval = ans.get(ans.size() - 1);
            lastInterval[1] = Math.max(lastInterval[1], newInterval[1]);
        }

        while (idx < intervals.length) {
            int[] lastInterval = ans.get(ans.size() - 1);
            int[] currentInterval = intervals[idx];
            if (lastInterval[1] >= currentInterval[0]) {
                lastInterval[1] = Math.max(lastInterval[1], currentInterval[1]);
            } else {
                ans.add(currentInterval);
            }

            idx++;
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
