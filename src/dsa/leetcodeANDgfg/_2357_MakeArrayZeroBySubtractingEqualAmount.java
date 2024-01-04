package dsa.leetcodeANDgfg;

import java.util.PriorityQueue;

// https://leetcode.com/contest/weekly-contest-304/problems/make-array-zero-by-subtracting-equal-amounts/

public class _2357_MakeArrayZeroBySubtractingEqualAmount {
    public int minimumOperations(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0;
        int max = 0;
        while(i < nums.length) {
            if(nums[i] != 0) {
                max = Math.max(max, nums[i]);
                pq.add(nums[i]);
            }
            i++;
        }

        int sum = 0;
        int count = 0;
        while(pq.size() > 0 && sum < max) {
            int smallest = pq.remove();
            if((smallest - sum) == 0) continue;
            sum  = sum + (smallest - sum);
            count++;
        }


        return count;
    }
}
