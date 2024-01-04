package dsa.leetcodeANDgfg;

// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/description/

import java.util.Stack;

public class _1047_RemoveAllAdjacentDuplicatesInString {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("aababaab"));
    }
    public static String removeDuplicates(String s) {
        StringBuilder sb = new StringBuilder(s);
        int idx = 1;
        while(idx < sb.length()) {
            while(idx > 0 && idx < sb.length() && sb.charAt(idx) == sb.charAt(idx - 1)) {
                sb.deleteCharAt(idx);
                sb.deleteCharAt(idx-1);
                idx -= 1;
            }
            idx += 1;
        }

        return sb.toString();
    }

    public String removeDuplicates_ApproachII(String s) {
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()) {
            if(!st.isEmpty() && st.peek() == c) st.pop();
            else st.push(c);
        }

        s = "";

        while(!st.isEmpty()) {
            s = st.pop() + s;
        }
        return s;
    }
}
