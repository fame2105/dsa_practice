package dsa.random.sliding_window;

public class MaxSumSubarray_KadanesAlgorithm {

    public static void main(String[] args) {
//        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        System.out.println(maxSumSubArray(a)); // expected : 6
        int[] a = {-2, 1, -3, -1, 5, 4};
        System.out.println(maxSumSubArray(a)); // expected : 6
        System.out.println(maxSumSubarray(a, 0)); // expected : 6
    }

    // Using Kadane's Algorithm
    public static int maxSumSubArray(int[] nums) {
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

    // Using divide and Conquer Approach
    public static int maxSumSubarray(int[] nums, int idx) {
        return 0;
    }
}
