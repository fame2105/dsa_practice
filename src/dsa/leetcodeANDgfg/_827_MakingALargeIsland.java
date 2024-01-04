package dsa.leetcodeANDgfg;

import java.util.HashMap;
import java.util.HashSet;

// https://leetcode.com/problems/making-a-large-island/submissions/   #google
public class _827_MakingALargeIsland {
    public static void main(String[] args) {
        int[][] grid = {
            {1,0},
            {0,1}
        };
        int largestArea = largestIsland(grid);
        System.out.println(largestArea);
    }
    public static int largestIsland(int[][] grid) {
        int max = 0, m = grid.length, n = grid[0].length;

        // precompute areas of all the existing islands in the grid and mark each island with a unique number
        HashMap<Integer, Integer> map = new HashMap<>(); // uniqueDigitForAnIsland : areaOfThatIsland
        int color = 2; // we are starting from 2 because 0 and 1 are already present in the grid
        for(int i = 0; i < grid.length; i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 1) {
                    int area = dfs(i, j, grid, color);
                    map.put(color, area);
                    color++;
                }
            }
        }
        System.out.println(map);
        boolean hasZero = false; //To check if there is any zero in the grid
        int maxArea = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == 0){ // a single 0 in the grid could combine at most 4 different islands, therefore just add the uniqueDigits in the grid surrounding the 0
                    hasZero = true;
                    HashSet<Integer> set = new HashSet<>(); // we are using a set because a 0 could be surrounded on all sides by a same island, and we might add the uniqueDigit for the same island multiple times, hence using a set
                    if(isValid(grid, i-1, j)) set.add(grid[i-1][j]);
                    if(isValid(grid, i, j-1)) set.add(grid[i][j-1]);
                    if(isValid(grid, i+1, j)) set.add(grid[i+1][j]);
                    if(isValid(grid, i, j+1)) set.add(grid[i][j+1]);

                    int area = 1;
                    for(int val : set) { // set contains uniqueDigitForAnIsland surrounding the 0 at i, j
                        if (map.containsKey(val)) {
                            area += map.get(val);
                        }
                    }

                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return hasZero == true ? maxArea : m * n;
    }
    private static int dfs(int i, int j, int[][] grid, int color){
        if(isValid(grid, i, j) == false || grid[i][j] == 0 || grid[i][j] == color) return 0;

        grid[i][j] = color;
        int result = 1+dfs(i-1,j,grid,color)+dfs(i+1,j,grid,color)+dfs(i,j+1,grid,color)+dfs(i,j-1,grid,color);
        return result;
    }

    private static boolean isValid(int[][] grid, int i, int j) {
        if(i >=  0 && i < grid.length && j >= 0 && j < grid[0].length)
            return true;

        return false;
    }
}
