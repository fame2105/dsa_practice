package dsa.catalogueOrder.levelUp.graph.singleSourceShortestPath;

import java.util.Arrays;

// https://leetcode.com/problems/network-delay-time/
public class _743_NetworkDelayTime {
    // Use any Single Source Shortest path Algorithm (I have used Bellman Ford), could also be done using Dijkstra
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] cost = new int[n+1];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[0] = 0; // number of vtxes and edges are 1-based indexed which is why putting cost[0] = 0
        cost[k] = 0; // if we are starting from k-th vtx then cost of reaching k while standing at k = 0;

        //As per Bellman-Ford Algorithm, iterate on all edges, for  n-1 times .
        // n : total number of vtxes (because it takes at max n-1 iteration for the n-th vtx to calculate the cost of reaching th n-th vtx from the given source)
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < times.length; j++) {
                int u = times[j][0];
                int v = times[j][1];
                int wt = times[j][2]; // cost of reaching from u to v

                if(cost[u] == Integer.MAX_VALUE){
                    continue;
                }

                // if cost of reaching U from given source + wt(cost of reaching V from U) is lesser than the cost of reaching V from source then we have found a path that takes lesser cost to reach V.... update the cost of reaching V
                // this comparison and updating cost[v] with a smaller value is known as relaxing the edge as per Corman book
                if(cost[u] + wt < cost[v]) {
                    cost[v] = cost[u] + wt;
                }
            }
        }

        int minCost = Integer.MIN_VALUE;
        for(int val : cost) {
            if(val == Integer.MAX_VALUE) return -1; // we weren't able to reach a this vtx, which is why the cost of reaching it is still defined as infinity/Max_Value in the cost array
            minCost = Math.max(minCost, val);
        }
        return minCost;
    }
}
