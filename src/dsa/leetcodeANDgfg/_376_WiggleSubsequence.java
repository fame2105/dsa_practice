package dsa.leetcodeANDgfg;

public class _376_WiggleSubsequence {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length == 1) {
            return nums.length;
        }
        int prev = nums[1] - nums[0];
        int count = prev == 0 ? 1 : 2;
        for(int i = 2; i < nums.length; i++) {
            int diff = nums[i] - nums[i-1];
            if(diff < 0 && prev >= 0) {
                count++;
                prev = diff;
            }

            if(diff > 0 && prev <= 0) {
                count++;
                prev = diff;
            }
        }
        return count;
    }
}
