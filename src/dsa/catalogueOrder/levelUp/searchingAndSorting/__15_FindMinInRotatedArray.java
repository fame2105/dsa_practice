package dsa.catalogueOrder.levelUp.searchingAndSorting;

public class __15_FindMinInRotatedArray {
    public static void main(String[] args) {
        System.out.println(findMinimum(new int[] {11, 12, 14, 10}));
    }
    public static int findMinimum(int[] nums) {
        int lo = 0;
        int hi = nums.length - 1;

        if (nums[lo] <= nums[hi]) { // array is fully sorted
            return nums[lo];
        }

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (mid - 1 >= 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            } else if (mid + 1 < nums.length && nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            } else if (nums[lo] <= nums[mid]) {
                lo = mid + 1;
            } else if (nums[mid] <= nums[hi]) {
                hi = mid - 1;
            }
        }

        return -1;
    }
}
