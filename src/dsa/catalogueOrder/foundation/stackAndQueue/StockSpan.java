package dsa.catalogueOrder.foundation.stackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class StockSpan {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
    }

    private static int[] stockSpan(int[] a) {
        int[] result = new int[a.length];
        result[0] = 1;

        Stack<Integer> st = new Stack<>();
        st.push(0);

        for (int i = 1; i < a.length; i++) {
            int currentElement = a[i];
            while(!st.isEmpty() && currentElement > a[st.peek()]) st.pop();

            if(st.isEmpty()) {
                result[i] = i + 1;
            } else {
                result[i] = i - st.peek();
            }

            st.push(i);
        }

        return result;
    }
}
