package dsa.random.sliding_window;

public class MaxAverageSubArray {
    public static void main(String[] args) {
        int[] input1 = new int[]{1, 12, -5, -6, 50, 3};
        int k = 4;

        System.out.println(findMaxAverage(input1, k));
    }

    public static double findMaxAverage(int[] nums, int k) {
        double maxSum = (double)-1e9;
        double sum = 0.0;
        int j = 0;
        for (int i = 0; i <= nums.length - k; i++) {
            while (j < nums.length && j - i + 1 < k) {
                sum += nums[j];
                j++;
            }

            if (j - i + 1 == k) {
                sum += nums[j];
                maxSum = Math.max(maxSum, sum);
                sum = sum - nums[i];
                j++;
            }
        }
        return maxSum / k;
    }
}
