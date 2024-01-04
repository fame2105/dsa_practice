package dsa.catalogueOrder.levelUp.graph;

// provide the count of number of 1s such that we don't reach boundary when travelling those 1's
public class _2_NumberOfEnclaves {
    int[][] direction = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}}; // top, left, down, right

    public int numEnclaves(int[][] grid) {
         // travel on first and last column and mark the components that are connected to column boundaries
        for(int row = 0; row < grid.length; row++) {
            if(grid[row][0] == 1) { // first column
                dfs(grid, row, 0);
            }

            if(grid[row][grid[0].length - 1] == 1) { // last column
                dfs(grid, row, grid[0].length - 1);
            }
        }

        // travel on first and last row and mark the components that are connected to column boundaries
        for(int col = 0; col < grid[0].length; col++) {
            if(grid[0][col] == 1) { // first row
                dfs(grid, 0, col);
            }

            if(grid[grid.length - 1][col] == 1) { // last row
                dfs(grid, grid.length - 1, col);
            }
        }

        int count = 0; // in the remaining grid... count all remaining 1s and return this counter

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == 1) count++;
            }
        }

        return count;
    }

    private void dfs(int[][] grid, int sr, int sc) {
        grid[sr][sc] = 0;
        for(int d = 0; d < direction.length; d++) {

            int nr = sr + direction[d][0];
            int nc = sc + direction[d][1];

            if(nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[nr].length && grid[nr][nc] == 1) {
                dfs(grid, nr, nc);
            }
        }
    }
}
