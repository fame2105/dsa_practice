package dsa.leetcodeANDgfg;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/minimum-genetic-mutation/
// #BFS
public class _433_Graph_MinimumGeneticMutation {
    public int minMutation(String start, String end, String[] bank) {

        HashSet<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();

        visited.add(start);
        q.add(start);

        int distance = 0;

        while(q.size() > 0) {
            int size = q.size();
            for(int i = 0; i < size; i++) {
                String currentNode = q.remove();
                if(currentNode.equals(end))
                    return distance;
                else {
                    visited.add(currentNode);
                    for(char c : new char[] {'A', 'C', 'G', 'T'}) {
                        for(int j = 0; j < currentNode.length(); j++) {
                            String nbr = currentNode.substring(0, j) + c + currentNode.substring(j+1); // Rule of mutation says only 1 character could change at a time... hence the loop
                            // check that nbr is a node that is not already visited and nbr should be a valid node... i.e should be present in the bank
                            if(visited.contains(nbr) == false && Arrays.asList(bank).contains(nbr)) {
                                q.add(nbr);
                            }
                        }
                    }
                }
            }
            distance += 1;
        }

        return -1;
    }
}
