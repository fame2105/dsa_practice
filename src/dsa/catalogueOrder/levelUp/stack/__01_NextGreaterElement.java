package dsa.catalogueOrder.levelUp.stack;

import java.util.Stack;

public class __01_NextGreaterElement {
    public static int[] solve(int[] arr){
        int[] ans = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for (int i = 1; i < arr.length; i++) {
            int idx = i;
            int val = arr[i];

            while(st.size() > 0 && val > arr[st.peek()]) {
                int pop = st.pop();
                ans[pop] = val;
            }

            st.push(idx);

        }

        while(st.size() > 0) {
            int pop = st.pop();
            ans[pop] = -1;
        }
        return ans;
    }
}
