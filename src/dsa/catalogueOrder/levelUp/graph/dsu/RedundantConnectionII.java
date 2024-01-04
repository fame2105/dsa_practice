package dsa.catalogueOrder.levelUp.graph.dsu;

import java.util.Arrays;

/**
 * Adding an extra edge in a directed Tree will introduce three kind of issues:
 * 1. One of the nodes could have two parents
 * 2. There might be a cycle introduced in the graph
 * 3. 1 + 2
 *
 * Using DSU we can't identify cycles in a directed graph but we can confirm the presence cycle using DSU if we know for sure that a cycle is present in the graph
 * That extra edge would try to connect a same vtx with some other vtx
 * We will mark/blacklist those two edges and check by removing one of them.
 * If after removing one of the edges, cycle has been removed then we removed the correct edge otherwise we will remove the other edge instead of the first one.
 */
public class RedundantConnectionII {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int vtx_count = edges.length;
        int[] indegree = new int[vtx_count + 1]; // edges and vtxes are following 1-based indexing
        Arrays.fill(indegree, -1);
        int bl1 = -1;
        int bl2 = -1;
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            if (indegree[v] == -1) {
                indegree[v] = i; // we are storing the edge number for each vtx, because if the graph has exactly one extra edge then only 1 vtx could have more than 2 edges trying to connect it
            } else {
                bl1 = i; // current edge i and the previously stored edge no. for vtx v i.e indegree[v] are the potential edges and one of them is redundant for sure.
                bl2 = indegree[v];
                break;
            }
        }

        int[] parent = new int[vtx_count + 1];
        int[] rank = new int[vtx_count + 1];
        for(int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < edges.length; i++) {
            if(i == bl1) continue; // we want to skip processing of bl1, if by skipping bl1 we do not find a cycle in the graph, then bl1 is the redundant edge

            int u = edges[i][0];
            int v = edges[i][1];

            boolean flag = union(u, v, parent, rank);
            if(flag == true) {  // we have a found a cycle in the graph
                if(bl1 == -1) { // this represents a case where the redundant edge did not contribute into being a parent to any of the nodes, it simply introduced a cycle
                    return edges[i];  // return this edge that introduces a cycle
                } else {
                    /**
                     * // case 3 -> double parents and still CYCLE PRESENT
                     * (we did not process the edge bl1, and yet we found a cycle,
                     * that means bl1 is not the redundant edge responsible for introducing a cycle in the graph
                     * , it has to be the other blacklisted edge bl2
                     */
                    return edges[bl2];
                }
            }
        }
        /**
         * // CASE 1 -> Double Parents present -> This case represents that no cycle was introduced and the redundant edge caused one of the nodes to have 2 parents
         * There was no cycle introduced in the graph because of the redundant edges, so remove either bl1 or bl2 (because one of them is redundant).
         *
         */
        return edges[bl1];
    }

    private boolean union(int u, int v, int[] parent, int[] rank) {
        int lu = find(parent, u);
        int lv = find(parent, v);

        if (lu != lv) {
            if (rank[lu] > rank[lv]) {
                parent[lv] = lu;
            } else if (rank[lu] < rank[lv]) {
                parent[lu] = lv;
            } else {
                parent[lv] = lu;
                rank[lu]++;
            }
            return false;
        } else { // if leaders are same then cycle is present
            return true;
        }
    }

    private int find(int[] parent, int x) {
        if (parent[x] == x) return x;

        int temp = find(parent, parent[x]);
        parent[x] = temp;
        return temp;
    }
}
