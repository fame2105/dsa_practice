package dsa.catalogueOrder.levelUp.stack;

import java.util.Stack;

public class __03_NextSmallerElementRight {

    public static int[] solve(int[] arr) {
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);

        for(int i = 0; i < arr.length; i++) {
            int val = arr[i];

            while(st.size() > 0 && val < arr[st.peek()]) {
                int popIdx = st.pop();
                ans[popIdx] = val;
            }
            st.push(i);
        }

        while(st.size() > 0) {
            int popIdx = st.pop();
            ans[popIdx] = -1;
        }
        return ans;
    }
}
