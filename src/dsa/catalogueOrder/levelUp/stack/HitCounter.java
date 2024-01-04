package dsa.catalogueOrder.levelUp.stack;

import java.util.LinkedList;
import java.util.Queue;

public class HitCounter {

    /** Initialize your data structure here. */
    private Queue<Integer> q;
    public HitCounter() {
        this.q = new LinkedList<>();
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        q.add(timestamp);
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int min = timestamp - 300;
        while(q.peek() <= min) {
            q.remove();
        }
        return q.size();
    }
}
