package dsa.leetcodeANDgfg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// https://leetcode.com/problems/minimum-time-to-collect-all-apples-in-a-tree/
// #graph #DFS
public class _1443_Graph_MinTimeToCollectAllApplesInATree {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        boolean[] visited = new boolean[n];
        ArrayList<ArrayList<Integer>> graph = constructGraph(n, edges);
        return dfs(graph, 0, hasApple, visited) * 2;
    }

    private ArrayList<ArrayList<Integer>> constructGraph(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return graph;
    }

    private int dfs(ArrayList<ArrayList<Integer>> graph, int src, List<Boolean> hasApple, boolean[] visited) {
        visited[src] = true;

        int myDist = 0;
        int dist = 0;

        for(int nbr : graph.get(src)) {
            if(visited[nbr] == false) {
                dist += dfs(graph, nbr, hasApple, visited);
            }
        }

        /**
         * 1. Don't include src in your distance, because cost of reaching src is 0
         * 2. Add 1 to myDist if your current src has an apple.
         * 3. dist will be 0 if there are no apples present at your nbr or your's nbr's nbr and so on...
         but if any one of your nbr or your nbr's nbr and so on... has an apple then it should retrn 1 and not 0.
         * 4. Increment myDist by 1 if any of your nbr has returned dist > 0 because it means that the path to that nbr
         *    goes through you(current Node/src) and that should be contributed in the path calculations
         */

        if (src != 0 && (hasApple.get(src) == true || dist != 0)){
            myDist += 1;
        }

        myDist += dist;

        return myDist;
    }
}
