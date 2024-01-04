package dsa.catalogueOrder.foundation.stackAndQueue;

import java.util.Stack;

// Link: https://leetcode.com/problems/sum-of-subarray-minimums/description/
// Editorial (Must Read) : https://leetcode.com/problems/sum-of-subarray-minimums/solutions/2700011/sum-of-subarray-minimums/
public class _907_SumOfSubArrayMinimums_MonotonoicStack {

    // This could ofcourse be done in O(n2) time complexity but this approach is o(n) which is more efficient

    public int sumSubarrayMins(int[] arr) {
        long MOD = 1000000007l;
        long sum = 0l;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i <= arr.length ; i++) {
            while(st.size() > 0 && (i == arr.length || arr[st.peek()] >= arr[i])) {
                int mid = st.pop();
                int leftBoundary = st.size() > 0 ? st.peek() : -1;
                int rightBoundary = i;
                long count = (rightBoundary - mid) * (mid - leftBoundary) % MOD;
                sum += (count * arr[mid]) % MOD;
                sum = sum % MOD;
            }
            st.push(i);
        }
        return (int) sum;
    }
}
