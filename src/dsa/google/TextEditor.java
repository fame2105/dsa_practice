package dsa.google;

import java.util.Stack;

// https://binarysearch.com/problems/Text-Editor
public class TextEditor {
    public String solve(String s) {
        Stack<Character> st = new Stack<>();

        int idx = 0;
        while(idx < s.length()) {
            char c = s.charAt(idx);
            if(c == '<' && idx + 1 < s.length() && s.charAt(idx+1) == '-') {
                if(st.size() > 0)
                    st.pop();

                idx++;
            } else {
                st.push(c);
            }

            idx++;
        }

        StringBuilder sb = new StringBuilder("");
        while(st.size() > 0) {
            sb.append(st.pop());
        }

        sb.reverse();
        return sb.toString();
    }
}
