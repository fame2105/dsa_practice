package dsa.catalogueOrder.levelUp.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseStringsBetweenParenthesis {
    public static String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();
        int i = 0;
        while(i < s.length()) {
            char ch = s.charAt(i++);
            if(ch != ')') {
                st.push(ch);
            } else {
                Queue<Character> q = new LinkedList<>();
                while(st.peek() != '(') {
                    q.add(st.pop());
                }
                st.pop(); // remmove '('
                while(q.size() > 0) {
                    st.push(q.remove());
                }
            }
        }
        StringBuilder ans = new StringBuilder("");
        while(st.size() > 0) {
            ans = new StringBuilder(st.pop() + ans.toString());
        }
        return ans.toString();
    }
}
