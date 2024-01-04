package dsa.catalogueOrder.foundation.stackAndQueue;

import dsa.utility.Util;

import java.util.Scanner;
import java.util.Stack;

public class NextGreaterElementToTheRight {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }

        Util.display(nextGreaterElementToTheRight(a), true);
    }

    // traversing from right to left and works on values
    private static int[] nextGreaterElementToTheRight(int[] a) {
        int[] result = new int[a.length];
        Stack<Integer> st = new Stack<>();
        st.push(a[a.length - 1]);
        result[result.length - 1] = -1;
        for(int i = a.length - 2; i >= 0; i--) {
            int currentElement = a[i];
            while(!st.isEmpty() && currentElement > st.peek()) st.pop();

            if(st.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = st.peek();
            }
            st.push(currentElement);
        }
        return result;
    }

    // traverses left to right and works on indexes
    private static int[] nextGreaterElementToTheRightAlternativeSolution(int[] a) {
        int[] result = new int[a.length];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i< a.length; i++) {
            int currentElement = a[i];
            while(!st.isEmpty() && currentElement > a[st.peek()]) {
                int smallerElementIndex = st.pop();
                result[smallerElementIndex] = currentElement;
            }
            st.push(i);
        }

        while(!st.isEmpty()) {
            int idx = st.pop();
            result[idx] = -1;
        }
        return result;
    }
}
