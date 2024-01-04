package dsa.leetcodeANDgfg;

import dsa.utility.Util;

public class _998_SumOfEvenNumberAfterQueries {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int[][] queries = {
                {1, 0},
                {-3, 1},
                {-4, 0},
                {2, 3}
        };

        int[] ans = sumEvenAfterQueries(nums, queries);
        Util.display(ans, false);
    }
    public static int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int sum = 0;
        for(int val : nums) {
            if(val % 2 == 0)
                sum += val;
        }

        int n = queries.length;
        int[] ans = new int[queries.length];

        int idx = 0;
        for(int[] query : queries) {

            int change = query[0];
            int changeAt = query[1];
            int origVal = nums[changeAt];
            nums[changeAt] = nums[changeAt] + change;
            int newVal = nums[changeAt];

            if(origVal%2 != 0 && newVal%2 == 0) { // odd to even
                sum += newVal;
            } else if(origVal%2 == 0 && newVal%2 == 0) { // even to even
                sum += change;
            } else if(origVal%2 == 0 && newVal%2 != 0) { // even to odd
                sum -= origVal;
            }

            ans[idx] = sum;
            idx++;
        }

        return ans;
    }
}
