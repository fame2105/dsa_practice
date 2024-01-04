package dsa.catalogueOrder.levelUp.dynamicProgramming.LongestIncreasingSubsequence;

import java.util.LinkedList;
import java.util.Queue;

public class _3_PrintAllLongestIncreasingSubsequences {

    private static class Pair {
        int idx;
        int len;
        int val;
        String psf;

        Pair(int idx, int len, int val, String psf) {
            this.idx = idx;
            this.len = len;
            this.val = val;
            this.psf = psf;
        }
    }

    public static void solution(int[] nums) {
        int overallMax = 0;
        int overallMaxIdx = 0;

        int[] dp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            int currLen = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    currLen = Math.max(currLen, dp[j]);
                }
            }

            dp[i] = currLen + 1;
            if (dp[i] > overallMax) {
                overallMax = dp[i];
                overallMaxIdx = i;
            }
        }
        Pair p = new Pair(overallMaxIdx, overallMax, nums[overallMaxIdx],
                "" + nums[overallMaxIdx]);

        printAllLongestIncreasingSubsequences(nums, dp, p);
    }

    private static void printAllLongestIncreasingSubsequences(int[] nums, int[] dp, Pair p) {
        Queue<Pair> q = new LinkedList<>();
        q.add(p);
        while (q.size() > 0) {
            Pair rem = q.remove();
            if (rem.len == 1) {
                System.out.println(rem.psf);
            }
            for (int i = 0; i < rem.idx; i++) {
                if (nums[i] < rem.val && dp[i] < rem.len) {
                    q.add(new Pair(i, dp[i], nums[i], nums[i] + " " + rem.psf));
                }
            }
        }
    }
}
