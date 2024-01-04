package dsa.catalogueOrder.foundation.stackAndQueue.adapters;

import java.util.Stack;

public class StackToQueuePopEfficient {
    Stack<Integer> mainS;
    Stack<Integer> helperS;

    public StackToQueuePopEfficient() {
        mainS = new Stack<>();
        helperS = new Stack<>();
    }

    int size() {
        return mainS.size();
    }

    void add(int val) {
        // pop all elements to helperS
        while(!mainS.isEmpty()) {
            helperS.push(mainS.pop());
        }

        // add to mainS
        mainS.add(val);

        // pop all elements from helperS to mainS
        while(!helperS.isEmpty()) {
            mainS.push(helperS.pop());
        }
    }

    int remove() {
        if(mainS.isEmpty()) {
            System.out.println("Queue underflow");
            return -1;
        }

        return mainS.pop();
    }

    int peek() {
        if(mainS.isEmpty()) {
            System.out.println("Queue underflow");
            return -1;
        }

        return mainS.peek();
    }
}
