package dsa.catalogueOrder.foundation.graph;

import java.util.ArrayList;
import java.util.HashSet;

public class HamiltonianCycle {
    private class Edge {
        int vtx;
        int nbr;
        int wt;

        public Edge(int vtx, int nbr, int wt) {
            this.vtx = vtx;
            this.nbr = nbr;
            this.wt = wt;
        }
    }
    private static void printHamiltonianPathsAndCycle(ArrayList<Edge>[] graph, int originSource, int src, String psf, HashSet<Integer> visited) {
        if(visited.size() == graph.length - 1) {
            psf += src;

            boolean isCyclic = false; // if their exists a direct edge between originSource and last node, then path is a Hamiltonian Cycle
            for(Edge e : graph[src]) {
                if(e.nbr == originSource) {
                    isCyclic = true;
                    break;
                }
            }

            if(isCyclic == true) {
                System.out.println(psf + "*");
            } else {
                System.out.println(psf + ".");
            }
        }

        visited.add(src);
        for(Edge e : graph[src]) {
            int nbr = e.nbr;
            if(visited.contains(nbr) == false) {
                printHamiltonianPathsAndCycle(graph, originSource, nbr, psf + src, visited);
            }
        }
        visited.remove(src);
    }
}
