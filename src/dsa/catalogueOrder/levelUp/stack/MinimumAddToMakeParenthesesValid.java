package dsa.catalogueOrder.levelUp.stack;

import java.util.Stack;

public class MinimumAddToMakeParenthesesValid {
    public static int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        int i = 0;
        int counter = 0;
        while(i < s.length()) {
            char ch = s.charAt(i++);
            if(ch == '(') {
                st.push(ch);
            } else if (ch == ')') {
                if(st.size() > 0) {
                    st.pop();
                } else {
                    counter++;
                }
            }
        }
        return counter + st.size();
    }
}
