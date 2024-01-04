package dsa.catalogueOrder.foundation.stackAndQueue;

import dsa.utility.Util;

import java.util.Scanner;
import java.util.Stack;

public class NextSmallerElementToTheLeft {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }

        Util.display(nextSmallerElementToTheLeft(a), false);
        System.out.println("--------------- printing indexes------------");
        Util.display(nextSmallerElementIndexToTheLeft(a), false);
    }

    public static int[] nextSmallerElementToTheLeft(int[] a) {
        int[] result = new int[a.length];
        result[0] = -1;

        Stack<Integer> st = new Stack<>();
        st.push(a[0]);

        for (int i = 1; i < a.length; i++) {
            int currentElement = a[i];

            while (!st.isEmpty() && currentElement <= st.peek()) st.pop();

            if (st.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = st.peek();
            }

            st.push(a[i]);
        }

        return result;
    }


    public static int[] nextSmallerElementIndexToTheLeft(int[] a) {
        int[] result = new int[a.length];
        result[0] = -1;

        Stack<Integer> st = new Stack<>();
        st.push(0);

        for (int i = 1; i < a.length; i++) {
            int currentElement = a[i];

            while (!st.isEmpty() && currentElement <= a[st.peek()]) st.pop();

            if (st.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = st.peek();
            }

            st.push(i);
        }

        return result;
    }
}
