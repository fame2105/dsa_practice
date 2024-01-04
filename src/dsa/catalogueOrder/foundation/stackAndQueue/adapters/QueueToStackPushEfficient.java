package dsa.catalogueOrder.foundation.stackAndQueue.adapters;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueToStackPushEfficient {
    Queue<Integer> mainQ;
    Queue<Integer> helperQ;

    public QueueToStackPushEfficient() {
        mainQ = new ArrayDeque<>();
        helperQ = new ArrayDeque<>();
    }

    int size() {
        // write your code here
        // return mainQ.size();
        return mainQ.size();
    }

    void push(int val) {
        mainQ.add(val);
    }

    int pop() {
        // check if Q is not empty
        if(mainQ.isEmpty()) {
            System.out.println("Queue underflow");
            return -1;
        }

        // remove n-1 elements from mainQ
        while (mainQ.size() > 1) {
            helperQ.add(mainQ.remove());
        }
        // remove nth element
        int val = mainQ.remove();

        // change the reference of mainQ and helperQ
        Queue<Integer> temp = mainQ;
        mainQ = helperQ;
        helperQ = temp;

        // return the nth value
        return val;
    }

    int top() {
        // check if Q is not empty
        if(mainQ.isEmpty()) {
            System.out.println("Queue underflow");
            return -1;
        }

        // remove n-1 elements from mainQ
        while (mainQ.size() > 1) {
            helperQ.add(mainQ.remove());
        }

        // get nth value from mainQ
        int val = mainQ.remove();
        // add nth value to helperQ
        helperQ.add(val);

        // change the reference of mainQ and helperQ
        Queue<Integer> temp = mainQ;
        mainQ = helperQ;
        helperQ = temp;

        // return nth value
        return val;
    }
}
