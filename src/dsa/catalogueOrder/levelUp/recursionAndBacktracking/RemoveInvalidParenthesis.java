package dsa.catalogueOrder.levelUp.recursionAndBacktracking;

import java.util.HashSet;
import java.util.Stack;

public class RemoveInvalidParenthesis {
    public static void main(String[] args) {
        String input = "(())))";
        printValidSequences(input, getMin(input), new HashSet<String>());
    }

    private static void printValidSequences(String str, int minRemovalAllowed, HashSet<String> uniqueValidString) {
        if(minRemovalAllowed == 0) {
            if(getMin(str) == 0) {
                if(!uniqueValidString.contains(str)) {
                    System.out.println(str);
                    uniqueValidString.add(str);
                }
            }
            return;
        }

        for(int i = 0; i < str.length(); i++) {
            String left = str.substring(0,i);
            char currentChar = str.charAt(i);
            String right = str.substring(i+1);
            printValidSequences(left+right, minRemovalAllowed-1, uniqueValidString);
        }
    }

    private static int getMin(String str) {
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch == '(') {
                st.push(ch);
            } else if (ch == ')') {
                if(!st.isEmpty() && st.peek() == '('){
                    st.pop();
                } else {
                    st.push(ch);
                }
            } else {
                continue;
            }
        }

        return st.size();
    }
}
