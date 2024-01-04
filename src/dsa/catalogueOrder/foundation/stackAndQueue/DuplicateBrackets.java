package dsa.catalogueOrder.foundation.stackAndQueue;

import java.util.Scanner;
import java.util.Stack;

public class DuplicateBrackets {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();

        System.out.println(containsDuplicatedBrackets(str));
    }

    private static boolean containsDuplicatedBrackets(String str) {
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch != ')') {
                st.push(ch);
            } else { //we want to ensure that whenever we are popping then there should be some content between an opening and closing bracket... because if there was no content then that means there was an extra unneeded pair in the expression
                if(!st.isEmpty() && st.peek() == '(') return true;

                while(st.peek() != '(') st.pop(); //popping the content between '(' and ')' brackets
                st.pop(); //popping the '('
            }
        }
        return false;
    }

}
