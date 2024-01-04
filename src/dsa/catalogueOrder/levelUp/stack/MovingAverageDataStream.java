package dsa.catalogueOrder.levelUp.stack;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverageDataStream {
    int size;
    Queue<Integer> q;
    double sum;
    public MovingAverageDataStream(int size) {
        this.size = size;
        this.q = new LinkedList<>();
        this.sum = 0.0;
    }

    public double next(int val) {
        this.q.add(val);
        this.sum += val;
        while(this.q.size() > this.size) {
            int rem = this.q.remove();
            this.sum -= rem;
        }
        return this.sum / this.q.size();
    }
}
