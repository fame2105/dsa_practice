package dsa.catalogueOrder.levelUp.graph;

import java.util.ArrayList;
import java.util.LinkedList;

// A mother vertex is a vtx/Node from which we can visit all the rest of the vtxes/Nodes in the graph... there could be more than 1 other vtx in a graph
public class _8_MotherVertex {
    public static int findMotherVertex(int vtxes, ArrayList<ArrayList<Integer>> graph){
        boolean[] visited = new boolean[vtxes];
        LinkedList<Integer> stack = new LinkedList<>();

        // Step 1 : random order dfs traversal for adding the elements in the stack while backtracking
        for(int v = 0; v < vtxes; v++) {
            if(visited[v] == false) {
                dfs1(graph, v, stack, visited);
            }
        }


        // Step 2: Remove top most element from the stack, and apply dfs traversal using top most element as source
        visited = new boolean[vtxes]; // reset visited array for traversing on graph again
        int motherVortexCandidate = stack.removeFirst(); // top most element is mother vortex candidate
        dfs2(graph, motherVortexCandidate, visited);

        // Step 3:  Verify that motherVortexCandidate visited all the elements in the graph
        for(int i = 0; i < vtxes; i++) {
            if(visited[i] == false) return -1;
        }

        return motherVortexCandidate;
    }

    // dfs for adding the elements in stack
    private static void dfs1(ArrayList<ArrayList<Integer>> graph, int src, LinkedList<Integer> stack, boolean[] visited) {
        visited[src] = true;

        ArrayList<Integer> nbrs = graph.get(src);
        for(int nbr : nbrs) {
            if(visited[nbr] == false) {
                dfs1(graph, nbr, stack, visited);
            }
        }
        stack.addFirst(src);
    }

    // standard dfs traversal from any given source
    private static void dfs2(ArrayList<ArrayList<Integer>> graph, int src, boolean[] visited) {
        visited[src] = true;

        ArrayList<Integer> nbrs = graph.get(src);
        for(int nbr : nbrs) {
            if(visited[nbr] == false) {
                dfs2(graph, nbr, visited);
            }
        }
    }
}
