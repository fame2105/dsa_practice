package dsa.catalogueOrder.levelUp.stack;

import java.util.Stack;

public class ScoreOfParenthesis {
    public static int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int i = 0;
        while(i < s.length()) {
            char ch = s.charAt(i++);
            if (ch == '(') {
                st.push(-1);
            } else {
                if(st.peek() == -1) {
                    st.pop();
                    st.push(1);
                } else {
                    int val = 0;
                    while(st.peek() != -1) {
                        val += st.pop();
                    }
                    val *= 2;
                    st.pop();
                    st.push(val);
                }
            }
        }

        int val = 0;
        while(st.size() > 0) {
            val += st.pop();
        }
        return val;
    }
}
