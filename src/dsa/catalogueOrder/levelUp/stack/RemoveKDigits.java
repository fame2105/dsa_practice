package dsa.catalogueOrder.levelUp.stack;

import java.util.Stack;

public class RemoveKDigits {
    public static void main(String[] args) {
        System.out.println(removeKDigits("112", 1));
        System.out.println(removeKDigits("1234567890", 9));
        System.out.println(removeKDigits("10200", 1));
        System.out.println(removeKDigits("1432219", 3));
        System.out.println(removeKDigits("10", 2));
    }

    public static String removeKDigits(String num, int k) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < num.length(); i++) {
            int digit = num.charAt(i) - '0';
            while (st.size() > 0 && digit < st.peek() && k > 0) {
                st.pop();
                k--;
            }
            st.push(digit);
        }

        while(k > 0 && st.size() > 0) {
            st.pop();
            k--;
        }

        String ans = "";
        while(st.size() > 0) {
            ans = st.pop() + ans;
        }

        // remove leading zeros
        int i = 0;
        for(i = 0; i < ans.length(); i++) {
            if(ans.charAt(i) != '0') {
                break;
            }
        }

        ans =  i > 0 ? ans.substring(i) : ans;
        return  ans.equals("") ? "0" : ans;
    }
}
