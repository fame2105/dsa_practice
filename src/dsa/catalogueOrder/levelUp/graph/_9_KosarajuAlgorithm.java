package dsa.catalogueOrder.levelUp.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

// For getting count of Strongly Connected Components
public class _9_KosarajuAlgorithm {
    public static void main(String args[]) throws Exception {
        Scanner s = new Scanner(System.in);
        int v = s.nextInt();
        int e = s.nextInt();

        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < v; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < e; i++) {
            int src = s.nextInt() - 1; // vtx src
            int destn = s.nextInt() - 1; // vtx destn

            graph.get(src).add(destn);
        }

        boolean[] visited = new boolean[v];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < v; i++) {
            if(visited[i] == false) {
                dfs1(graph, i, stack, visited);
            }
        }

        List<List<Integer>> ngraph = new ArrayList<>(); // construct a new graph
        for(int i = 0; i < v; i++) {
            ngraph.add(new ArrayList<>());
        }

        for(int i = 0; i < v; i++) { // add edges in the new graph in reverse order
            List<Integer> nbrs = graph.get(i);
            for(int nbr : nbrs) {
                ngraph.get(nbr).add(i);
            }
        }

        int ans = 0;
        visited = new boolean[v];

        while(stack.size() > 0) { // perform dfs in new graph in stack order
            int rem = stack.pop();
            if(visited[rem] == false) {
                ans++;
                dfs2(ngraph, rem, visited);
            }
        }

        System.out.println(ans);
    }

    private static void dfs1(List<List<Integer>> graph, int src, Stack<Integer> stack, boolean[] visited) {
        visited[src] = true;

        List<Integer> nbrs = graph.get(src);
        for(int nbr : nbrs) {
            if(visited[nbr] == false) {
                dfs1(graph, nbr, stack, visited);
            }
        }

        stack.push(src);
    }

    private static void dfs2(List<List<Integer>> graph, int src, boolean[] visited) {
        visited[src] = true;

        List<Integer> nbrs = graph.get(src);
        for(int nbr : nbrs) {
            if(visited[nbr] == false) {
                dfs2(graph, nbr, visited);
            }
        }
    }
}
