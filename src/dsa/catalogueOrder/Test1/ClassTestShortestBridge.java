package dsa.catalogueOrder.Test1;

import java.util.LinkedList;
import java.util.Queue;

public class ClassTestShortestBridge {

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
        boolean flag = false;

        for (int i = 0; i < A.length; i++) {
            if(flag == true) break;
            for (int j = 0; j < A[i].length; j++) {
                if (A[i][j] == 1) {
                    flag = true;
                    dfs(A, i, j, queue);
                    break;
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
                            A[nr][nc] = -1;
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

    // apply 4 direction dfs on island matrix to add one of the components into the Queue
    private static void dfs(int[][] A, int sr, int sc, Queue<Pair> queue) {
        A[sr][sc] = -1;
        queue.add(new Pair(sr, sc));

        for (int d = 0; d < direction.length; d++) {
            int nr = sr + direction[d][0];
            int nc = sc + direction[d][1];

            if (nr >= 0 && nr < A.length && nc >= 0 && nc < A[nr].length && A[nr][nc] == 1) {
                dfs(A, nr, nc, queue);
            }
        }
    }
}

