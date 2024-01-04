package dsa.catalogueOrder.foundation.dynamicProgramming;

public class _16_MaxSumNonAdjacentElements {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 10, 10, 100, 5, 6};

        int maxCost = maxSumNonAdjacentElements(arr, arr.length - 1, true);
        System.out.println(maxCost);

        int[][] dp = new int[2][arr.length + 1];
        maxCost = maxSumNonAdjacentElementsMemoized(arr, arr.length - 1, 1, dp);
        System.out.println(maxCost);

        maxCost = maxSumNonAdjacentElementGreedy(arr);
        System.out.println(maxCost);
    }

    private static int maxSumNonAdjacentElements(int[] arr, int idx, boolean status) {
        if (idx == -1) {
            return 0;
        }

        int maxSum = 0;
        if (status == true) {
            maxSum = arr[idx] + maxSumNonAdjacentElements(arr, idx - 1, false);
        }

        return Math.max(maxSum, maxSumNonAdjacentElements(arr, idx - 1, true));
    }

    private static int maxSumNonAdjacentElementsMemoized(int[] arr, int idx, int status, int[][] dp) {
        if (idx == -1) {
            return dp[status][idx + 1] = 0;
        }

        if (dp[status][idx + 1] != 0) return dp[status][idx + 1];

        int maxSum = 0;
        if (status == 1) {
            maxSum = arr[idx] + maxSumNonAdjacentElementsMemoized(arr, idx - 1, 0, dp);
        }

        return dp[status][idx + 1] = Math.max(maxSum, maxSumNonAdjacentElementsMemoized(arr, idx - 1, 1, dp));
    }

    private static int maxSumNonAdjacentElementGreedy(int[] arr) {
        int selectedSum = 0;
        int nonSelectedSum = 0;

        for (int i = 0; i < arr.length; i++) {
            int newSelectedSum = nonSelectedSum + arr[i];
            int newNonSelectedSum = Math.max(selectedSum, nonSelectedSum);

            selectedSum = newSelectedSum;
            nonSelectedSum = newNonSelectedSum;
        }
        return Math.max(selectedSum, nonSelectedSum);
    }

}
