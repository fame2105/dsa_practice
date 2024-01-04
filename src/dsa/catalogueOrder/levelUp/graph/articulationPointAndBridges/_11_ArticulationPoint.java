package dsa.catalogueOrder.levelUp.graph.articulationPointAndBridges;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _11_ArticulationPoint {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int vtxes = s.nextInt();
        int edges = s.nextInt();

        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < vtxes; i++) { // initialize graph
            graph.add(new ArrayList<Integer>());
        }

        for(int i = 0; i < edges; i++) {
            int src = s.nextInt() - 1; // constructing 0-based indexing for vertexes and nbrs
            int nbr = s.nextInt() - 1;

            // construct un-directed graph
            graph.get(src).add(nbr);
            graph.get(nbr).add(src);
        }

        int[] parent = new int[vtxes];
        int[] disc = new int[vtxes]; // discovery array
        int[] reach = new int[vtxes]; // lowest discovered vtx which is not in current vtx's path

        boolean[] articulationPoint = new boolean[vtxes];

        boolean[] visited = new boolean[vtxes];

        int src = 0; // assume any random start point for DFS traversal
        parent[src] = -1; // parent of start vtx will be -1

        dfs(graph, src, parent, disc, reach, articulationPoint, visited);

        int countArticulationPoint = 0;
        for(boolean vtx : articulationPoint) {
            if(vtx == true) countArticulationPoint++;
        }

        System.out.println(countArticulationPoint);
    }

    static int time = 0; // counter to increment the discovery of each vertex during DFS traversal
    private static void dfs(List<List<Integer>> graph, int src, int[] parent, int[] disc, int[] reach, boolean[] articulationPoint, boolean[] visited) {
        visited[src] = true;
        disc[src] = time;
        reach[src] = time;
        time++;

        int count = 0; // this will be used to check the articulationPoint for the source vtx.

        List<Integer> nbrs = graph.get(src);
        for(int i = 0; i < nbrs.size(); i++) {

            int nbr = nbrs.get(i);

            if(parent[src] == nbr) {
                continue;
            } else if(visited[nbr] == true) {
                reach[src] = Math.min(reach[src], disc[nbr]);
            } else {
                parent[nbr] = src;
                count++;
                dfs(graph, nbr, parent, disc, reach, articulationPoint, visited);

                reach[src] = Math.min(reach[src], reach[nbr]);

                if(parent[src] == -1) { // check if this src/vtx is a starting point in DFS traversal
                    // the original vtx that has parent == -1 has to be checked separately because it would always be determined as an articulation pt as per the logic
                    if(count == 2) articulationPoint[src] = true;
                } else if(reach[nbr] >= disc[src]) {
                    articulationPoint[src] = true;
                }
            }
        }
    }
}
