package dsa.catalogueOrder.levelUp.graph;

import java.util.ArrayList;

public class CheckIfEulerianPathAndCircuitExistsInUndirectedGraph {

    /**
     * Eulerian Path is almost same as Hamiltonian path except Hamiltonian concept plays on Vtx (travel each vtx exactly once)
     * where as, in Eulerian path we say if we can traverse all the edges in graph exactly once then there is eulerian Path present
     * In case of Eulerian Circuit... if the starting vtx is equal to the last vtx we reach after travelling the entire path then
     * eulerian circuit is present.....
     * If Eulerian Circuit is present then obviouly eulerian path is present too.
     *
     *
     * In case of a directed graph if
     * 1. indegree == outdegree for each node then there is Eulerian Circuit present in the graph
     * 2. indegree == outdegree for exaclty n-2 nodes and for the remaining 2 nodes
     *                              1 of the nodes has indegree == outdegree + 1
     *                              the other node has outdegree == indegree + 1
     *
     */
    public int isEularCircuitExist(int V, ArrayList<ArrayList<Integer>> adj) {
        //Calclulate Degrees -> for undirected graph

        int odd = 0;
        for(int i = 0; i < adj.size(); i++) {
            if(adj.get(i).size() % 2 != 0) {
                odd++;
            }
        }

        if(odd == 2) { // if there are exactly 2 nodes/vtx that have odd number of edges then it indicates Eulerian Path is present
            return 1; // Eulerian Path exists
        } else if(odd == 0) { // if there are no such nodes/vtx that have odd number of edges then it indicates Eulerian Cicuit is present
            return 2; // Eulerian Circuit exists
        } else {
            return 0; // Neither Eulerian path nor circuit exists
        }
    }
}
