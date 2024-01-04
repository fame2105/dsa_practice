package dsa.catalogueOrder.levelUp.stack;

import java.util.Stack;

public class ValidateStackSequence {
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();
        int popPtr = 0;
        for(int i : pushed) {
            st.push(i);
            while(st.size() > 0 && popped[popPtr] == st.peek()) {
                st.pop();
                popPtr++;
            }
        }

        return popPtr == popped.length;
    }
}
