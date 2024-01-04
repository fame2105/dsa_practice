package dsa.catalogueOrder.levelUp.dynamicProgramming.knapsack;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FractionalKnapsack {

    private static class Pair {
        int wt;
        int val;
        double unitVal;

        public Pair(int wt, int val, double unitVal) {
            this.wt = wt;
            this.val = val;
            this.unitVal = unitVal;
        }
    }

    private double fractionalKnapsack(int[] weights, int[] values, int capacity) {
        int n = weights.length;
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return Double.compare(p2.unitVal, p1.unitVal);
            }
        });
        for(int i = 0; i < n; i++) {
            int wt = weights[i];
            int val = values[i];
            double unitVal = (double) val/wt; // this needs explicit conversion otherwise compiler performs integer division
            pq.add(new Pair(wt, val, unitVal));
        }

        double maxVal = 0.0;
        while(capacity > 0) {
            Pair p = pq.remove();
            if(capacity >= p.wt) {
                maxVal += p.val;
                capacity -= p.wt;
            } else {
                maxVal += p.unitVal * capacity;
                capacity = 0;
            }
        }

        return maxVal;
    }
}
