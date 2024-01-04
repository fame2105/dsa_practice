package dsa.catalogueOrder.levelUp.graph.singleSourceShortestPath;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class DijkstraImplementationBasedOnDistance {
    private class Edge {
        int src;
        int nbr;
        int wt; // weight/cost of travelling from src to neighbour while standing at src.

        Edge(int src, int nbr, int wt) {
            this.src = src;
            this.nbr = nbr;
            this.wt = wt;
        }
    }

    private class Pair implements Comparable<Pair> {
        int vtx;
        int weightSoFar;

        public Pair(int vtx, int weightSoFar) {
            this.vtx = vtx;
            this.weightSoFar = weightSoFar;
        }

        @Override
        public int compareTo(Pair o) {
            return this.weightSoFar - o.weightSoFar;
        }
    }

    // provides shortest path from src to all nodes (Single Source Shortest Path Algo)
    public void dijkstra(List<Edge>[] graph, int src) {
        // distance is based on weights, don't get confused by the naming... this array stores the least weight to reach every node from src
        int[] distance = new int[graph.length];
        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        pq.add(new Pair(src,0));
        distance[src] = 0; // distance of starting node from itself is 0;

        while (pq.size() > 0) {
            Pair rem = pq.remove();

            for (Edge edge : graph[rem.vtx]) {
                if(rem.weightSoFar + edge.wt < distance[edge.nbr]) {
                    distance[edge.nbr] = rem.weightSoFar + edge.wt;
                    pq.add(new Pair(edge.nbr, rem.weightSoFar + edge.wt));
                }
            }
        }

        // Now we have the shortest distance/cost/weight to reach from src to every node in the given graph in distance[] array
    }
}
