package dsa.catalogueOrder.foundation.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {

    public static class Edge {
        int v1; // src
        int v2; // dest
        int wt; // weight for travelling form src to dest

        public Edge(int v1, int v2, int wt) {
            this.v1 = v1;
            this.v2 = v2;
            this.wt = wt;
        }
    }

    public static void main(String[] args) {
        driver();
    }


    private static void driver() {

        ArrayList<Edge>[] graph = constructGraph();

        display(graph);

        System.out.println("Check if there is any path between 0 to 6 : ");
        System.out.print(hasPath(graph, 0, 6, new boolean[graph.length]) + "\n");

        System.out.println("Print all Paths");
        printAllPaths(graph, 0, 6, "", 0, new boolean[graph.length]);
    }

    private static ArrayList<Edge>[] constructGraph() {
        int n = 7; // number of vertices
        ArrayList<Edge>[] graph = new ArrayList[n]; // one array_idx for one vtx   ... 0 based indexing

        // initially at each array idx the value are null, by initializing it we are creating empty array List for each vtx.
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        int[][] data = { // this data will be given in the question for creating Adjacency List
                {0, 1, 3}, // src, destination, weight
                {0, 3, 40},
                {1, 2, 10},
                {2, 3, 10},
                {3, 4, 2},
                {4, 5, 3},
                {4, 6, 8},
                {5, 6, 3}
        };

        for (int[] arr : data) {
            addEdge(graph, arr[0], arr[1], arr[2]);
        }

        return graph;
    }

    // this implementation assumes that given graph is undirected, hence adding edges for both vtxes(v1 and V2)
    private static void addEdge(ArrayList<Edge>[] graph, int v1, int v2, int wt) {
        graph[v1].add(new Edge(v1, v2, wt));
        graph[v2].add(new Edge(v2, v1, wt));
    }

    private static void display(List<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            String s = "[" + i + "] -> ";
            for (Edge edge : graph[i]) {
                s += "(" + edge.v1 + "->" + edge.v2 + " @ " + edge.wt + ")";
            }
            System.out.println(s);
            s = "";
        }
    }

    private static boolean hasPath(List<Edge>[] graph, int src, int dest, boolean[] visited) {
        if (src == dest) return true;

        visited[src] = true;
        for (Edge edge : graph[src]) { // get all the edges/neighbours of src
            int neighbour = edge.v2;
            if (visited[neighbour] == false) { // if neighbour is not yet visited
                boolean resultPath = hasPath(graph, neighbour, dest, visited); // visit neighbour
                if (resultPath) return true;
            }
        }
        visited[src] = false;
        return false;
    }

    private static void printAllPaths(List<Edge>[] graph, int src, int dest, String path, int sum, boolean[] visited) {
        if (src == dest) {
            path += dest;
            System.out.println(path + "@" + sum);
            return;
        }

        visited[src] = true;
        for (Edge edge : graph[src]) {
            int neighbour = edge.v2;
            if (visited[neighbour] == false) {
                printAllPaths(graph, neighbour, dest, path + src, sum + edge.wt, visited);
            }
        }
        visited[src] = false;
    }

    private static String spath;
    private static Integer spathwt = Integer.MAX_VALUE;
    private static String lpath;
    private static Integer lpathwt = Integer.MIN_VALUE;
    private static String cpath;
    private static Integer cpathwt = Integer.MAX_VALUE;
    private static String fpath;
    private static Integer fpathwt = Integer.MIN_VALUE;
    // use a priority queue for kth largest path
    //    private static PriorityQueue<Pair> pq = new PriorityQueue<>();
    private static void multiSolver(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, int criteria, int k, String psf, int wsf) {
        if(src == dest) {
            if(spathwt < wsf) {
                spath = psf;
                spathwt = wsf;
            }

            if(wsf > lpathwt) {
                lpath = psf;
                lpathwt = wsf;
            }

            if(wsf > criteria && wsf < cpathwt) {
                cpathwt = wsf;
                cpath = psf;
            }

            if(wsf < criteria && wsf > fpathwt) {
                fpath = psf;
                fpathwt = wsf;
            }
        }

        visited[src] = true;
        for (Edge edge : graph[src]) {
            int nbr = edge.v2;
            if (visited[nbr] == false) {
                multiSolver(graph, nbr, dest, visited, criteria, k, psf + src, wsf + edge.wt);
            }
        }
        visited[src] = false;
    }

    public static List<List<Integer>> getConnectedComponents(List<Edge>[] graph) {
        List<List<Integer>> components = new ArrayList<>();
        int n = graph.length;
        boolean[] visited = new boolean[n];
        for (int v = 0; v < graph.length; v++) {
            if (visited[v] == false) {
                components.add(getConnectedComponentsHelper(graph, v, visited));
            }
        }
        return components;
    }

    private static List<Integer> getConnectedComponentsHelper(List<Edge>[] graph, int src, boolean[] visited) {
        visited[src] = true;
        List<Integer> comp = new ArrayList<>();
        List<Integer> subComponents = new ArrayList<>();
        for (Edge edge : graph[src]) {
            int nbr = edge.v2;
            if (visited[nbr] == false) {
                subComponents = getConnectedComponentsHelper(graph, nbr, visited);
            }
        }
        comp.addAll(subComponents);
        comp.add(src);
        return comp;
    }

    public static int countNumberOfIslands(int[][] graph) {
        int count = 0;
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] == 0) {
                    count++;
                    countNumIslandHelper(graph, i, j);
                }
            }
        }
        return count;
    }

    // order -> top, left, down, right
    static int[] xtDir = {-1, 0, 1, 0};
    static int[] ytDir = {0, -1, 0, 1};


    private static void countNumIslandHelper(int[][] graph, int x, int y) {
        graph[x][y] = -1; // marker
        for (int d = 0; d < 4; d++) {
            int r = x + xtDir[d];
            int c = y + ytDir[d];
            if (r >= 0 && r < graph.length && c >= 0 && c < graph[0].length && graph[r][c] == 0) { // 0 denotes land and 1 denotes water
                countNumIslandHelper(graph, r, c);
            }
        }
    }

    // Hamiltonian Path is a path where starting from a certain vtx, we are able to visit all the vtxes in that graph
    // A Hamiltonian path becomes a hamiltonian cycle if there exists an edge between the starting/origin vtx and the last visited vtx.
    public static void printAllHamiltonianPaths(List<Edge>[] graph, int src, int origin, HashSet<Integer> visited, String psf) {
        if (visited.size() == graph.length - 1) {
            psf += src;
            System.out.println(psf);

            boolean isCyclic = false;
            for (Edge e : graph[src]) {
                if (e.v2 == origin) {
                    isCyclic = true;
                    break;
                }
            }

            if (isCyclic == true) {
                System.out.println("*");
            } else {
                System.out.println(".");
            }
            return;
        }

        visited.add(src);
        for (Edge edge : graph[src]) {
            int nbr = edge.v2;
            if (visited.contains(nbr) == false) {
                printAllHamiltonianPaths(graph, nbr, origin, visited, psf + src);
            }
        }
        visited.remove(src);
    }

    public static class BFSPair {
        int vtx;
        String psf;

        public BFSPair(int vtx, String psf) {
            this.vtx = vtx;
            this.psf = psf;
        }
    }

    public void bfs(List<Edge>[] graph, int src) {
        Queue<BFSPair> q = new LinkedList<>();
        boolean[] visited = new boolean[graph.length];
        q.add(new BFSPair(src, "" + src));
        while (q.size() > 0) {
            // step 1: Get and remove
            BFSPair rem = q.remove();
            // step 2:  Mark
            if (visited[rem.vtx] == true) {
                // already visited
                continue;
            } else {
                // mark this
                visited[rem.vtx] = true;

                // perform work -> print this
                System.out.println(rem.vtx + "@" + rem.psf);

                //add neighbours
                for (Edge e : graph[rem.vtx]) {
                    q.add(new BFSPair(e.v2, rem.psf + e.v2));
                }
            }
        }
    }

    // n -> number of vertices
    private static boolean isCyclic(int n, List<List<Integer>> graph) {
        boolean[] visited = new boolean[n];
        boolean[] myPath = new boolean[n];
        for (int i = 0; i < n; i++) {
            boolean res = detectCycleInDirectedGraph(graph, i, visited, myPath);
            if (res == true) return true;
        }
        return false;
    }

    private static boolean detectCycleInDirectedGraph(List<List<Integer>> graph, int src, boolean[] visited, boolean[] myPath) {
        visited[src] = true;
        myPath[src] = true;
        for (int nbr : graph.get(src)) {
            if (myPath[nbr] == true) {
                boolean res = detectCycleInDirectedGraph(graph, nbr, visited, myPath);
                if (res == true) return true;
            } else if (visited[nbr] == false) {
                boolean res = detectCycleInDirectedGraph(graph, nbr, visited, myPath);
                if (res == true) return true;
            }
        }
        myPath[src] = false;
        return false;
    }
}
