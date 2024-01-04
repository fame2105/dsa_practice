package dsa.catalogueOrder.levelUp.graph.articulationPointAndBridges;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _12_CriticalConnection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int vtxes = scanner.nextInt();
        int edges = scanner.nextInt();

        List<List<Integer>> graph = new ArrayList<>();
        for (int vtx = 0; vtx < vtxes; vtx++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < edges; i++) {
            int src = scanner.nextInt();
            int nbr = scanner.nextInt();

            graph.get(src).add(nbr);
            graph.get(nbr).add(src);
        }
    }

    public static List<List<Integer>> criticalConnections(int n, List<List<Integer>> graph) {
        List<List<Integer>> criticalConnections = new ArrayList<>();

        int[] parent = new int[n];
        int[] disc = new int[n];
        int[] reach = new int[n];
        boolean[] visited = new boolean[n];

        int src = 0;
        parent[src] = -1;
        dfs(graph, src, parent, disc, reach, visited, criticalConnections);

        return criticalConnections;
    }

    static int timeOfDiscovery = 0;
    private static void dfs(List<List<Integer>> graph, int src, int[] parent, int[] disc, int[] reach, boolean[] visited, List<List<Integer>> criticalConnections) {
        visited[src] = true;
        disc[src] = timeOfDiscovery;
        reach[src] = timeOfDiscovery;

        timeOfDiscovery++;

        List<Integer> nbrs = graph.get(src);
        for(int i = 0; i < nbrs.size(); i++) {
            int nbr = nbrs.get(i);
            if(parent[src] == nbr) {
                continue;
            } else if (visited[nbr] == true) {
                reach[src] = Math.min(reach[src], disc[nbr]);
            } else {
                parent[nbr] = src;
                dfs(graph, nbr, parent, disc, reach, visited, criticalConnections);

                reach[src] = Math.min(reach[src], reach[nbr]);

                if(reach[nbr] > disc[src]) { // src is an articulation point
                    ArrayList<Integer> criticalConnection = new ArrayList<>();
                    criticalConnection.add(src);
                    criticalConnection.add(nbr);
                    criticalConnections.add(criticalConnection);
                }
            }
        }
    }
}
