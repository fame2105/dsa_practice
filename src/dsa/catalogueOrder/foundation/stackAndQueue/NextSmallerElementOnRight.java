package dsa.catalogueOrder.foundation.stackAndQueue;

import dsa.utility.Util;

import java.util.Scanner;
import java.util.Stack;

public class NextSmallerElementOnRight {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }

        Util.display(nextSmallerElementToTheRight(a), false);
        System.out.println("Printing Indexes of smaller elements to the right");
        Util.display(nextSmallerElementIndexToTheRight(a), false);

    }

    public static int[] nextSmallerElementToTheRight(int[] a) {
        int[] result = new int[a.length];
        Stack<Integer> st = new Stack<>();
        st.push(a[a.length - 1]);
        result[result.length - 1] = -1;
        for(int i = a.length - 2; i >= 0; i--) {
            int currentElement = a[i];
            while(!st.isEmpty() && currentElement <= st.peek()) st.pop();

            if(st.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = st.peek();
            }
            st.push(currentElement);
        }
        return result;
    }

    public static int[] nextSmallerElementIndexToTheRight(int[] a) {
        int[] result = new int[a.length];
        result[result.length - 1] = -1;

        Stack<Integer> st = new Stack<>();
        st.push(a.length - 1);

        for(int i = a.length - 2; i >= 0; i--) {
            int currentElement = a[i];

            while(!st.isEmpty() && currentElement <= a[st.peek()]) st.pop();

            if(st.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = st.peek();
            }

            st.push(i);
        }
        return result;
    }
}
