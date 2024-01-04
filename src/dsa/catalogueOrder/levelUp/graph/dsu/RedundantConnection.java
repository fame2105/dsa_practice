package dsa.catalogueOrder.levelUp.graph.dsu;

/**
 * // https://leetcode.com/problems/redundant-connection/    [Medium]
 * Tree has v vtx and exactly v-1 edges where as a graph could have v vtx and a lot more than v edges.
 *
 * Given an undirected graph which has exactly one extra edge thus making a tree into a graph we want to find out any edge
 * in this graph which when removed converts this graph back into a tree.
 *
 *Adding an extra edge in an undirected tree/graph will introduce a cycle in the graph and we could not use eihter DSU/DFS to find out if there a-is a cycle present in the
 * graph
 * Note: DSU can't help if we want to detect a cycle in a directed graph, we will have to use DFS for it.
 *
 * For this question, in order to form a tree, each vtx should have exactly one leader, so if at all we come across an edge which is trying to connect a vtx which is already
 * connected to a different group then we have come across a redundant connection
 */
public class RedundantConnection {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n+1];
        int[] rank = new int[n+1];

        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }

        for(int i = 0; i < n; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            int lu = findLeader(parent, u);
            int lv = findLeader(parent, v);

            if(lu != lv) {
                if(rank[lu] > rank[lv]) {
                    parent[lv] = lu; // make lu as leader of lv because rank[lu] > rank[lv]
                } else if (rank[lu] < rank[lv]) {
                    parent[lu] = lv;
                } else {
                    parent[lu] = lv;
                    rank[lv]++;
                }
            } else {
                return edges[i];
            }
        }

        return new int[]{0,0};
    }

    private int findLeader(int[] parent, int vtx) {
        if(parent[vtx] == vtx) return vtx;

        int temp = findLeader(parent, parent[vtx]);
        parent[vtx] = temp;
        return temp;
    }
}
