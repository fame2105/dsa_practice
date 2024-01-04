package dsa.catalogueOrder.levelUp.graph;

import java.util.HashSet;
// Explanation on samsung notes
public class _1_NumberOfDistinctIslands {
    static int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}}; // top, left, down, right
    static int[] dirChar = {'t', 'l', 'd', 'r'};

    public static int numberofDistinctIslands(int[][] grid) {
        HashSet set = new HashSet<String>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    StringBuilder str = new StringBuilder("");
                    dfs(grid, i, j, str);
                    set.add(str.toString());
                }
            }
        }
        return set.size();
    }

    private static void dfs(int[][] grid, int sr, int sc, StringBuilder str) {
        grid[sr][sc] = 0;
        for (int d = 0; d < dir.length; d++) {
            int nr = sr + dir[d][0];
            int nc = sc + dir[d][1];
            if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[nr].length && grid[nr][nc] == 1) {
                str.append(dirChar[d]);
                dfs(grid, nr, nc, str);
            }
        }
        str.append("z");
    }
}
