package dsa.catalogueOrder.levelUp.stack;

import java.util.Stack;

//    https://leetcode.com/problems/trapping-rain-water/
public class TrappingRainWater {
    public int trap(int[] height) {
        int ans = 0;
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < height.length; i++) {
            while(st.size() > 0 && height[st.peek()] <= height[i]) {
                int rMax = i; // index of just greater element on the right for current

                int current = height[st.pop()]; // element for which we calculate the height/depth

                if(st.size() == 0) break;
                int lMax = st.peek(); // index of just greater element on the left of current

                int width = rMax - lMax - 1;
                ans += width * (Math.min(height[lMax], height[rMax]) - current);
            }
            st.push(i);
        }

        return ans;
    }
}
