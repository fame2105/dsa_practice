package dsa.catalogueOrder.levelUp.stack;

import java.util.Stack;

public class RemoveOutermostParenthesis {
    public static String removeOuterParentheses(String s) {
        if(s.isEmpty()) return s;

        Stack<Character> st = new Stack<>();
        int i = 0;
        StringBuilder ans = new StringBuilder("");
        while(i < s.length()) {
            char c = s.charAt(i++);
            if(c == '(') {
                if(st.size() > 0) ans.append(c);
                st.push(c);
            } else {
                st.pop();
                if(st.size() > 0) ans.append(c);
            }
        }
        return ans.toString();
    }
}
