package dsa.catalogueOrder.levelUp.graph;

import java.util.LinkedList;
import java.util.Queue;

public class _7_AsFarFromLandAsPossible {
    private static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;

        }
    }

    static int[][] direction = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}}; // top, left, down, right

    public int maxDistance(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    q.add(new Pair(i, j));
                } else if (grid[i][j] == 0) {
                    grid[i][j] = -1;
                }
            }
        }

        if (q.size() == 0 || q.size() == grid.length * grid[0].length) { // either we have no 1(land) or every cell is a land
            return -1;
        }

        int maxDistance = 0;
        int level = 0;

        while (q.size() > 0) {
            int size = q.size();

            while (size > 0) {
                Pair rem = q.remove();

                for (int d = 0; d < direction.length; d++) {
                    int nx = rem.x + direction[d][0];
                    int ny = rem.y + direction[d][1];

                    if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[nx].length && grid[nx][ny] == -1) {
                        q.add(new Pair(nx, ny));
                        grid[nx][ny] = 1;
                        maxDistance = level + 1;
                    }
                }
                size--;
            }
            level++;
        }
        return maxDistance;
    }
}
