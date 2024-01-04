package dsa.catalogueOrder.levelUp.graph.remaining;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Sample Questions:
 // 1. Course Schedule
 // 2. Course Schedule II

/**
 * As per Kahn's algorithm, we need to
 * 1. find indegree of each node
 * 2. Nodes with indegrees as 0 should be put in queue.
 * 3. For each element in queue, decrement the indegree of its neighbours and put it in queue if its indgeree has reduced to 0
 *
 * note : Kahn's algorithm for topological sorting cannot be applied to directed cyclic graphs or any undirected graphs
 *        this algorithm only applies to Directed Acyclic Graphs
 */
public class KahnsAlgorithmForTopologicalSort {
    // course Schedule : https://leetcode.com/problems/course-schedule/
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];

        List<Integer>[] graph = new ArrayList[numCourses];

        // initialize graph
        for(int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            indegree[v] += 1;
            graph[u].add(v);
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0 ; i < numCourses; i++) {
            if(indegree[i] == 0) q.add(i);
        }

        int idx = 0;
        while(q.size() > 0) {
            int rem = q.remove();

            for(int nbr : graph[rem]) {
                indegree[nbr]--;
                if(indegree[nbr] == 0) {
                    q.add(nbr);
                }
            }
            idx++;
        }

        if(idx == numCourses) return true;
        else return false;
    }

    // course Schedule II  : https://leetcode.com/problems/course-schedule-ii/
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];

        List<Integer>[] graph = new ArrayList[numCourses];

        // initialize graph
        for(int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            indegree[v] += 1;
            graph[u].add(v);
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0 ; i < numCourses; i++) {
            if(indegree[i] == 0) q.add(i);
        }

        int[] result = new int[numCourses];
        int idx = numCourses-1; // 0 indexing
        while(q.size() > 0) {
            int rem = q.remove();
            result[idx--] = rem;

            for(int nbr : graph[rem]) {
                indegree[nbr]--;
                if(indegree[nbr] == 0) {
                    q.add(nbr);
                }
            }
        }

        if(idx == -1) return result;
        else return new int[0];
    }
}
