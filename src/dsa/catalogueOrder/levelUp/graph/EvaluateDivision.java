package dsa.catalogueOrder.levelUp.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/evaluate-division/
public class EvaluateDivision {

    private class Edge {
        String vtx;
        String nbr;
        double wt;

        public Edge(String vtx, String nbr, double wt) {
            this.vtx = vtx;
            this.nbr = nbr;
            this.wt = wt;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "vtx='" + vtx + '\'' +
                    ", nbr='" + nbr + '\'' +
                    ", wt=" + wt +
                    '}';
        }
    }

    private Map<String, List<Edge>> constructGraph(List<List<String>> equations, double[] values) {
        Map<String, List<Edge>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String u = equation.get(0);
            String v = equation.get(1);
            double wt = values[i];
            addEdgeToGraph(graph, u, v, wt);
            addEdgeToGraph(graph, v, u, 1 / wt);
        }
        return graph;
    }

    private void addEdgeToGraph(Map<String, List<Edge>> graph, String vtx, String nbr, double wt) {
        if (graph.containsKey(vtx))
            graph.get(vtx).add(new Edge(vtx, nbr, wt));
        else {
            List<Edge> list = new ArrayList<Edge>();
            list.add(new Edge(vtx, nbr, wt));
            graph.putIfAbsent(vtx, list);
        }
    }

    private boolean dfs(Map<String, List<Edge>> graph, String src, String destination, double weightSoFar, double[] result, int queryIndex, HashSet<String> visited) {
        if(src.equals(destination)) {
            result[queryIndex] = weightSoFar;
            return true;
        }
        visited.add(src);

        for(Edge e : graph.get(src)) {
            if(visited.contains(e.nbr) == false) {
                boolean pathExists = dfs(graph, e.nbr, destination, weightSoFar * e.wt, result, queryIndex, visited);
                if(pathExists == true) return true;
            }
        }
        return false;
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Edge>> graph = constructGraph(equations, values);
        double[] result = new double[queries.size()];
        for(int i = 0; i < queries.size(); i++) {
            String u = queries.get(i).get(0);
            String v = queries.get(i).get(1);
            if(graph.containsKey(u) == false || graph.containsKey(v) == false) result[i] = -1.0;
            else if(u.equals(v)) result[i] = 1.0;
            else {
                HashSet<String> visited = new HashSet<>();
                boolean pathExists = dfs(graph, u, v, 1.0, result, i, visited);
                if(!pathExists) result[i] = -1.0;
            }
        }

        return result;
    }
}
