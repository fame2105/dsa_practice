package dsa.catalogueOrder.foundation.stackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
//        String str = s.nextLine();
        String str = "[(a + b) + {(c + d) * (e / f)}]";
        System.out.println(balancedBrackets(str));
    }

    private static boolean balancedBrackets(String str) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '[' || ch == '{') {
                st.push(ch);
            } else if (ch == ')') {
                if (!st.isEmpty() && st.peek() == '(') st.pop();
                else return false;
            } else if (ch == '}') {
                if (!st.isEmpty() && st.peek() == '{') st.pop();
                else return false;
            } else if (ch == ']') {
                if (!st.isEmpty() && st.peek() == '[') st.pop();
                else return false;
            }
        }
        return st.isEmpty();
    }
}
