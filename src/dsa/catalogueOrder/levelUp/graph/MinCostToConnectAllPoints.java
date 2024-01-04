package dsa.catalogueOrder.levelUp.graph;

import java.util.Arrays;

// https://leetcode.com/problems/min-cost-to-connect-all-points/
public class MinCostToConnectAllPoints { //  we need to find a Min Spanning Tree for this question.. We can either use Prim's or Kruskal's Algorithm for finding MST
    public int minCostConnectPoints(int[][] points) {
        int no_of_vtxes = points.length;
        int totalEdgesPossible = (no_of_vtxes) * (no_of_vtxes - 1) / 2;

        int[] parent = new int[no_of_vtxes]; // for union and find
        int[] rank = new int[no_of_vtxes];

        int[][] edges = new int[totalEdgesPossible][3];

        int idx = 0;
        for(int i = 0; i < no_of_vtxes; i++) {
            for(int j = i+1; j < no_of_vtxes; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];

                int x2 = points[j][0];
                int y2 = points[j][1];

                int edgeWt = Math.abs(x1 - x2) + Math.abs(y1 - y2);
                int[] edge = new int[]{i, j, edgeWt};
                edges[idx++] = edge;
            }
            parent[i] = i; // initializing parent[]
        }

        // Apply Kruskal's Algorithm on edges[][]
        Arrays.sort(edges, (e1, e2) -> e1[2] - e2[2]); // sorting on the basis of edge wt
        int ans = 0;
        for(int i = 0; i < edges.length; i++) {
            boolean flag = union(edges[i][0], edges[i][1], parent, rank);
            if(flag == true) {
                ans += edges[i][2];
            }
        }

        return ans;

    }

    private boolean union(int u, int v, int[] parent, int[] rank) {
        int lu = find(u, parent);
        int lv = find(v, parent);

        if(lu != lv) {
            if(rank[lu] > rank[lv]) {
                parent[lv] = lu;
            } else if(rank[lu] < rank[lv]) {
                parent[lu] = lv;
            } else {
                parent[lv] = lu;
                rank[lu]++;
            }
            return true;
        } else {
            return false;
        }
    }

    private int find(int x, int[] parent) {
        if(parent[x] == x) {
            return x;
        }

        int temp = find(parent[x], parent);
        parent[x] = temp;
        return temp;
    }

}
