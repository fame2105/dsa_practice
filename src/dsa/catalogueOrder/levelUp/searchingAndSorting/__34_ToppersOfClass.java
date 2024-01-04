package dsa.catalogueOrder.levelUp.searchingAndSorting;

import java.util.PriorityQueue;

public class __34_ToppersOfClass {

    private static class Pair {
        int idx; // i
        int val; // marks[i]

        Pair(int idx, int val) {
            this.val = val;
            this.idx = idx;
        }
    }

    public static int[] kToppers(int[] marks, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> {
            if (p1.val != p2.val) {
                return p1.val - p2.val;
            } else {
                return p2.idx - p1.idx;
            }
        });

        for (int i = 0; i < k; i++) {
            pq.add(new Pair(i, marks[i]));
        }

        int[] ans = new int[k];
        int i = k;
        while (i < marks.length) {
            Pair rem = pq.peek();

            if (marks[i] > rem.val) {
                pq.remove();
                pq.add(new Pair(i, marks[i]));
            }

            i++;
        }

        i = k - 1;
        while (pq.size() > 0) {
            Pair p = pq.remove();
            ans[i--] = p.idx;
        }

        return ans;
    }
}
