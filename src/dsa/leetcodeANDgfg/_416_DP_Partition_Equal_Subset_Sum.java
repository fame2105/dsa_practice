package dsa.leetcodeANDgfg;

// https://leetcode.com/problems/partition-equal-subset-sum/  #TargetSumSubset
public class _416_DP_Partition_Equal_Subset_Sum {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }

        // if sum is odd then there is no way we can partition array into two subsets of equal sum
        if(sum % 2 != 0) return false;

        Boolean[][] dp = new Boolean[nums.length + 1][sum/2 + 1];
        boolean isPartitionPossible = targetSumSubset(nums, 0, sum/2, dp);
        return isPartitionPossible;
    }

    // returns true if there is a subset of given sum in the original array
    // this function is TargetSumSubset Problem(Already solved in Pep Class)
    private boolean targetSumSubset(int[] nums, int idx, int sum, Boolean[][] dp) {
        if(sum == 0) return true;

        // we have traversed entire array and formed all subsets but couldn't get the desired sum.
        if (idx == nums.length) return false;

        if(dp[idx][sum] != null) return dp[idx][sum];

        boolean sumUsingCurrElement = false;

        if(sum >= nums[idx]){
            sumUsingCurrElement = targetSumSubset(nums, idx+1, sum - nums[idx], dp);
        }

        boolean sumNotUsingCurrElement = targetSumSubset(nums, idx+1, sum, dp);


        boolean result = sumUsingCurrElement || sumNotUsingCurrElement;
        dp[idx][sum] = result;
        return result;
    }
}
