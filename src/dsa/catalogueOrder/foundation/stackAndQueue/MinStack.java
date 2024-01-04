package dsa.catalogueOrder.foundation.stackAndQueue;

import java.util.Stack;

public class MinStack {
    Stack<Integer> st = new Stack<>();
    int min;


    public MinStack(Stack<Integer> st) {
        this.st = st;
        this.min = Integer.MAX_VALUE;
    }

    public int size() {
        return st.size();
    }

    public void push(int val) {
        if(val < min) {
            st.push(val + val - min);
        } else {
            st.push(val);
        }
    }

    int top() {
        if (size() == 0) {
            System.out.println("Stack underflow");
            return -1;
        }
        if (st.peek() < min) {
            return min;
        } else {
            return st.peek();
        }
    }

    int pop() {
        if(st.isEmpty()) {
            System.out.println("Stack underflow");
            return -1;
        }

        if(st.peek() > min) {
            int val = st.pop();
            return val;
        } else {
            int val = min;
            min = 2* val - st.pop();
            return val;
        }
    }
}
