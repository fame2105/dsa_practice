package dsa.leetcodeANDgfg;

import java.util.*;

//    https://leetcode.com/problems/amount-of-time-for-binary-tree-to-be-infected/ #graph #BFS
public class _2385_AmountOfTimeForBinaryTreeToBeAffected {

    private class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    public int amountOfTime(TreeNode root, int start) {
        HashMap<Integer, List<Integer>> graph = new HashMap<>(); // NodeNumber : [EdgeNumber,.....]

        constructGraph(root, null, graph);

        // applyBFS on graph
        int maxTime = bfs(graph, start);

        return maxTime;
    }

    // This method traverses the given Tree and constructs a graph in the passed HashMap
    private void constructGraph(TreeNode root, TreeNode parent, HashMap<Integer, List<Integer>> graph) {
        if(root == null) return;


        List<Integer> edges = graph.getOrDefault(root.val, new ArrayList<>());
        if(root.left != null) {
            edges.add(root.left.val);
            constructGraph(root.left, root, graph);
        }

        if(root.right != null) {
            edges.add(root.right.val);
            constructGraph(root.right, root, graph);
        }

        if(parent != null) edges.add(parent.val);

        graph.put(root.val, edges);
    }


    private int bfs(HashMap<Integer, List<Integer>> graph, int start) {
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();

        q.add(start);
        visited.add(start);
        int time = -1;

        while(q.size() > 0) {

            time += 1;
            int size = q.size();

            while(size > 0) {
                int rem = q.remove();
                List<Integer> nbrs = graph.get(rem);

                for(int nbr : nbrs) {
                    if(visited.contains(nbr) == false) {
                        q.add(nbr);
                        visited.add(nbr);
                    }
                }

                size -= 1;
            }
        }
        return time;
    }
}
