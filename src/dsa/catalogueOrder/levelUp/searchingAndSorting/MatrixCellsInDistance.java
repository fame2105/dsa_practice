package dsa.catalogueOrder.levelUp.searchingAndSorting;

import java.util.LinkedList;
import java.util.Queue;

public class MatrixCellsInDistance {

    public static void main(String[] args) {
        System.out.println(allCellsDistanceOrder(1, 2, 0, 0));
    }
    // Approach 01 - Using sorting:

    // public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
    //     int[][] ans = new int[rows * cols][2];

    //     int boxNo = 0;
    //     for (int i = 0; i < rows; i++) {
    //         for (int j = 0; j < cols; j++) {
    //             boxNo = i * cols + j;
    //             ans[boxNo][0] = i;
    //             ans[boxNo][1] = j;
    //         }
    //     }

    //     Arrays.sort(ans, (a, b) -> {
    //         int d1 = Math.abs(a[0] - rCenter) + Math.abs(a[1] - cCenter);
    //         int d2 = Math.abs(b[0] - rCenter) + Math.abs(b[1] - cCenter);
    //         return d1 - d2;
    //     });

    //     return ans;
    // }

    // Approach 02 -Using BFS
    public static int[][] allCellsDistanceOrder(int rows, int cols, int rCenter, int cCenter) {
        boolean[][] visited = new boolean[rows][cols];
        int[][] ans = new int[rows * cols][2];
        int[][] direction = new int[][] { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
        Queue<int[][]> q = new LinkedList<>();

        q.add(new int[rCenter][cCenter]);
        int count = 0;
        while (q.size() > 0) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[][] rem = q.remove();
                int r = rem[0][0];
                int c = rem[0][1];

                ans[count][0] = r;
                ans[count][1] = c;
                count++;

                visited[r][c] = true;
                for (int d = 0; d < direction.length; d++) {
                    int nr = r + direction[d][0];
                    int nc = c + direction[d][1];

                    if (nr < 0 || nr >= rows || nc < 0 || nc >= cols || visited[nr][nc] == true) {
                        continue;
                    } else {
                        q.add(new int[nr][nc]);
                    }
                }
            }
        }
        
        return ans;
    }

}
