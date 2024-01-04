package dsa.leetcodeANDgfg.BinarySearch;

// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/  # Binary Search
public class _378_KthSmallestElementInSortedMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,5,9},
                {10,11,13},
                {12,13,15}
        };
        int k = 8;
        kthSmallest(matrix, 8);
    }

    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;

        int lo = matrix[0][0], hi = matrix[n-1][n-1];
        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            int count = getCountOfLowerElements(matrix, mid);
            if(count < k) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return lo;
    }

    private static int getCountOfLowerElements(int[][] matrix, int target) {
        int n = matrix.length;
        int i = n-1, j = 0; // starting from bottom left position
        int count = 0;
        while(i >= 0 && j < n) {
            if(matrix[i][j] > target) { // reduce the row if the target is smaller
                i--;
            } else {
// target is bigger than current Element as well as all the elements in that column (there are i smaller elements in this column and + 1 for the element in the current row which is also smaller than target
                count = count + i + 1;
                j++;
            }
        }

        return count;
    }
}
