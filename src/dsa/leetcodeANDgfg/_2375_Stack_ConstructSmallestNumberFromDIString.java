package dsa.leetcodeANDgfg;

import java.util.Stack;

//    https://leetcode.com/problems/construct-smallest-number-from-di-string/
public class _2375_Stack_ConstructSmallestNumberFromDIString {
    public String smallestNumber(String pattern) {
        int num = 1;
        Stack<Integer> st = new Stack<>();

        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (c == 'D') {
                st.push(num);
                num++;
            } else {
                st.push(num);
                num++;

                while (st.size() > 0) {
                    sb.append(st.pop());
                }
            }
        }

        st.push(num);
        while (st.size() > 0) sb.append(st.pop());

        return sb.toString();
    }
}
