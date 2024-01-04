package dsa.catalogueOrder.levelUp.dynamicProgramming.LongestIncreasingSubsequence;

import dsa.utility.Util;

// Leetcode-1671 : https://leetcode.com/problems/minimum-number-of-removals-to-make-mountain-array/
public class _4_LongestBitonicSubsequence {
    public static void main(String[] args) {
        int[] nums1 = {9,8,1,7,6,5,4,3,2,1};
        int[] nums2 = {1, 3, 1};
        int[] nums3 = {2,1,1,5,6,2,3,1};

        int maxLengthBitonicSubsequence = bitonicSubsequence(nums2);
        System.out.println(maxLengthBitonicSubsequence);
    }

    public static int bitonicSubsequence(int[] nums) {
        // calculate Largest Increasing Subsequence
        int[] lis = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            int currNum = nums[i];
            int prevMaxLength = 0;
            for(int j = 0; j < i; j++) {
                int prevNum = nums[j];
                if(currNum > prevNum) {
                    prevMaxLength = Math.max(prevMaxLength, lis[j]);
                }
            }

            lis[i] = prevMaxLength + 1;
        }

        // calculate Largest Decreasing Subsequence
        int[] lds = new int[nums.length];
        for(int i = nums.length - 1; i >= 0; i--) {
            int currNum = nums[i];
            int prevMaxLength = 0;
            for(int j = nums.length - 1; j > i; j--) {
                int prevNum = nums[j];
                if(currNum > prevNum) {
                    prevMaxLength = Math.max(prevMaxLength, lds[j]);
                }
            }

            lds[i] = prevMaxLength + 1;
        }

        // calculate Max length Bitonic Subsequence
        int maxLengthBitonicSubsequence = 0;

        Util.display(lis, false);
        Util.display(lds, false);

        for(int i = 0; i < nums.length; i++) {
            if(lis[i] > 1 && lds[i] > 1) {
                if(lis[i] + lds[i] - 1 > maxLengthBitonicSubsequence) {
                    maxLengthBitonicSubsequence = lis[i] + lds[i] - 1;
                }
            }
        }

        return maxLengthBitonicSubsequence;
    }
}
