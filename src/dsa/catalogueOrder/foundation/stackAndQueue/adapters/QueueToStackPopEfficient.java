package dsa.catalogueOrder.foundation.stackAndQueue.adapters;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueToStackPopEfficient {
    Queue<Integer> mainQ;
    Queue<Integer> helperQ;

    public QueueToStackPopEfficient() {
        mainQ = new ArrayDeque<>();
        helperQ = new ArrayDeque<>();
    }

    int size() {
        // write your code here
        return mainQ.size();
    }

    // storing all elements in mainQ in reverse order
    void push(int val) {
        // copy all elements from mainQ to helperQ
        while (!mainQ.isEmpty()) {
            helperQ.add(mainQ.remove());
        }
        // store current element in mainQ
        mainQ.add(val);


        // copy back all elements from helperQ to mainQ
        while (!helperQ.isEmpty()) {
            mainQ.add(helperQ.remove());
        }
    }

    int pop() {
        // check if  Queue is empty
        if (mainQ.isEmpty()) {
            System.out.println("Stack underflow");
            return -1;
        }

        return mainQ.remove();
    }

    int top() {
        // check if  Queue is empty
        if (mainQ.isEmpty()) {
            System.out.println("Stack underflow");
            return -1;
        }

        return mainQ.peek();
    }
}
