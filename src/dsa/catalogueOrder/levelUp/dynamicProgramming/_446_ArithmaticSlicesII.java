package dsa.catalogueOrder.levelUp.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

// Link : https://leetcode.com/problems/arithmetic-slices-ii-subsequence/description/
// Editorial : In smasung Notes OR https://www.youtube.com/watch?v=XjLT4TaXsgw&ab_channel=Pepcoding
public class _446_ArithmaticSlicesII {

    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length == 1 || nums.length == 2) return 0;

        Map<Integer, Integer>[] dp = new HashMap[nums.length];
        for(int i = 0; i < nums.length; i++) {
            dp[i] = new HashMap();
        }

        int ans = 0;
        for(int i = 1; i < dp.length; i++) {
            for(int j = 0; j < i; j++) {
                long commonDifference = (long)nums[i] - (long)nums[j];
                if(commonDifference <= Integer.MIN_VALUE || commonDifference >= Integer.MAX_VALUE){
                    continue;
                }

                Object playerId;
                int countOfApEndingAtJ = dp[j].getOrDefault((int)commonDifference, 0);
                int countOfApEndingAtI = dp[i].getOrDefault((int)commonDifference, 0);

                ans += countOfApEndingAtJ;
                dp[i].put((int)commonDifference, countOfApEndingAtI + countOfApEndingAtJ + 1);
            }
        }

        return ans;
    }
}
