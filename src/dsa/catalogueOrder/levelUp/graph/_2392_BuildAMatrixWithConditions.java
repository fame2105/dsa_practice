package dsa.catalogueOrder.levelUp.graph;

import java.util.*;

// https://leetcode.com/problems/build-a-matrix-with-conditions/
//# Based on Kahn's Algorithm'
public class _2392_BuildAMatrixWithConditions {
    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        ArrayList<Integer> rowOrder = getOrder(rowConditions, k);
        ArrayList<Integer> colOrder = getOrder(colConditions, k);


        // kahn's algo only works on Directed Acyclic Graphs,
        // So if there would be a cycle in the graph then we could never have processed all the nodes
        if(rowOrder.size() != k || colOrder.size() != k) return new int[0][0]; // empty array

        // print(rowOrder, "Row Order = ");
        // print(colOrder, "Col Order = ");

        // This is just an inverse mapping of any array behaviour
        // Arrays work like this => INPUT : idx then OUTPUT = arr[idx](this is value)
        // This mapping provides inverse behaviour => INPUT = value then OUTPUT = map.get(value) (this is idx)
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < k; i++)
            map.put(colOrder.get(i), i);

        // System.out.println(map);

        int[][] ans = new int[k][k];
        for (int i = 0; i < k; i++) {
            // we could also use colOrder, to get the number to be placed...
            int numToBePlaced = rowOrder.get(i);
            int row = i;
            int col = map.get(numToBePlaced);
            // System.out.println("Position = " + row + " , " + col + " and Val is : " + numToBePlaced);
            ans[row][col] = numToBePlaced;
        }

        return ans;
    }

    // Kahn's Algorithm
    private ArrayList<Integer> getOrder(int[][] preconditions, int nodeCount) {
        int[] indegree = new int[nodeCount];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        // Initializing Graph by adding empty arrayLists
        for(int i = 0; i < nodeCount; i++) {
            graph.add(new ArrayList<>());
        }

        // Construct Graph by iterating over the given preconditions and also calculating indegree for each node
        for(int i = 0; i < preconditions.length; i++) {
            int[] edge = preconditions[i];
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            graph.get(u).add(v);
            indegree[v] += 1;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < indegree.length; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        ArrayList<Integer> order = new ArrayList<>();
        while(q.size() > 0) {
            int remNode = q.remove();
            order.add(remNode + 1); // 1-indexed order, but graph that we constructed is 0-indexed

            for(int nbr : graph.get(remNode)) {
                indegree[nbr] -= 1;
                if(indegree[nbr] == 0) q.add(nbr);
            }
        }

        return order;
    }

    // For debugging Purposes
    private void print(ArrayList<Integer> order, String message) {
        if(message != null) {
            System.out.print("\n " + message);
        } else {
            System.out.print("\n");
        }

        for(int val : order) {
            System.out.print(val + " ");
        }
    }
}
