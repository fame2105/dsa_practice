package dsa.random.dynamic_programming;

public class SubsetSumProblem {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 5, 11, 5};
        int sum = 11;
        System.out.println(subsetSumExists(nums, nums.length - 1, sum));

        boolean[][] dp1 = new boolean[nums.length + 1][sum + 1];
        System.out.println(subsetSumExistsMemoized(nums, nums.length - 1, sum, dp1));

        System.out.println(countSubSetSum(nums, nums.length - 1, sum));
    }

    // checks if a subset whose sum is equal to given sum exists in the given array
    private static boolean subsetSumExists(int[] nums, int idx, int sum) {
        if (sum == 0) return true;
        if (idx == -1) {
            if (sum == 0) {
                return true;
            }
            return false;
        }

        boolean result = false;
        if (sum >= nums[idx]) {
            result = subsetSumExists(nums, idx - 1, sum - nums[idx]);
            if (result == true) return true; // no need to check further
        }

        return result || subsetSumExists(nums, idx - 1, sum);
    }

    private static boolean subsetSumExistsMemoized(int[] nums, int idx, int sum, boolean[][] dp) {
        if (sum == 0) return dp[idx + 1][sum] = true;
        if (idx == -1) {
            if (sum == 0) {
                return dp[idx + 1][sum] = true;
            }
            return dp[idx + 1][sum] = false;
        }

        if(dp[idx+1][sum] == true) return dp[idx+1][sum];

        boolean result = false;
        if (sum >= nums[idx]) {
            result = subsetSumExistsMemoized(nums, idx - 1, sum - nums[idx], dp);
            dp[idx + 1][sum] = result;
            if (result == true) return true; // no need to check further
        }

        return dp[idx + 1][sum] = result || subsetSumExistsMemoized(nums, idx - 1, sum, dp);
    }

    // returns the count of subsets of given sum in the given array
    private static int countSubSetSum(int[] nums, int idx, int sum) {
        if (sum == 0) return 1;
        if (idx == -1) {
            if (sum == 0) {
                return 1;
            }
            return 0;
        }

        int countSubSetSum = 0;
        if (sum >= nums[idx]) {
            countSubSetSum = countSubSetSum(nums, idx - 1, sum - nums[idx]);
        }

        return countSubSetSum + countSubSetSum(nums, idx - 1, sum);
    }
}
