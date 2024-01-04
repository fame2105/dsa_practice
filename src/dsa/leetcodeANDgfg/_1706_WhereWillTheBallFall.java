package dsa.leetcodeANDgfg;

// https://leetcode.com/problems/where-will-the-ball-fall/
public class _1706_WhereWillTheBallFall {

    public int[] findBall(int[][] grid) {
        prepareGrid(grid);
        int[] ans = new int[grid[0].length];
        for (int j = 0; j < grid[0].length; j++) {
            ans[j] = dfs(grid, 0, j);
        }
        return ans;
    }

    // Optional but helpful to understand
    // Could modify the grid while dfs on each ball to optimize the solution, rather than processing the grid here for just negative cases
    private void prepareGrid(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                if (grid[i][j] == -1 && grid[i][j - 1] == 1) {
                    grid[i][j] = 5; //  5 is just a marker, no importance of it
                    grid[i][j - 1] = 5;
                }
            }
        }

        // Check 0th Column
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][0] == -1) grid[i][0] = 5;
        }

        // Check n-1th Column
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][grid[i].length - 1] == 1) grid[i][grid[i].length - 1] = 5;
        }
    }

    private int dfs(int[][] grid, int row, int col) {
        if (row >= grid.length) return col; // positive base case... ball falls throught the column
        if (col < 0 || col >= grid[row].length) return -1; // negative base case #1 ... ball is pressed against either of the walls
        if (grid[row][col] == 5) return -1; // negative base case #2 ... ball is caught in a V pattern

        int dir = grid[row][col];

        if (dir == 1) // 1 means ball is gonna fall right, hence col+1
            return dfs(grid, row + 1, col + 1);
        else // -1 means ball is gonna fall left, hence col-1
            return dfs(grid, row + 1, col - 1);
    }
}