package dsa.catalogueOrder.levelUp.dynamicProgramming;

import java.util.LinkedList;
import java.util.Queue;

public class GoldMineWithPath {
    private class Pair {
        int row;
        int col;
        String path;

        public Pair(int row, int col, String path) {
            this.row = row;
            this.col = col;
            this.path = path;
        }
    }
    public void goldMineWithPaths(int[][] grid) {
        int rows = grid.length;
        int cols = grid.length;

        int[][] dp = new int[rows][cols];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(j == cols-1) {
                    dp[i][j] = grid[i][j];
                } else if(i == 0) {
                    dp[i][j] = Math.max(dp[i][j+1], dp[i+1][j+1]) + grid[i][j];
                } else if(i == rows - 1) {
                    dp[i][j] = Math.max(dp[i][j+1], dp[i-1][j+1]) + grid[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j+1], Math.max(dp[i][j+1], dp[i+1][j+1])) + grid[i][j];
                }
            }
        }

        int maxGold = Integer.MIN_VALUE;
        for(int i = 0; i < rows; i++) {
            maxGold = Math.max(maxGold, dp[i][0]);
        }
        System.out.println(maxGold);

        Queue<Pair> q = new LinkedList<>();
        for(int i = 0; i < rows; i++) {
            if(dp[i][0] == maxGold) {
                q.add(new Pair(i, 0, i + " "));
            }
        }
        while(q.size() > 0) {
            Pair rem = q.remove();
            if(rem.col == cols - 1) {
                System.out.println(rem.path);
            } else if(rem.row == 0){
                int fmid = dp[rem.row][rem.col+1];
                int fdown = dp[rem.row + 1][rem.col+1];
                int max = Math.max(fmid, fdown);
                if(fmid == max) {
                    q.add(new Pair(rem.row, rem.col + 1, rem.path + "d2 "));
                }

                if(fdown == max) {
                    q.add(new Pair(rem.row + 1, rem.col + 1, rem.path + "d3 "));
                }
            } else if(rem.row == rows - 1) {
                int fup = dp[rem.row - 1][rem.col+1];
                int fmid = dp[rem.row][rem.col+1];
                int max = Math.max(fmid, fup);

                if(fup == max) {
                    q.add(new Pair(rem.row - 1, rem.col + 1, rem.path + "d1 "));
                }
                if(fmid == max) {
                    q.add(new Pair(rem.row, rem.col + 1, rem.path + "d2 "));
                }
            } else {
                int fup = dp[rem.row - 1][rem.col + 1];
                int fmid = dp[rem.row][rem.col+1];
                int fdown = dp[rem.row + 1][rem.col+1];
                int max = Math.max(fmid, Math.max(fup, fdown));
                if(fdown == max) {
                    q.add(new Pair(rem.row+1, rem.col + 1, rem.path + "d3 "));
                }
                if(fmid == max) {
                    q.add(new Pair(rem.row, rem.col + 1, rem.path + "d2 "));
                }

                if(fup == max) {
                    q.add(new Pair(rem.row - 1, rem.col + 1, rem.path + "d1 "));
                }
            }
        }
    }
}
