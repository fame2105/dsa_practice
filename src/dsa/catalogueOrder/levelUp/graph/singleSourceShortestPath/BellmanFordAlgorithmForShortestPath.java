package dsa.catalogueOrder.levelUp.graph.singleSourceShortestPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Single Source Shortest Path To All Vtxes/Nodes
 * Bellman Ford does the same thing as Dijkstra Algo but Bellman also works with -ve weight edges.
 */
public class BellmanFordAlgorithmForShortestPath {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] st = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]); // count of vtx
        int m = Integer.parseInt(st[1]); // no of edges

        int[][] edges = new int[m][3];
        for (int i = 0; i < m; i++) {
            st = br.readLine().split(" ");
            int u = Integer.parseInt(st[0]) - 1;
            int v = Integer.parseInt(st[1]) - 1;
            int wt = Integer.parseInt(st[2]);
            edges[i][0] = u;
            edges[i][1] = v;
            edges[i][2] = wt;
        }

        int[] path = new int[n];
        Arrays.fill(path, Integer.MAX_VALUE);

        path[0] = 0; // cost of reaching 0 while standing on 0 is 0.
        bellmanFord(edges, path, n);

        for (int i = 1; i < n; i++) {
            if (path[i] != Integer.MAX_VALUE) {
                System.out.print(path[i] + " ");
            } else {
                System.out.print(1000000000 + " ");
            }
        }
    }

    private static void bellmanFord(int[][] edges, int[] path, int n) {
        for (int i = 0; i < n - 1; i++) { // n-1 iterations on the given edges, n is th count of vtxes in the graph
            for (int j = 0; j < edges.length; j++) {
                int u = edges[j][0];
                int v = edges[j][1];
                int wt = edges[j][2];

                if (path[u] == Integer.MAX_VALUE) {
                    continue;
                }

                if (path[u] + wt < path[v]) {
                    path[v] = path[u] + wt;
                }
            }
        }
    }
}
