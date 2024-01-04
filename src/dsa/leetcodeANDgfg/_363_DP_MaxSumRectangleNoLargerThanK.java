package dsa.leetcodeANDgfg;

import java.util.TreeSet;

// based on MaxSumRectangleIn2DMatrix problem
// based on prefixSum.. using cumulativeSum
public class _363_DP_MaxSumRectangleNoLargerThanK {
    public static void main(String[] args) {
        int[][] mat1 = {{1, 0, 1}, {0, -2, 3}};
        int k1 = 2;

        int[][] mat2 = {{2, 2, -1}};
        int k2 = 3;

        int[][] mat3 = {{2, 2, -1}};
        int k3 = 0;

        int[][] mat4 = {{2, 2, -1}};
        int k4 = -1;

        int[][] mat5 = {{5, -4, -3, 4}, {-3, -4, 4, 5}, {5, 1, 5, -4}};
        int k5 = 10;

        int[][] mat6 = {{5, -4, -3, 4}, {-3, -4, 4, 5}, {5, 1, 5, -4}};
        int k6 = 8;

        System.out.println(maxSumSubmatrix(mat6, k6));

    }

    public static int maxSumSubmatrix(int[][] matrix, int k) {
        int[] colSum;
        int result = Integer.MIN_VALUE;

        for (int left = 0; left < matrix[0].length; left++) {
            colSum = new int[matrix.length];
            for (int right = left; right < matrix[0].length; right++) {

                for (int row = 0; row < matrix.length; row++) {
                    colSum[row] += matrix[row][right];
                }
                result = Math.max(result, getMaxInArrayLessThanK(colSum, k));
            }
        }
        return result;
    }

    // TODO : Dry run and figure out why we need to use set.ceiling in this method
    private static int getMaxInArrayLessThanK(int[] arr, int k) {
        int sum = Integer.MIN_VALUE;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        int prefixSum = 0;
        for(int val : arr) {
            prefixSum += val;
            Integer neededValToMakeK = set.ceiling(prefixSum - k); // this is to ensure that we are always only considering a sum value <= K    
            if(neededValToMakeK != null)
                sum = Math.max(sum, prefixSum - neededValToMakeK);

            set.add(prefixSum);
        }
        return sum;
    }
}
