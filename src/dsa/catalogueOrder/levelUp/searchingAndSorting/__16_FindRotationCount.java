package dsa.catalogueOrder.levelUp.searchingAndSorting;

public class __16_FindRotationCount {
    public static int findRotationCount(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;

        if (nums[lo] <= nums[hi]) { // array is fully sorted
            return lo;
        }

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (mid - 1 >= 0 && nums[mid] < nums[mid - 1]) {
                return mid;
            } else if (mid + 1 < nums.length && nums[mid] > nums[mid + 1]) {
                return mid + 1;
            } else if (nums[lo] <= nums[mid]) {
                lo = mid + 1;
            } else if (nums[mid] <= nums[hi]) {
                hi = mid - 1;
            }
        }

        return -1;
    }
}
