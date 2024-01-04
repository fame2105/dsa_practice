package dsa.catalogueOrder.levelUp.stack;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCallsCounter {

    private Queue<Integer> q;
    public RecentCallsCounter() {
        this.q = new LinkedList<>();
    }

    public int ping(int t) {
        q.add(t);
        int min = t - 3000;
        while(q.peek() < min) {
            q.remove();
        }
        return q.size();
    }
}
