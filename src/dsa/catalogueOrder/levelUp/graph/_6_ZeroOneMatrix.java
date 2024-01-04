package dsa.catalogueOrder.levelUp.graph;

import java.util.LinkedList;
import java.util.Queue;

public class _6_ZeroOneMatrix {
    private static class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;

        }
    }

    static int[][] direction = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}}; // top, left, down, right

    public static int[][] updateMatrix(int[][] matrix) {
        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    q.add(new Pair(i, j));
                } else if (matrix[i][j] == 1) {
                    matrix[i][j] = -1;
                }
            }
        }

        int level = 0;
        while (q.size() > 0) {
            int size = q.size();

            while (size > 0) {
                Pair rem = q.remove();
                for (int d = 0; d < direction.length; d++) {
                    int nx = rem.x + direction[d][0];
                    int ny = rem.y + direction[d][1];

                    if (nx >= 0 && nx < matrix.length && ny >= 0 && ny < matrix[nx].length && matrix[nx][ny] == -1) {
                        q.add(new Pair(nx, ny));
                        matrix[nx][ny] = level+1;
                    }
                }
                size--;
            }
            level++;
        }
        return matrix;
    }
}
