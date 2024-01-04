package dsa.catalogueOrder.levelUp.stack;

import java.util.Stack;

public class MaximalRectangle {

    public static int maximalRectangle(int[][] ar) {
        int[] histogram = new int[ar[0].length];
        for(int j = 0; j < ar[0].length; j++) {
            histogram[j] = ar[0][j];
        }

        int area = largestRectangleArea(histogram);
        for(int i = 1; i < ar.length; i++) {
            for(int j = 0; j < ar[0].length; j++) {
                if(ar[i][j] == 0) {
                    histogram[j] = 0;
                } else {
                    histogram[j]++;
                }
            }
            area = Math.max(area, largestRectangleArea(histogram));
        }
        return area;
    }

    private static int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int maxArea = 0;
        for(int i = 0; i <= heights.length; i++) {

            int val = (i == heights.length) ? 0 : heights[i];

            while(st.peek() != -1 && val <= heights[st.peek()]) {
                int rMin = i;
                int height = heights[st.pop()];
                int lMin = st.peek();
                int width = rMin - lMin - 1;
                int area = height * width;
                maxArea = Math.max(maxArea, area);
            }

            st.push(i);
        }

        return maxArea;
    }
}
