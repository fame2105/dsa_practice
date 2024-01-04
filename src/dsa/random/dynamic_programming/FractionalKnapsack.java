package dsa.random.dynamic_programming;

import java.util.Collections;
import java.util.PriorityQueue;

// it is not a DP problem
public class FractionalKnapsack {
    public static void main(String[] args) throws Exception {
        int[] val = new int[]{33, 14, 50, 9, 8, 11, 6, 40, 2, 15}; // values

        int[] wt = new int[]{7, 2, 5, 9, 3, 2, 1, 10, 3, 3}; // wt

        int cap = 6; // bag capacity

        double maxProfit = fractionalKnapsack(wt, val, cap);
        System.out.println(maxProfit);
    }

    static class FPair implements Comparable<FPair>{
        int wt;
        int val;
        double perUnitProfit;

        public FPair(int wt, int val) {
            this.wt = wt;
            this.val = val;
            this.perUnitProfit = (this.val * 1.0) / this.wt;
        }

        @Override
        public int compareTo(FPair o) {
            // do not return this.perUnitProfit - o.perUnitProfit
            // because we are comparing fractions and if the difference is less than 1 then decimal part is ignored
            // Example 1.73 - 1.50 = 0.23 .. since we return int, .23 will be dropped and we will return 0.
            if(this.perUnitProfit > o.perUnitProfit) {
                return 1;
            } else if(this.perUnitProfit < o.perUnitProfit) {
                return -1;
            } else {
                return 0;
            }
        }
    }

    private static double fractionalKnapsack(int[] wt, int[] val, int bagCapacity) {
        PriorityQueue<FPair> pq = new PriorityQueue<>(Collections.reverseOrder()); // max Priority Queue

        for (int i = 0; i < wt.length; i++) {
            pq.add(new FPair(wt[i], val[i]));
        }

        double profit = 0.0;
        while (pq.size() > 0 && bagCapacity > 0) {
            FPair item = pq.remove();

            if (item.wt <= bagCapacity) { // consume this item fully
                profit += item.val;
                bagCapacity = bagCapacity - item.wt;
            } else {
                profit += item.perUnitProfit * bagCapacity;
                bagCapacity = 0;
            }
        }
        return profit;
    }

}
