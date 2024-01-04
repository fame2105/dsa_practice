package dsa.catalogueOrder.foundation.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/minimum-height-trees/
public class MinHeightTree {
    private class Edge {
        int src;
        int nbr;
        int degree;
        Edge(int src, int nbr) {
            this.src = src;
            this.nbr = nbr;
        }
    }

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n == 1) {
            List<Integer> ans = new ArrayList<>();
            ans.add(0);
            return ans;
        }

        List<Integer> ans = null;
        Queue<Integer> q = new LinkedList<>();

        int[] indegree = new int[n]; // calculate indegree while preparing the graph
        ArrayList<Edge>[] graph = constructGraph(edges, n, indegree);
        for(int i = 0; i < n; i++) {
            if(indegree[i] == 1) { // for all the vtx that have indegree == 1 add them in q and start reducing the indegree of all the nbr of such nodes
                indegree[i]--;
                q.add(i);
            }
        }

        while(q.size() > 0) {
            int size = q.size();
            ans = new ArrayList<>();
            while(size > 0) {
                Integer vtx = q.remove();
                List<Edge> nbrs = graph[vtx];
                for(Edge e : nbrs) {
                    indegree[e.nbr] -= 1;
                    if(indegree[e.nbr] == 1) { // if the indegress of nbr has reduced to 1 then add in queue
                        q.add(e.nbr);
                    }
                }
                ans.add(vtx);
                size--;
            }
        }
        return ans;
    }


    private ArrayList<Edge>[] constructGraph(int[][] edges, int n, int[] indegree) {
        ArrayList<Edge>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Edge>();
        }

        for(int[] edge : edges) {
            int v1 = edge[0];
            int v2 = edge[1];
            graph[v1].add(new Edge(v1, v2));
            graph[v2].add(new Edge(v2, v1));
            indegree[v1]++;
            indegree[v2]++;
        }

        return graph;
    }
}
