package dsa.catalogueOrder.levelUp.arraysAndStrings;

import java.util.Arrays;

public class Leetcode_1838_FrequencyOfMostFrequentElement {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);

        int l = 0;
        int r = 0;
        int total = 0;
        int res = 0;

        while (r < nums.length) {
            int largestNumInWindow = nums[r];
            total += nums[r];

            while (largestNumInWindow * (r - l + 1) > total + k) {
                total -= nums[l];
                l++;
            }

            res = Math.max(res, (r - l + 1));
            r++;
        }
        return res;
    }
}
