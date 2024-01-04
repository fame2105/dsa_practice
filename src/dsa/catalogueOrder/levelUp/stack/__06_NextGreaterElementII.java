package dsa.catalogueOrder.levelUp.stack;

import java.util.Stack;

public class __06_NextGreaterElementII {
    public static int[] nextGreaterElementII(int[] nums) {
        Stack<Integer> st = new Stack<>();
        st.push(nums[nums.length-2]);

        for(int i = nums.length-3; i >= 0; i--) {
            int val = nums[i];

            while(st.size() > 0 && val >= st.peek()) {
                st.pop();
            }
            st.push(val);
        }

        int[] ans = new int[nums.length];
        for(int i = nums.length - 1; i >= 0; i--) {
            int val = nums[i];

            while(st.size() > 0 && val >= st.peek()) {
                st.pop();
            }

            if(st.size() > 0) {
                ans[i] = st.peek();
            } else {
                ans[i] = -1;
            }

            st.push(val);
        }
        return ans;
    }
}
