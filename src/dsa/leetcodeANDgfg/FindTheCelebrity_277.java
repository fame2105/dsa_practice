package dsa.leetcodeANDgfg;

// https://leetcode.com/problems/find-the-celebrity/
// https://www.lintcode.com/problem/645/
public class FindTheCelebrity_277 {
    /**
     * @param n a party with n people
     * @return the celebrity's label or -1
     */
  /*  public int findCelebrity(int n) {
        // Write your code here

        Stack<Integer> st = new Stack<>();
        for(int i = 0; i< n; i++) {
            st.push(i);
        }

        while(st.size() > 1) {
            int val1 = st.pop();
            int val2 = st.pop();

     *//* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b);  -> knows method is defined in the question on portal*//*
            if (knows(val1, val2))
                st.push(val2);
            else
                st.push(val1);
        }

        int potentialCandidate = st.pop();
        for(int i = 0; i < n; i++) {
            if(knows(potentialCandidate, i)) return -1;
        }

        for(int i = 0; i < n; i++) {
            if(i != potentialCandidate && !knows(i, potentialCandidate)) return -1;
        }

        return potentialCandidate;
    }*/
}
