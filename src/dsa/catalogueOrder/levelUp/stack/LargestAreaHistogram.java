package dsa.catalogueOrder.levelUp.stack;

import java.util.Stack;

public class LargestAreaHistogram {
    public static int largestRectangleArea(int[] heights) {
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
