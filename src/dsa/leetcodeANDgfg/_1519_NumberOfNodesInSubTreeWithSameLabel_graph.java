package dsa.leetcodeANDgfg;

import java.util.ArrayList;
import java.util.HashMap;

// https://leetcode.com/problems/number-of-nodes-in-the-sub-tree-with-the-same-label/description/
public class _1519_NumberOfNodesInSubTreeWithSameLabel_graph {
    public int[] countSubTrees(int n, int[][] edges, String labels) {
        ArrayList<ArrayList<Integer>> graph = constructGraph(n, edges);
        boolean[] visited = new boolean[n];
        int[] ans = new int[n];
        dfs(graph, 0, visited, labels, ans);
        return ans;
    }

    private ArrayList<ArrayList<Integer>> constructGraph(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        // initializing graph
        for(int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        return graph;
    }

    private HashMap<Character, Integer> dfs(ArrayList<ArrayList<Integer>> graph, int src, boolean[] visited, String labels, int[] ans) {
        visited[src] = true;
        char myChar = labels.charAt(src);
        HashMap<Character, Integer> myMap = new HashMap<>(); // For each vtx, we create a new HashMap
        myMap.put(myChar, 1); // because it is given in the question that every node is a part of its subtrees

        for(int nbr : graph.get(src)) {
            if(visited[nbr] == false) {
                HashMap<Character, Integer> cmap = dfs(graph, nbr, visited, labels, ans); // Each nbr returns a hashMap
                for(char key : cmap.keySet()) { // Merge the hashMap returned by nbr/child with the map we created at current level.
                    if(myMap.containsKey(key) == false) {
                        myMap.put(key, cmap.get(key));
                    } else {
                        myMap.put(key, myMap.get(key) + cmap.get(key));
                    }
                }
            }
        }
        ans[src] = myMap.get(myChar); // update answer for curr src
        return myMap;
    }
}
