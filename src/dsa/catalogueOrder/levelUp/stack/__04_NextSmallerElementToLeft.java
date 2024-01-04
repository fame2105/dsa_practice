package dsa.catalogueOrder.levelUp.stack;

import java.util.Stack;

public class __04_NextSmallerElementToLeft {

    public static int[] solve(int[] arr) {
        int[] ans = new int[arr.length];
        ans[0] = -1;

        Stack<Integer> st = new Stack<>();
        st.push(0);
        for (int i = 1; i < arr.length; i++) {
            int val = arr[i];

            while (st.size() > 0 && val < arr[st.peek()]) {
                st.pop();
            }

            if(st.size() > 0) {
                int peekIdx = st.peek();
                ans[i] = arr[peekIdx];
            } else {
                ans[i] = -1;
            }

            st.push(i);
        }
        return ans;
    }
}
