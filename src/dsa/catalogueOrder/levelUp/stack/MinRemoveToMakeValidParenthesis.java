package dsa.catalogueOrder.levelUp.stack;

import java.util.Stack;

public class MinRemoveToMakeValidParenthesis {
    public static String minRemoveValidParenthesis(String s) {
        char[] c = s.toCharArray();

        Stack<Integer> st = new Stack<>();
        int i = 0;
        while (i < c.length) {
            char ch = c[i];
            if (ch == '(') {
                st.push(i);
            } else if (ch == ')') {
                if (st.isEmpty()) {
                    c[i] = '.';
                } else {
                    st.pop();
                }
            }
            i++;
        }

        while (st.size() > 0) {
            c[st.pop()] = '.';
        }

        StringBuilder sb = new StringBuilder("");
        for (char ch : c) {
            if (ch == '.') continue;

            sb.append(ch);
        }

        return sb.toString();
    }
}
