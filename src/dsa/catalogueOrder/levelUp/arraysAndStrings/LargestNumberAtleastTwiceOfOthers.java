package dsa.catalogueOrder.levelUp.arraysAndStrings;

// https://leetcode.com/problems/largest-number-at-least-twice-of-others/
public class LargestNumberAtleastTwiceOfOthers {
    public int dominantIndex(int[] nums) {
        int firstMax = Integer.MIN_VALUE; // biggest
        int firstMaxIdx = 0;

        int secondMax = Integer.MIN_VALUE; // 2nd max (just smaller than the max element in arr)

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > firstMax) {
                secondMax = firstMax;

                firstMax = nums[i];
                firstMaxIdx = i;
            } else if (nums[i] > secondMax) {
                secondMax = nums[i];
            }
        }

        return firstMax >= secondMax * 2 ? firstMaxIdx : -1;
    }
}
