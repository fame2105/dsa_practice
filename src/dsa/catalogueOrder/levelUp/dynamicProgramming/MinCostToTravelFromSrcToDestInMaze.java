package dsa.catalogueOrder.levelUp.dynamicProgramming;

import java.util.LinkedList;
import java.util.Queue;

public class MinCostToTravelFromSrcToDestInMaze {
    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if (i == rows - 1 && j == cols - 1) {
                    dp[i][j] = grid[i][j];
                } else if (i == rows - 1) {
                    dp[i][j] = grid[i][j] + dp[i][j+1];
                } else if (j == cols - 1) {
                    dp[i][j] = grid[i][j] + dp[i+1][j];
                } else {
                    dp[i][j] = grid[i][j] + Math.min(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        return dp[0][0];
    }

    private class Pair {
        int row;
        int col;
        String path;
        Pair(int row, int col, String path) {
            this.row = row;
            this.col = col;
            this.path = path;
        }
    }

    public void minPathSumPaths(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] dp = new int[rows][cols];
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if (i == rows - 1 && j == cols - 1) {
                    dp[i][j] = grid[i][j];
                } else if (i == rows - 1) {
                    dp[i][j] = grid[i][j] + dp[i][j+1];
                } else if (j == cols - 1) {
                    dp[i][j] = grid[i][j] + dp[i+1][j];
                } else {
                    dp[i][j] = grid[i][j] + Math.min(dp[i+1][j], dp[i][j+1]);
                }
            }
        }

        System.out.println(dp[0][0]);

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0, 0, ""));
        while(q.size() > 0) {
            Pair rem = q.remove();
            if (rem.row == rows - 1 && rem.col == cols - 1) {
                System.out.println(rem.path);
            } else if (rem.row == rows - 1) {
                q.add(new Pair(rem.row, rem.col+1, rem.path + 'H'));
            } else if (rem.col == cols - 1) {
                q.add(new Pair(rem.row+1, rem.col, rem.path + 'V'));
            } else {
                int i = rem.row;
                int j = rem.col;
                if(dp[i+1][j] < dp[i][j+1]) {
                    q.add(new Pair(i+1, j, rem.path + "V"));
                } else if(dp[i+1][j] > dp[i][j+1]) {
                    q.add(new Pair(i, j+1, rem.path + "H"));
                } else {
                    q.add(new Pair(i+1, j, rem.path + "V"));
                    q.add(new Pair(i, j+1, rem.path + "H"));
                }
            }
        }
    }


}
