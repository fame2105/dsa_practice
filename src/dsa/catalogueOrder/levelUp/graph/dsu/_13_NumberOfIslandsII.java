package dsa.catalogueOrder.levelUp.graph.dsu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _13_NumberOfIslandsII {

    // m -> rows
    // n -> columns
    // positions[][] -> cell location to toggle from 0 to 1
    public static List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[] parent = new int[m*n];
        int[] rank = new int[m*n];
        Arrays.fill(parent,-1);

        List<Integer> ans = new ArrayList<>();
        int count = 0;

        int[][] direction = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}}; // top, left, down, right

        for(int i = 0; i < positions.length; i++) {
            int row = positions[i][0];
            int col = positions[i][1];

            int currentCellNo = (row * n) + col;
            if(parent[currentCellNo] != -1) { // positions are repeated too in the given input
                ans.add(count);
                continue;
            }

            parent[currentCellNo] = currentCellNo;
            rank[currentCellNo] = 1;
            count++;

            for (int d = 0; d < direction.length; d++) {
                int nRow = row + direction[d][0];
                int nCol = col + direction[d][1];

                int nbrCellNo = (nRow * n) + nCol;
                if(nRow >=0 && nRow < m && nCol >=0 && nCol < n && parent[nbrCellNo] != -1) {
                    int parentCurrentCell = find(parent, currentCellNo);
                    int parentNbrCell = find(parent, nbrCellNo);

                    if(parentCurrentCell != parentNbrCell) {
                        if(rank[parentCurrentCell] > rank[parentNbrCell]) {
                            parent[parentCurrentCell] = parentNbrCell;
                        } else if (rank[parentCurrentCell] < rank[parentNbrCell]) {
                            parent[parentNbrCell] = parentCurrentCell;
                        } else {
                            parent[parentCurrentCell] = parentNbrCell;
                            rank[parentCurrentCell]++;
                        }

                        count--;
                    }
                }
            }
            ans.add(count);
        }
        return ans;
    }

    private static int find(int[] parent, int node) {
        if(parent[node] == node) {
            return node;
        }

        int temp = find(parent, parent[node]);
        parent[node] = temp;
        return temp;
    }
}
