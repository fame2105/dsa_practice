package dsa.catalogueOrder.levelUp.graph;

import java.util.PriorityQueue;

public class SwimInRisingWater {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0, grid[0][0]));

        boolean[][] visited = new boolean[n][n];

        while (pq.size() > 0) {
            Pair rem = pq.remove();

            if (rem.row == n - 1 && rem.col == n - 1) {
                return rem.maxElement;
            }

            if (visited[rem.row][rem.col] == true) {
                continue;
            }

            visited[rem.row][rem.col] = true;

            for (int d = 0; d < direction.length; d++) {
                int newRow = rem.row + direction[d][0];
                int newCol = rem.col + direction[d][1];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && visited[newRow][newCol] == false) {
                    pq.add(new Pair(newRow, newCol, Math.max(rem.maxElement, grid[newRow][newCol])));
                }
            }
        }

        return 0;
    }

    static int[][] direction = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}}; // top, left, down, right

    private static class Pair implements Comparable<Pair> {
        int row;
        int col;
        int maxElement;

        Pair(int r, int c, int maxwt) {
            this.row = r;
            this.col = c;
            this.maxElement = maxwt;
        }

        public int compareTo(Pair o) {
            return this.maxElement - o.maxElement;
        }
    }
}
