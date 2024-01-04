package dsa.leetcodeANDgfg;

// Link : https://leetcode.com/problems/maximum-sum-circular-subarray/description/
// Editorial : https://www.youtube.com/watch?v=kd0-hUwISDo&ab_channel=Codebix
// Solution : https://leetcode.com/problems/maximum-sum-circular-subarray/solutions/2868539/maximum-sum-circular-subarray/ (Approach 2)
public class _918_MaxSumCircularSubarray {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSumSub = kadane(nums);

        int countNegatives = 0;
        int totalSumReverse = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < 0) {
                countNegatives += 1;
            }

            nums[i] = -1 * nums[i];
            totalSumReverse += nums[i];
        }

        /*
         * Scenario 1 : all nums are negatives in the source array
         */
        if(countNegatives == nums.length) {
            return maxSumSub;
        }

        int minSumSub = kadane(nums); // this will give the minimum sum that could be achieved in the reversed array

        int max = -1 * (totalSumReverse - minSumSub);
        return Math.max(maxSumSub, max);
    }

    private int kadane(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (currentSum >= 0) {
                currentSum += nums[i];
            } else {
                currentSum = nums[i];
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }

        return maxSum;
    }
}
