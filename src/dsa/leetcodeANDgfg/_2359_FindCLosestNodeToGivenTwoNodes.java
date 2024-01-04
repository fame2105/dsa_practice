package dsa.leetcodeANDgfg;

import dsa.utility.Util;

import java.util.*;

// https://leetcode.com/problems/find-closest-node-to-given-two-nodes/
// BFS from 2 sources and then Min(MaxDistance from node1 and node2 to every node that could be reached)
public class _2359_FindCLosestNodeToGivenTwoNodes {
    public static void main(String[] args) {
        int[] edges = new int[]{4,4,8,-1,9,8,4,4,1,1};
        int node1 = 5;
        int node2 = 6;
        System.out.println("Ans = " + closestMeetingNode(edges, node1, node2));
    }

    public static int closestMeetingNode(int[] edges, int node1, int node2) {
        if(node1 == node2) return node1;

        int[] dist1 = bfs(node1, edges);
        int[] dist2 = bfs(node2, edges);

        Util.display(dist1, false);
        Util.display(dist2, false);

        int ans = Integer.MAX_VALUE;
        int nodeIdx = -1;
        for(int i = 0; i < edges.length; i++) {
            if(dist1[i] != -1 && dist2[i] != -1) {
               int maxDistance = Math.max(dist1[i], dist2[i]);
                if(maxDistance < ans) {
                    ans = maxDistance;
                    nodeIdx = i;
                } else if(ans == maxDistance) {
                    nodeIdx = Math.min(nodeIdx, i);
                }
            }
        }

        return nodeIdx;
    }

    private static int[] bfs(int vtx, int[] edges) {
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[edges.length];
        Arrays.fill(dist, -1);
        dist[vtx] = 0;
        q.add(vtx);

        int lvl = 0;
        boolean[] visited = new boolean[edges.length];
        while(q.size() > 0) {
            int rem = q.remove();

            if(visited[rem] == true){
                continue;
            }

            visited[rem] = true;
            dist[rem] = lvl;
            lvl++;

            int nbr = edges[rem];
            if(nbr != -1) {
                q.add(edges[rem]);
            }
        }
        return dist;
    }
}
