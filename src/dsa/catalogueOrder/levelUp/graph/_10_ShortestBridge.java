package dsa.catalogueOrder.levelUp.graph;

import java.util.LinkedList;
import java.util.Queue;

public class _10_ShortestBridge {

    static int[][] direction = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}}; // top, left, down, right

    private static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int shortestBridge(int[][] A) {
        Queue<Pair> queue = new LinkedList<>();

        ParentLoop:
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j] == 1) {
                    dfs(A, i, j, queue);
                    break ParentLoop;
                }
            }
        }

        // Process the queue that contains the component that was travelled during DFS
        int level = 0; // indicates the distance from other component
        while (queue.size() > 0) {
            int size = queue.size();
            while (size > 0) {
                Pair rem = queue.remove();
                for (int d = 0; d < direction.length; d++) {
                    int nr = rem.x + direction[d][0];
                    int nc = rem.y + direction[d][1];

                    if (nr >= 0 && nr < A.length && nc >= 0 && nc < A[nr].length) {
                        if (A[nr][nc] == 1) return level;
                        if(A[nr][nc] == 0) {
                            A[nr][nc] = -1; // mark the element/vtx we are adding in the queue for further processing
                            queue.add(new Pair(nr, nc));
                        }
                    }
                }
                size--;
            }
            level++;
        }
        return level;
    }

    // apply 4 direction dfs to add one of the components/island into the Queue
    private static void dfs(int[][] A, int sr, int sc, Queue<Pair> queue) {
        A[sr][sc] = -1; // marking visited
        queue.add(new Pair(sr, sc)); // all elements of this component should be added in the queue

        for (int d = 0; d < direction.length; d++) {
            int nr = sr + direction[d][0];
            int nc = sc + direction[d][1];

            if (nr >= 0 && nr < A.length && nc >= 0 && nc < A[nr].length && A[nr][nc] == 1) {
                dfs(A, nr, nc, queue);
            }
        }
    }
}
