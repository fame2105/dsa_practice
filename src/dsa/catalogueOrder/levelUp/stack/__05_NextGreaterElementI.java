package dsa.catalogueOrder.levelUp.stack;

import java.util.HashMap;
import java.util.Stack;

public class __05_NextGreaterElementI {
    public static int[] nextGreaterElement(int[] arr, int[] query){
        HashMap<Integer, Integer> map = new HashMap<>();
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for (int i = 1; i < arr.length; i++) {
            int idx = i;
            int val = arr[i];

            while(st.size() > 0 && val > arr[st.peek()]) {
                int pop = st.pop();
                map.put(arr[pop], val);
            }

            st.push(idx);

        }

        while(st.size() > 0) {
            int pop = st.pop();
            map.put(arr[pop], -1);
        }

        int[] ans = new int[query.length];
        for(int i = 0; i < query.length; i++) {
            int key = query[i];
            int val = map.get(key);
            ans[i] = val;
        }
        return ans;
    }
}
