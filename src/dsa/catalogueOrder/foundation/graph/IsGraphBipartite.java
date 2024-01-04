package dsa.catalogueOrder.foundation.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class IsGraphBipartite {
    private static class Edge {
        int v1; // current vtx
        int v2; // nbr
        int wt;

        public Edge(int v1, int v2, int wt) {
            this.v1 = v1;
            this.v2 = v2;
            this.wt = wt;
        }
    }

    private static class BipartiteBFSPair {
        int vtx;
        int lvl;

        public BipartiteBFSPair(int vtx, int lvl) {
            this.vtx = vtx;
            this.lvl = lvl;
        }
    }

    private static boolean isGraphBipartite(List<Edge>[] graph) {
        int[] visited = new int[graph.length]; // instead of storing true/false for each vtx ... we will store the level at which a vtx was marked
        Arrays.fill(visited, -1);
        for (int i = 0; i < graph.length; i++) {
            if (visited[i] == -1) { // if unvisited , then check Bipartitness of this component
                boolean isBipartite = isComponentBipartite(graph, i, visited);
                if (isBipartite == false) // even if one of the components is NON-BIPARTITE then whole graph is non-bipartite
                    return false;
            }
        }

        return true; // all components are bipartite
    }

    private static boolean isComponentBipartite(List<Edge>[] graph, int vtx, int[] visited) {
        Queue<BipartiteBFSPair> q = new LinkedList<>();
        q.add(new BipartiteBFSPair(vtx, 0));
        while (q.size() > 0) {
            BipartiteBFSPair rem = q.remove();

            if (visited[rem.vtx] != -1) { // already visited once.... there is a cycle present in this component

                if(rem.lvl != visited[rem.vtx])  // for odd cycle, lvls of same vtx will be tried to be pushed under different levels, for even cycle, lvls are same
                    return false;

            } else {
                visited[vtx] = rem.lvl; // mark this vtx by storing its lvl in the visited

                for(Edge edge : graph[rem.vtx]) {
                    int nbr = edge.v2;
                    if(visited[nbr] == -1) { // push unvisited nbrs of this vtx to queue
                        q.add(new BipartiteBFSPair(nbr, rem.lvl+1));
                    }
                }
            }
        }

        return true;
    }
}
