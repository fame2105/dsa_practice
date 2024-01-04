package dsa.graphs;

import java.util.ArrayList;

public class _1_CheckIfPathExists {
    private static class Edge {
        int src;
        int nbr;
        int weight;

        Edge(int src, int nbr, int weight) {
            this.src = src;
            this.nbr = nbr;
            this.weight = weight;
        }

        Edge(int src, int nbr) {
            this(src, nbr, 0);
        }
    }

    public static boolean pathExists(ArrayList<Edge>[] graph, int src, int destination) {
        boolean[] visited = new boolean[graph.length];
        return pathExists_DFS(graph, src, destination, visited);
    }

    private static boolean pathExists_DFS(ArrayList<Edge>[] graph, int src, int destination, boolean[] visited) {
        visited[src] = true;
        if(src == destination) return true;

        for(Edge myNbrs : graph[src]) {
            if(visited[myNbrs.nbr] == false) {
                boolean hasPath = pathExists_DFS(graph, myNbrs.nbr, destination, visited);
                if(hasPath) return true;
            }
        }

        return false;
    }

}
