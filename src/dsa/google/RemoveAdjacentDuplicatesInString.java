package dsa.google;

import java.util.Stack;

public class RemoveAdjacentDuplicatesInString {
    public static void main(String[] args) {
        String t1 = "deeedbbcccbdaa";
        int k1 = 3;

        String t2 = "abcd";
        int k2 = 2;

        String t3 = "pbbcggttciiippooaais";
        int k3 = 2;

        String t4 = "a";
        int k4 = 2;

        String ans = removeDuplicates(t4, k4);
        System.out.println(ans);
    }

    private static class Pair {
        char c;
        int count;

        Pair(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    public static String removeDuplicates(String s, int k) {
        if (s.length() == 1) return s;

        Stack<Pair> st = new Stack<>();
        st.push(new Pair(s.charAt(0), 1));

        int counter = 1;
        while (counter < s.length()) {
            Pair top = st.size() > 0 ? st.peek() : null;

            char nc = s.charAt(counter);
            counter++;

            if (st.size() == 0) {
                st.push(new Pair(nc, 1));
                continue;
            }

            if (top.c != nc) {
                st.push(new Pair(nc, 1));
            } else {
                if (top.count == k - 1) {
                    st.pop();
                } else {
                    top.count++;
                }
            }
        }

        String ans = "";
        while (st.size() > 0) {
            Pair top = st.pop();
            while(top.count > 0) {
                ans = top.c + ans;
                top.count--;
            }
        }

        return ans;
    }
}
