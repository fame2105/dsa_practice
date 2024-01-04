package dsa.leetcodeANDgfg;

public class _2256_MinimumAverageDifference {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        // calculate prefix sum (left to right)
        long[] prefixSum = new long[n];

        // calculate suffix sum (right to left) ... instead of calculating suffixSum we could use (totalSum - PrefixSum) at each point to calculate the suffixSum at any index
        long[] suffixSum = new long[n];

        for(int i = 0; i < n; i++) {
            prefixSum[i] = i > 0 ? (prefixSum[i-1] + nums[i]) : nums[i];

            suffixSum[n-i-1] = (i == 0) ? nums[n-i-1] : (suffixSum[n-i] + nums[n-i-1]);
        }

        int minAvgDiff = Integer.MAX_VALUE;
        int minAvgDiffIdx = 0;
        for(int i = 0; i < n; i++) {
            long left = prefixSum[i] / (i+1);
            long right = (i == n-1) ? 0 : (suffixSum[i+1] / (n - i - 1));
            int avgDiff = (int) Math.abs(left - right);
            if(avgDiff < minAvgDiff) {
                minAvgDiff = avgDiff;
                minAvgDiffIdx = i;
            }
        }
        return minAvgDiffIdx;
    }
}
