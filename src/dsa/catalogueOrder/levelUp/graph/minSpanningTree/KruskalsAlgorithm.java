package dsa.catalogueOrder.levelUp.graph.minSpanningTree;

import java.util.Arrays;

/**
 * This algorithm finds out Minimum Spanning Tree using DSU(Disjoint Set Union)
 */
public class KruskalsAlgorithm {

    private static class Pair{ // represents and edge from u to v having weight = wt
        int u;
        int v;
        int wt;

        public Pair(int u, int v, int wt) {
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
    }
    public static int minCostToSupplyWater(int n, int[][] pipes) {
        int[] parent = new int[pipes.length];
        int[] rank = new int[pipes.length];

        for(int i = 0; i < n; i++) {
            parent[i] = i;
        } // initialize parent array for DSU

        Pair[] edges = new Pair[pipes.length]; // put all the edges in an array and sort the edges based on wt.
        for(int i = 0; i < pipes.length; i++) {
            edges[i] = new Pair(pipes[i][0], pipes[i][1], pipes[i][2]);
        }
        Arrays.sort(edges, (e1, e2) -> e1.wt - e2.wt);

        int ans = 0; // represents overall wt of the min. spanning tree
        for(int i = 0; i < edges.length; i++) {
            boolean flag = union(edges[i].u, edges[i].v, parent, rank); // if u and v are not yet connected then union will connect them and return true
            if(flag == true) { // since we are using this edge to connect U and V ... we will include the wt of this ede in answer
                ans += edges[i].wt;
            }
        }

        return ans;
    }

    private static boolean union(int u, int v, int[] parent, int[] rank) {
        int leader_u = find(u, parent);
        int leader_v = find(v, parent);

        if(leader_u != leader_v) {
            if(rank[leader_u] > rank[leader_v]){
                parent[leader_v] = leader_u;
            } else if(rank[leader_u] < rank[leader_v]) {
                parent[leader_u] = leader_v;
            } else {
                parent[leader_v] = leader_u;
                rank[leader_u]++;
            }
            return true;
        } else {
            return false;
        }
    }

    private static int find(int x, int[] parent) {
        if(parent[x] == x) {
            return x;
        }

        int temp = find(parent[x], parent);
        parent[x] = temp;
        return temp;
    }
}
