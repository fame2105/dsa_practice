package dsa.random.sliding_window;

public class MaximumSumSubarrayInWindowOfSizeK {
    public static void main(String[] args) {
        int[] a = new int[]{4, 3, 2, 5, 1, -1, -4, 100};
        int k = 3;
        System.out.println(maxSumSubarray(a, k));
    }

    public static int maxSumSubarray(int[] a, int k) {
        int maxSum = 0;
        int windowSum = 0;
        int j = 0;
        for (int i = 0; i < a.length; i++) {

            while (j < a.length && j - i + 1 < k) {
                windowSum += a[j];
                j++;
            }

            if (j < a.length && j - i + 1 == k) {
                windowSum += a[j];
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= a[i];
                j++;
            }

        }
        return maxSum;
    }
}
