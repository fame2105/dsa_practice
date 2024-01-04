package dsa.leetcodeANDgfg;

import java.util.ArrayList;
import java.util.List;

//    https://leetcode.com/problems/pacific-atlantic-water-flow/

/**
 * Apply DFS to fill an empty Boolean grid to check and store from which all points can we reach PACIFIC ocean
 * Apply DFS to fill another empty Boolean grid to check and store from which all points can we reach ATLANTIC ocean
 *
 * Traverse both grids to check if and capture all the coordinates from which we can reach both Pacific and Atlantic Ocean
 */
public class _417_PacificAtlanticWaterFlow {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int rows = heights.length;
        int columns = heights[0].length;
        List<List<Integer>> result = new ArrayList<>();

        if(heights == null || heights.length == 0 || heights[0].length == 0) return result;



        boolean[][] pacific = new boolean[rows][columns];
        boolean[][] atlantic = new boolean[rows][columns];
        for(int j = 0; j < columns; j++) {
            dfs(heights, 0, j, pacific, Integer.MIN_VALUE);
            dfs(heights, rows-1, j, atlantic, Integer.MIN_VALUE);
        }

        for(int i = 0; i < rows; i++) {
            dfs(heights, i, 0, pacific, Integer.MIN_VALUE);
            dfs(heights, i, columns-1, atlantic, Integer.MIN_VALUE);
        }

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                if(pacific[i][j]  == true && atlantic[i][j] == true) {
                    ArrayList<Integer> heightCoordinate = new ArrayList<>();
                    heightCoordinate.add(i);
                    heightCoordinate.add(j);
                    result.add(heightCoordinate);
                }
            }
        }

        return result;
    }

    private int[][] direction = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private void dfs(int[][] heights, int row, int col, boolean[][] canVisit, int prevHeight) {
        if(row < 0 || row >= heights.length || col < 0 || col >= heights[0].length || canVisit[row][col] == true || heights[row][col] < prevHeight) return;

        canVisit[row][col] = true;
        for(int d = 0; d < direction.length; d++) {
            int nr = row + direction[d][0];
            int nc = col + direction[d][1];
            dfs(heights, nr, nc, canVisit, heights[row][col]);
        }
    }
}
