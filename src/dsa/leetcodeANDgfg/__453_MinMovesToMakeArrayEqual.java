package dsa.leetcodeANDgfg;

// https://leetcode.com/problems/minimum-moves-to-equal-array-elements/
// Editorial : https://leetcode.com/problems/minimum-moves-to-equal-array-elements/discuss/93817/It-is-a-math-question
public class __453_MinMovesToMakeArrayEqual {
    public int minMoves(int[] nums) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        int len = nums.length;

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            min = Math.min(min, nums[i]);
        }

        return sum - len*min;
    }
}
