package dsa.catalogueOrder.levelUp.stack;

import java.util.Stack;

public class __132Pattern {
    public boolean find132pattern(int[] nums) {
        int[] min = new int[nums.length];
        min[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            min[i] = Math.min(min[i - 1], nums[i]);
        }

        Stack<Integer> st = new Stack<>();
        boolean found = false;
        for (int j = nums.length - 1; j >= 0; j--) {
            while (st.size() > 0 && st.peek() <= min[j]) st.pop();

            if (st.size() > 0 && st.peek() < nums[j]) {
                found = true;
                break;
            }

            st.push(nums[j]);
        }

        return found;
    }
}
