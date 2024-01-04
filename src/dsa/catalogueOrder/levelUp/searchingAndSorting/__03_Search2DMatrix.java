package dsa.catalogueOrder.levelUp.searchingAndSorting;

public class __03_Search2DMatrix {

    public static boolean search(int[][]matrix,int target) {
        // Apply Binary Search to find the potencial Row where the target element could be found
        int r = binarySearchSelectRow(matrix, target);
        if(r == -1) {
            return false;
        }

        boolean isFound = binarySearch(matrix, r, target);

        return isFound;
    }

    // Searching for potential row here:
    private static int binarySearchSelectRow(int[][] matrix, int target) {
        int lo = 0;
        int hi = matrix.length - 1;
        int columnLength = matrix[0].length;

        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            if(matrix[mid][0] <= target && target <= matrix[mid][columnLength - 1]) {
                return mid;
            } else if(matrix[mid][0] < target) {
                lo = mid + 1;
            } else if(matrix[mid][0] > target) {
                hi = mid - 1;
            }
        }

        return -1;
    }

    // Searching for potential element in thr previously found row here
    private static boolean binarySearch(int[][] matrix, int row, int target) {
        int lo = 0;
        int hi = matrix[row].length - 1;
        int columnLength = matrix[0].length;

        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            if(matrix[row][mid] == target) {
                return true;
            } else if(matrix[row][mid] <target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return false;
    }
}
