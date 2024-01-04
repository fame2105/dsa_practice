package dsa.catalogueOrder.foundation.HashMapAndHeap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianPriorityQueue {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianPriorityQueue() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }

    public void add(int val) {
        if(right.size() > 0 && val > right.peek()) { // add in right when val is greater than right.peek()
            right.add(val);
        } else {
            left.add(val);
        }

        // difference management
        if(left.size() - right.size() == 2)  {
            right.add(left.remove());
        } else if(right.size() - left.size() == 2) {
            left.add(right.remove());
        }
    }

    public int remove() {
        if(this.size() == 0) {
            System.out.println("Underflow");
            return -1;
        }

        int leftSize = left.size();
        int rightSize = right.size();

        int data = 0;
        if(rightSize > leftSize) data = right.remove();
        else data = left.remove();

        return data;
    }

    public int peek() {
        if(this.size() == 0) {
            System.out.println("Underflow");
            return -1;
        }

        int leftSize = left.size();
        int rightSize = right.size();


        if(rightSize > leftSize) return right.peek();
        else return left.peek();
    }

    public int size() {
        return left.size() + right.size();
    }
}
