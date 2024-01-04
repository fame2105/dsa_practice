package dsa.catalogueOrder.levelUp.graph.singleSourceShortestPath;

import java.util.List;
import java.util.PriorityQueue;

/**
 * Single Source Shortest Path To All Vtxes/Nodes, does not for -ve weight edges
 */
public class DijkstraAlgorithm {
    private class Edge {
        int src;
        int nbr;
        int wt;

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    private class Pair implements Comparable<Pair> {
        int vtx;
        String pathSoFar;
        int weightSoFar;

        public Pair(int vtx, String pathSoFar, int weightSoFar) {
            this.vtx = vtx;
            this.pathSoFar = pathSoFar;
            this.weightSoFar = weightSoFar;
        }

        @Override
        public int compareTo(Pair o) {
            return this.weightSoFar - o.weightSoFar;
        }
    }

    // provides shortest path from src to all nodes (Single Source Shortest Path Algo)
    public void dijkstra(List<Edge>[] graph, int src) {
        boolean[] visited = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, "" + src, 0));

        while (pq.size() > 0) {
            Pair rem = pq.remove();

            if (visited[rem.vtx] == true) {
                continue;
            }

            visited[rem.vtx] = true;

            System.out.println(rem.vtx + " via " + rem.pathSoFar + " @ " + rem.weightSoFar);

            for (Edge edge : graph[rem.vtx]) {
                if (visited[edge.nbr] == false)
                    pq.add(new Pair(edge.nbr, rem.pathSoFar + edge.nbr, rem.weightSoFar + edge.wt));
            }
        }
    }

}
