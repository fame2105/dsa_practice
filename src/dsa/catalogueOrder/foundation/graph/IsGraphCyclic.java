package dsa.catalogueOrder.foundation.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class IsGraphCyclic {

    static class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    private static boolean chechAlternatePathWithBFS(ArrayList<Edge>[] graph, int src, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        while (q.size() > 0) {
            int vtx = q.remove();

            if (visited[vtx] == true) { /* if we are at a point which is already visited then it means we are trying
                 to reach this point again via an alternate Path in a graph which indicates the presence of a cycle */
                return true;
            } else {
                visited[vtx] = true;
                for (Edge e : graph[vtx]) {
                    if (visited[e.nbr] == false) q.add(e.nbr);
                }
            }
        } // closing while

        return false;
    }

    private static boolean checkAlternatePathWithDFS(ArrayList<Edge>[] graph, int src, int parent, boolean[] visited) {
        visited[src] = true;
        for (Edge e : graph[src]) {
            int nbr = e.nbr;
            if (visited[nbr] == false) {
                return checkAlternatePathWithDFS(graph, nbr, src, visited);
            } else {
                if (nbr != parent) return true;
            }
        }
        return false;
    }

    public static boolean isCyclic(ArrayList<Edge>[] graph) {
        boolean[] visited = new boolean[graph.length];
        for (int vtx = 0; vtx < graph.length; vtx++) {
            if (visited[vtx] == false) {
//                if(chechAlternatePathWithBFS(graph, vtx, visited) == true) return true;
                if (checkAlternatePathWithDFS(graph, vtx, -1, visited) == true) return true;
            }
        }
        return false;
    }
}
