package dsa.google;

import java.util.LinkedList;
import java.util.Queue;

// https://www.lintcode.com/problem/642/
public class MovingAverageFromDataStream {
    private class MovingAverage {
        /*
         * @param size: An integer
         */

        private Queue<Integer> q;
        private int k;
        private double sum;
        private int count;
        public MovingAverage(int size) {
            this.k = size;
            this.q = new LinkedList<>();
            this.sum = 0.0;
            this.count = 0;
        }

        /*
         * @param val: An integer
         * @return:
         */
        public double next(int val) {
            q.add(val);
            if(q.size() > k) {
                sum -= q.remove();
                this.count -= 1;
            }
            this.sum += val;
            this.count += 1;
            return sum/(double)count;
        }
    }
}
