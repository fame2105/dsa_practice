package dsa.catalogueOrder.levelUp.stack;

import java.util.Stack;

public class __AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < asteroids.length; i++) {
            int val = asteroids[i];
            if(val > 0) {
                st.push(val);
            } else {
                while(st.size() > 0 && st.peek() > 0 && st.peek() < -val) {
                    st.pop();
                }
                if(st.size() > 0 && st.peek() > 0 && st.peek() == -val) {
                    st.pop();
                } else if(st.size() > 0 && st.peek() > -val) {
                    // do nothing
                } else {
                    st.push(val);
                }
            }

        }

        int[] ans = new int[st.size()];
        for(int i = ans.length-1; i>=0; i--) {
            ans[i] = st.pop();
        }

        return ans;
    }
}
