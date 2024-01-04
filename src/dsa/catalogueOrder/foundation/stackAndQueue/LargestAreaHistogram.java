package dsa.catalogueOrder.foundation.stackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class LargestAreaHistogram {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        System.out.println(largestAreaHistogram(a));
    }

    public static int largestAreaHistogram(int[] arr) {
        int maxArea = 0;
        int[] lsi = leftSmallerIndex(arr);
        int[] rsi = rightSmallerIndex(arr);

        for (int i = 0; i < lsi.length; i++) {
            int width = rsi[i] - lsi[i] - 1;
            int height = arr[i];

            maxArea = Math.max(maxArea, width * height);
        }

        return maxArea;
    }

    // indexes of each smaller element to the right of it
    private static int[] rightSmallerIndex(int[] arr) {
        int[] result = new int[arr.length];
        result[result.length - 1] = -1;

        Stack<Integer> st = new Stack<>();
        st.push(arr.length - 1);

        for (int i = arr.length - 2; i >= 0; i--) {
            int currentElement = arr[i];

            while (!st.isEmpty() && currentElement <= arr[st.peek()]) st.pop();

            if (st.isEmpty()) {
                result[i] = arr.length;
            } else {
                result[i] = st.peek();
            }

            st.push(i);
        }
        return result;
    }

    // indexes of each smaller element to the left of it
    private static int[] leftSmallerIndex(int[] arr) {
            int[] result = new int[arr.length];
            result[0] = -1;

            Stack<Integer> st = new Stack<Integer>();
            st.push(0);

            for(int i = 1; i < arr.length; i++) {
                int currentElement = arr[i];

                while(!st.isEmpty() && currentElement <= arr[st.peek()]) st.pop();

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
