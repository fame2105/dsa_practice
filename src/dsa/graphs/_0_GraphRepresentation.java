package dsa.graphs;

import java.util.ArrayList;
import java.util.List;

public class _0_GraphRepresentation {
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

    public static void main(String[] args) {
        driver();
    }

    public static void driver() {
        int[][] data = {
                {0,1,3},
                {0,3,40},
                {1,2,10},
                {2,3,10},
                {3, 4, 2},
                {4, 5, 3},
                {4, 6, 8},
                {5, 6, 3}
        }; // sample data

        ArrayList<Edge>[] graph = constructGraph(data);

        displayGraph(graph);
    }

    public static void displayGraph(List<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            String s = "[" + i +"] -> ";
            for(Edge edge : graph[i]) {
                s += "("+ edge.src+ "->" + edge.nbr + " @ "+ edge.weight + ")";
            }
            System.out.println(s);
            s = "";
        }
    }

    private static ArrayList<Edge>[] constructGraph(int[][] data) {
        int num_vertices = 7; // example

        ArrayList<Edge>[] graph = new ArrayList[num_vertices];

        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] arr: data) {
            addEdge(graph, arr[0], arr[1], arr[2]);
        }

        return graph;
    }

    private static void addEdge(ArrayList<Edge>[] graph, int v1, int v2, int wt) {
        graph[v1].add(new Edge(v1, v2, wt));
        graph[v2].add(new Edge(v2, v1, wt));
    }

}
