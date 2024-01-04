package dsa.catalogueOrder.levelUp.dynamicProgramming;

import java.util.Arrays;

public class _1235_MaxProfitInJobScheduling {
    private class Job {
        int start, end, profit;
        Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = profit.length;
        Job[] jobs = new Job[n];
        for(int i = 0; i < n; i++) {
            Job job = new Job(startTime[i], endTime[i], profit[i]);
            jobs[i] = job;
        }

        Arrays.sort(jobs, (a, b) -> a.start - b.start); // we are sorting, so that next non-conflicting job could be found in log(n) time complexity
        Integer[] dp = new Integer[n + 1];
        return recursiveUtil(jobs, 0, n, dp);
    }

    private int recursiveUtil(Job[] jobs, int idx, int n, Integer[] dp) {
        if(idx >= n) {
            return 0;
        }

        if(dp[idx] != null) return dp[idx];

        int include = jobs[idx].profit;
        // get next non conflicting job index
        int ncj = getNextNonConflictingJobIdx(jobs, idx, n);
        if(ncj != -1) {
            include += recursiveUtil(jobs, ncj, n, dp);
        }

        int exclude = recursiveUtil(jobs, idx + 1, n, dp);

        return dp[idx] = Math.max(include, exclude);
    }

    private int getNextNonConflictingJobIdx(Job[] jobs, int idx, int n) {
        int start = idx + 1, end = n - 1, ans = -1;
        while(start <= end) {
            int mid = (start + end) >> 1;
            if(jobs[idx].end <= jobs[mid].start) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }
}
