package dsa.leetcodeANDgfg;

// https://leetcode.com/problems/number-of-arithmetic-triplets/ #Easy
public class _2367_NumberOfArithmaticTriplets {
    public int arithmeticTriplets(int[] nums, int diff) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] - nums[i] != diff)
                    continue;
                else {
                    for (int k = j + 1; k < n; k++) {
                        if (nums[k] - nums[j] == diff) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
}
