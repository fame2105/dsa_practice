package dsa.leetcodeANDgfg;

// GFG Article : https://www.geeksforgeeks.org/maximum-sum-rectangle-in-a-2d-matrix-dp-27/
// Editorial : https://www.youtube.com/watch?v=-FgseNO-6Gk&ab_channel=BackToBackSWE

// based on Kadane's Algorithm  #HARD
public class _DP_MaxSumRectangleIn2DMatrix {

    public int maxSumSubmatrix(int[][] matrix) {
        int l = 0, r = 0, t = 0, b = 0;

        int[] colSum;
        int maxSum = 0;
        for(int left= 0; left < matrix[0].length; left++) {
            colSum = new int[matrix.length];
            for(int right = left;  right < matrix[0].length; right++) {

                for(int row = 0; row < matrix.length; row++) {
                    colSum[row] += matrix[row][right];
                }

                maxSum = Math.max(maxSum, getMaxSum(colSum));
            }
        }
        return maxSum;
    }

    // kadane's Algorithm
    private int getMaxSum(int[] arr) {
        if(arr.length == 1) return arr[0];

        int maxSum = 0;
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            int val = arr[i];
            if(val + sum < val) {
                sum = val;
            } else {
                sum += val;
            }

            if(maxSum < sum)
                maxSum = sum;
        }
        return maxSum;
    }

}
