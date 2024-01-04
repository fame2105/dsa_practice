package dsa.catalogueOrder.levelUp.graph;

public class ColoringABorder {
    int[][] direction = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int initialColor = grid[row][col];
        dfs(grid, row, col, initialColor); // mark all the vtx which has are of initialColor in connected component starting from row, col ... mark them

        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {

                if(grid[i][j] < 0) grid[i][j] = color;
            }
        }

        return grid;
    }

    private void dfs(int[][] grid, int row, int col, int initialColor) {
        grid[row][col] = -initialColor; //
        int count = 0; // count of nbrs that are a part of this connected component.

        for(int d = 0; d < direction.length; d++) {
            int nRow = row + direction[d][0];
            int nCol = col + direction[d][1];

            if(nRow >= 0 && nRow < grid.length && nCol >= 0 && nCol < grid[nRow].length) {
                if(grid[nRow][nCol] == -initialColor) count++;

                else if(grid[nRow][nCol] == initialColor) { //
                    count++;
                    dfs(grid, nRow, nCol, initialColor);
                }
            }
        }

        if(count == 4) grid[row][col] = initialColor; // if count of nbrs that are a part of this connected component is 4 then this point is not a border
    }
}
