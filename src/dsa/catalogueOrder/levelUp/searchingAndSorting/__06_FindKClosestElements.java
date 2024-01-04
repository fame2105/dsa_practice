package dsa.catalogueOrder.levelUp.searchingAndSorting  ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class __06_FindKClosestElements {

    private static class Pair {
        int element;
        int gap;

        public Pair(int element, int gap) {
            this.element = element;
            this.gap = gap;
        }
    }

    // Approach - 01 -> There is a better approach than this one
    public static ArrayList<Integer> findClosest(int[] arr, int k, int x) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> { return p2.gap - p1.gap; }); // Max PriorityQueue
        int i = 0;
        for(i = 0; i < k; i++) {
            pq.add(new Pair(arr[i], Math.abs(arr[i] - x)));
        }

        while(i < arr.length) {
            int element = arr[i];
            int gap = Math.abs(element - x);
            i++;

            Pair peek = pq.peek();

            if(gap < peek.gap) {
                pq.remove();
                pq.add(new Pair(element, gap));
            } else if(gap == peek.gap) {
                if(element < peek.element) {
                    pq.remove();
                    pq.add(new Pair(element, gap));
                }
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while(pq.size() > 0) {
            Pair p = pq.remove();
            ans.add(p.element);
        }

        Collections.sort(ans);
        return ans;
    }
}
