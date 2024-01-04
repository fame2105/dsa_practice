package dsa.catalogueOrder.levelUp.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// https://leetcode.com/problems/number-of-ways-to-arrive-at-destination/
public class NumberOfWaysToArriveAtDestination {
    public int countPaths(int n, int[][] roads) {
        List<Edge>[] graph = constructGraph(n, roads);

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        int[] path = new int[n];

        pq.add(new Pair(0, 0)); // Pair(vtx, weight)
        dist[0] = 0;
        path[0] = 1;

        int modVal = (int)1e9 + 7;
        while(pq.size() > 0) {
            Pair rem = pq.remove();

            for(Edge e : graph[rem.vtx]) {
                int nbr = e.nbr;
                int nbrdist = e.wt; // nbrdist is the wt between remv.wtx(U) and its neighbour(V)
                if(rem.wsf + nbrdist < dist[nbr]) {
                    dist[nbr] = rem.wsf + nbrdist;
                    path[nbr] = path[rem.vtx];
                    pq.add(new Pair(nbr, dist[nbr]));
                } else if(rem.wsf + nbrdist == dist[nbr]) { // this check denotes that we reach this nbr previously and now again at same cost
                    path[nbr] += path[e.src];
                    path[nbr] = path[nbr] % modVal;
                }
            }
        }

        return path[n-1];
    }

    private class Pair implements Comparable<Pair>{
        int vtx;
        int wsf;
        Pair(int vtx, int wsf) {
            this.vtx = vtx;
            this.wsf = wsf;
        }

        public int compareTo(Pair o) {
            return this.wsf - o.wsf;
        }
    }

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

    private List<Edge>[] constructGraph(int n, int[][] roads) {
        List<Edge>[] graph = new ArrayList[n];

        for(int i = 0; i < n; i++) { // initializing graph[] with empty arrayLists
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < roads.length; i++) {
            int u = roads[i][0];
            int v = roads[i][1];
            int wt = roads[i][2];

            graph[u].add(new Edge(u, v, wt));
            graph[v].add(new Edge(v, u, wt));
        }

        return graph;
    }
}
