package dsa.catalogueOrder.levelUp.bitManipulation;

// https://leetcode.com/problems/longest-subarray-with-maximum-bitwise-and/
// https://www.youtube.com/watch?v=4Ljd4kiynAI&ab_channel=CodingDecoded
public class _2419_LongestSubarrayOfMaximumBitwiseAnd {
    /**
     * As per question, we need to find
     * Longest Subarray... Given, that subarray should have Max Bitwise And
     * Max Bitwise And is of the number which is max in value in the array
     *
     * if we do bitwise and of maxNum with any other value in the array then Bitwise And value will decrease
     * Ex: say 9 is the max Num in the array then
     * 9 & 9 = 9 ( Max Bitwise And) whereas (9 & 8) or (9 & <any number smaller than 9>) would result in Bitwise And value smaller than 9 (max bitwise And value)
     * Therefore, the only way we can have Max Bitwise And value in a subarray is if each of the value in subarray is maxNum and are consecutive
     * Ex: [9, 9, 9, 8, 9]  => this will give 3 as ans because there are 3 consecutive numbers which are maxNums and will provide highest Bitwise And values i.e 9
     */
    public int longestSubarray(int[] nums) {
        // Find Max num
        int maxNum = Integer.MIN_VALUE;
        for(int num : nums)
            maxNum = Math.max(maxNum, num);

        // Find the longest subArray where each value in that subarray is equal to maxNum
        int cnt = 1; // there is atleast one element in the while array which is maxNum itself
        int ans = 1;
        int prev = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == prev && nums[i] == maxNum)
                cnt++;
            else
                cnt = 1;

            prev = nums[i];
            ans = Math.max(ans, cnt);
        }

        return ans;
    }
}
