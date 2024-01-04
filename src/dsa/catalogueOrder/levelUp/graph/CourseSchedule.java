package dsa.catalogueOrder.levelUp.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/course-schedule/
// 1. Topological Sort
// 2. Kahn's Algorithm
public class CourseSchedule {
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

         // checking if the given graph was a Directed Acyclic graph or not
        if(idx == numCourses) return true;
        else return false;
    }
}
