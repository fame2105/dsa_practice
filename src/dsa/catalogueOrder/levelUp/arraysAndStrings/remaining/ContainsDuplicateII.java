package dsa.catalogueOrder.levelUp.arraysAndStrings.remaining;

// https://leetcode.com/problems/contains-duplicate-ii/
public class ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length <= 1) return false;
        k += 1;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            while (j < nums.length && j - i + 1 <= k) {

                if (i != j && nums[j] == nums[i]) return true;

                j++;
            }
        }

        return false;
    }
}
