package dsa.catalogueOrder.levelUp.graph;

import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/rotting-oranges/
public class _3_RottenOranges { // uses Standard BFS in a 2D matrix

    private class Pair {
        int row;
        int col;
        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    int[][] direction = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}}; // top, left, down, right

// 0 : representing an empty cell,
// 1 : representing a fresh orange,
// 2 : representing a rotten orange.
    public int orangesRotting(int[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        int fresh = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) q.add(new Pair(i, j)); // push all the rotten oranges in the queue
                else if (grid[i][j] == 1) fresh++; // count fresh oranges in the queue
            }
        }

        if (fresh == 0) return 0; // there are no fresh oranges at minute zero hence return 0;

        int level = -1;
        while (q.size() > 0) {
            int size = q.size();
            level++;

            while (size > 0) {
                Pair rem = q.remove();
                for (int d = 0; d < direction.length; d++) {
                    int nr = rem.row + direction[d][0];
                    int nc = rem.col + direction[d][1];

                    // Push all the fresh oranges in the queue
                    if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[nr].length && grid[nr][nc] == 1) { //
                        q.add(new Pair(nr, nc));
                        grid[nr][nc] = 0; // mark this cell as empty so we do not process in further
                        fresh--; // reduce the counter of fresh oranges by 1 for each neighbour that gets pushed in the queue
                    }
                }

                size--;
            }
        }

        return fresh == 0 ? level : -1;
    }
}
