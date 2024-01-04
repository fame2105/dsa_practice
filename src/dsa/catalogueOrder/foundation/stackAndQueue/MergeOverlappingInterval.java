package dsa.catalogueOrder.foundation.stackAndQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class MergeOverlappingInterval {

    public static void main(String[] args) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(2);
        map.put(1, list);
        for(int i: map.keySet()) {
            System.out.println(map.get(i));
        }

    }

    public static class Pair implements Comparable<Pair> {
        int start;
        int end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Pair o) {
            return this.start - o.start;
        }
    }

    public static void mergeOverlappingInterval(int[][] arr) {
        Pair[] pairs = new Pair[arr.length];
        for (int i = 0; i < arr.length; i++) {
            pairs[i] = new Pair(arr[i][0], arr[i][1]);
        }
        Arrays.sort(pairs);

        Stack<Pair> st = new Stack<>();
        st.push(pairs[0]);

        for (int i = 1; i < pairs.length; i++) {
            Pair p = pairs[i];
            // intervals could be merged if start time of this interval is lesser than end time of prev interval
            if (p.start <= st.peek().end) {
                st.peek().end = Math.max(st.peek().end, p.end); // end time should be max(currentIntervalEnd, prevIntervalEnd)
            } else { // this interval can't be merged with prev... push onto stack
                st.push(p);
            }
        }

        Stack<Pair> reverseStack = new Stack<>();

        while (!st.isEmpty()) reverseStack.push(st.pop());

        while (!reverseStack.isEmpty()) {
            Pair p = reverseStack.pop();
            System.out.println(p.start + " " + p.end);
        }
    }

}
