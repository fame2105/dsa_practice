package dsa.leetcodeANDgfg;

import java.util.Deque;
import java.util.LinkedList;

public class JumpGame6 {
    // inefficient solution.
//     public int maxResult(int[] nums, int k) {
//         int len = nums.length;

//         int[] dp = new int[len];
//         dp[len-1] = nums[len-1];

//         for(int i = len - 2; i >=0; i--) {
//             int maxScore = Integer.MIN_VALUE;
//             for(int j = i+1; j <= i+k && j < len; j++) {
//                 maxScore = Math.max(maxScore, dp[j]);
//             }
//             dp[i] = nums[i] + maxScore;
//         }

//         return dp[0];
//     }

    public int maxResult(int[] nums, int k) {
        int len = nums.length;

        int[] dp = new int[len];
        dp[len-1] = nums[len-1];
        Deque<Integer> q = new LinkedList<>();
        q.add(len - 1);


        for(int i = len - 2; i >=0; i--) {
            if(q.peek() - i > k) q.removeFirst(); // remove as normal as in queue

            dp[i] = nums[i] + dp[q.peek()];

            while(q.size() > 0 && dp[i] > dp[q.peekLast()]) q.removeLast(); // remove from opposite end from queue

            q.add(i);

        }

        return dp[0];
    }
}
