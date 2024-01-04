package dsa.catalogueOrder.levelUp.graph;

import java.util.List;

public class DetectCycleInDirectedGraph {
    private static class Edge {
        int u;
        int v;

        public Edge(int u, int v) {
            this.u = u;
            this.v = v;
        }
    }

    private static boolean detectCycleInDirectedGraph(List<Edge>[] graph) {
        int vtx_count = graph.length;
        boolean[] visited = new boolean[vtx_count];
        boolean[] path = new boolean[vtx_count];

        for(int i = 0; i < vtx_count; i++) {
            if(visited[i] == false) {
                boolean cycleExists = dfs(graph, i, visited, path);
                if(cycleExists) return true;
            }
        }

        return false;
    }

    private static boolean dfs(List<Edge>[] graph, int src, boolean[] visited, boolean[] path) {
            visited[src] = true;
            path[src] = true;

            List<Edge> nbrs = graph[src];
            for(Edge nbr : nbrs) {
                if(visited[nbr.v] == false) {
                    boolean cycleExists = dfs(graph, nbr.v, visited, path);
                    if(cycleExists) return true;
                } else {
                    if(path[nbr.v] == true) {
                        return true;
                    }
                }
            }

            path[src] = false;
            return false;
    }
}
