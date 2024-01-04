package dsa.leetcodeANDgfg;

import java.util.Arrays;

public class _1770_MaxScoreAfterPerformingMultiplicationOperations {
    public static void main(String[] args) {
//        int[] nums = {-5,-3,-2,-2,7,1};
//        int[] multipliers = {-10,-5,3,4,6};

        int[] nums = {-5,-3,-2,-3,7,1};
        int[] multipliers = {-10,-5,3,4,6};
        System.out.println(maximumScore(nums, multipliers));
    }

    public static int maximumScore(int[] nums, int[] multipliers) {
        int n = nums.length;
        int m = multipliers.length;
        // int[] dp = new int[m+1];
        Arrays.sort(multipliers);
        Arrays.sort(nums);
        int sum = 0;
        int j = n-1;
        boolean shifted = false;
        for(int i = m-1; i >= 0; i--) {
            int mul = multipliers[i];
            int num = nums[j];
            if((shifted == false && mul < 0 && num < 0) || mul < 0 && num > 0) {
                j -= n - m;
                shifted = true;
            }
            num = nums[j];
            sum = sum + (mul * num);
            j--;
        }

        return sum;
    }
}
