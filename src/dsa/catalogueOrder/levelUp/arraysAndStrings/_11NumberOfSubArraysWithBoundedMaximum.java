package dsa.catalogueOrder.levelUp.arraysAndStrings;

public class _11NumberOfSubArraysWithBoundedMaximum {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int prevCount = 0;
        int overallCount = 0;

        int i = 0;
        int j = 0;

        while (j < nums.length) {
            if (nums[j] >= left && nums[j] <= right) { // num is within range[left, right]
                prevCount = j - i + 1;
                overallCount += prevCount;
            } else if (nums[j] < left) { // num is less than rangeMin/left
                overallCount += prevCount;
            } else { // num is greater than maxRange[left, right] , this num cannot be included in any of the sub arrays
                prevCount = 0;
                i = j + 1;
            }
            j++;
        }
        return overallCount;
    }
}
