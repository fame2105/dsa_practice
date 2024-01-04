package dsa.graphs;

public class _2_PrintAllPaths {

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
}
