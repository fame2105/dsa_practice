package dsa.catalogueOrder.levelUp.stack;

import java.util.Stack;

public class CheckIfWordIsValidAfterSubstitutions {
    // Idea to solve this question is based on
    // if we could remove all abc from the given string then we should be able to get an empty string in the end
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == 'c') {
                if(st.size() >= 2 && st.pop() == 'b' && st.pop() == 'a') {
                    // do nothing // this if checks if abc could be removed or invalid word was given
                } else {
                    return false;
                }
            } else {
                st.push(ch);
            }
        }
        return st.size() == 0;
    }
}
