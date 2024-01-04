package dsa.leetcodeANDgfg;

// https://leetcode.com/problems/sort-the-matrix-diagonally/
// #Arrays #Sorting
/**
 * It's a standard Arrays based question which is implemented using CountSort due to the
 * mentioned constraints that numbers in the matrix are in the range of 1 <= num <= 100
 * <p>
 * Approach : Travel each diagonal and apply countSort on each of those diagonal, then return the modified(Sorted) diagonal
 */
public class _1329_SortTheMatrixDiagonally {
    public int[][] diagonalSort(int[][] mat) {
        // sort all the diagonals starting at 0th column
        for (int i = 0; i < mat.length; i++) {
            countSort(mat, i, 0);
        }

        // sort all the diagonals starting at 0th row
        // Starting j from 1 because the middle Diagonal is common...no point sorting it twice
        for (int j = 1; j < mat[0].length; j++) {
            countSort(mat, 0, j);
        }

        return mat;
    }

    private void countSort(int[][] mat, int row, int col) {
        int[] map = new int[101];
        int i = row;
        int j = col;
        while (i < mat.length && j < mat[row].length) {
            map[mat[i][j]] += 1; // increment frequency of each number in the diagonal starting at given row, col
            i++;
            j++;
        }

        // reset i and j pointers
        i = row;
        j = col;
        for (int k = 1; k < map.length; k++) { // fill values from the map into current diagonal
            while (i < mat.length && j < mat[row].length && map[k] > 0) {
                mat[i][j] = k;
                map[k] -= 1;
                i++;
                j++;
            }
        }
    }
}
