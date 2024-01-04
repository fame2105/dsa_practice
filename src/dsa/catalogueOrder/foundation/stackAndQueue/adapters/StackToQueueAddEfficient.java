package dsa.catalogueOrder.foundation.stackAndQueue.adapters;

import java.util.Stack;

public class StackToQueueAddEfficient {
    Stack<Integer> mainS;
    Stack<Integer> helperS;

    public StackToQueueAddEfficient() {
        mainS = new Stack<>();
        helperS = new Stack<>();
    }

    int size() {
        // write your code here
        return mainS.size();
    }

    void add(int val) {
        mainS.push(val);
    }

    int remove() {
        if (mainS.isEmpty()) {
            System.out.println("Queue underflow");
            return -1;
        }

        // push all elements from mainS to helperS
        while (mainS.size() > 1) {
            helperS.push(mainS.pop());
        }

        // get nth value
        int val = mainS.pop();

         // transfer values from helper to main
        while (!helperS.isEmpty()) {
            mainS.push(helperS.pop());
        }

        // return nth value;
        return val;
    }

    int peek() {
        // check if Stack is empty
        if (mainS.isEmpty()) {
            System.out.println("Queue underflow");
            return -1;
        }

        // push all elements from mainS to helperS
        while (mainS.size() > 1) {
            helperS.push(mainS.pop());
        }

        // get nth val
        int val = mainS.pop();

        // add nth value to helperS
        helperS.push(val);

        // transfer values from helper to main
        while (!helperS.isEmpty()) {
            mainS.push(helperS.pop());
        }

        // return nth value;
        return val;
    }
}
