package dsa.leetcodeANDgfg;

public class _1351_CountNegativeNumbersInSortedMatrix {
    public int countNegatives(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int i = rows-1, j = 0;
        int count = 0;
        while(i >= 0 && j < cols) {
            int element = grid[i][j];
            if(element >= 0) {
                j++;
            } else {
                count = count + (cols - j);
                i--;
            }
        }
        return count;
    }
}
