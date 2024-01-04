package dsa.leetcodeANDgfg.Greedy;

import java.util.Arrays;

//https://www.geeksforgeeks.org/job-sequencing-problem/
public class JobSequencingWithDeadline {

    class Job {
        int id, profit, deadline;
        Job(int x, int y, int z){
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }

    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n) {
        Arrays.sort(arr, (job1, job2) -> job2.profit - job1.profit); // sort jobs based on profit

        int maxDeadLine = Integer.MIN_VALUE; // get the maxDeadline among all the jobs, all the tasks must be finished by this time
        for(Job job : arr) {
            maxDeadLine = Math.max(maxDeadLine, job.deadline);
        }

        int maxProfit = 0;
        int countJobs = 0;
        int[] result = new int[maxDeadLine + 1];
        Arrays.fill(result, -1);

        for(int i = 0; i < arr.length; i++) {

            int deadline = arr[i].deadline;

            for(int j = deadline; j > 0; j--) {
                if(result[j] == -1) {
                    result[j] = i; // store the job index at in the result
                    maxProfit += arr[i].profit;
                    countJobs++;
                    break;
                }
            }
        }
        result[0] = countJobs;
        result[1] = maxProfit;
        return result;
    }

}
