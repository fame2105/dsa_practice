package dsa.catalogueOrder.levelUp.stack;

import java.util.Stack;

public class OnlineStockSpan {
    private class Pair {
        int idx;
        int price;
        Pair(int idx, int price) {
            this.idx = idx;
            this.price = price;
        }
    }

    int counter;
    Stack<Pair> st;
    public OnlineStockSpan() {
        this.counter = 0;
        this.st = new Stack<>();
        Pair base = new Pair(-1, Integer.MAX_VALUE);
        st.push(base);
    }

    public int next(int price) {
        Pair pair = new Pair(this.counter, price);
        this.counter++;
        while(price >= st.peek().price) {
            st.pop();
        }

        int span = pair.idx - st.peek().idx;

        st.push(pair);
        return span;
    }
}
