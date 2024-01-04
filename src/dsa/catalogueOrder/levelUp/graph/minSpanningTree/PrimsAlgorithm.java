package dsa.catalogueOrder.levelUp.graph.minSpanningTree;

import java.util.List;
import java.util.PriorityQueue;

public class PrimsAlgorithm {
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
        int acquiredFromVtx; // parent
        int wt;

        public Pair(int vtx, int acquiredFromVtx, int weightSoFar) {
            this.vtx = vtx;
            this.acquiredFromVtx = acquiredFromVtx;
            this.wt = weightSoFar;
        }

        @Override
        public int compareTo(Pair o) {
            return this.wt - o.wt;
        }
    }

    // provides shortest path from src to destination (Single Source Shortest Path Algo)
    public void dijkstra(List<Edge>[] graph, int src) {
        boolean[] visited = new boolean[graph.length];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src, -1, 0));

        while (pq.size() > 0) {
            Pair rem = pq.remove();

            if (visited[rem.vtx] == true) {
                continue;
            }

            visited[rem.vtx] = true;

            System.out.println(rem.vtx + " via " + rem.acquiredFromVtx + " @ " + rem.wt);

            for (Edge edge : graph[rem.vtx]) {
                if (visited[edge.nbr] == false)
                    pq.add(new Pair(edge.nbr, rem.vtx + edge.nbr, edge.wt));
            }
        }
    }
}
