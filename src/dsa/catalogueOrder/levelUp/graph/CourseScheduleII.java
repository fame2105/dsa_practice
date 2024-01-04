package dsa.catalogueOrder.levelUp.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/course-schedule-ii/
// 1. Topological Sort
// 2. Kahn's Algorithm
public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];

        List<Integer>[] graph = new ArrayList[numCourses];

        // initialize graph
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];
            indegree[v] += 1;
            graph[u].add(v);
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) q.add(i);
        }

        int[] result = new int[numCourses];
        int idx = numCourses - 1; // filing courses/vtx from back because topological sort is opposite of dependencyResolution/courseSchedule
        while (q.size() > 0) {
            int rem = q.remove();
            result[idx--] = rem;

            for (int nbr : graph[rem]) {
                indegree[nbr]--;
                if (indegree[nbr] == 0) {
                    q.add(nbr);
                }
            }
        }

        if (idx == -1) return result;
        else return new int[0];
    }
}
