package dsa.catalogueOrder.levelUp.searchingAndSorting;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};

        int lo = 0;
        int hi = nums.length - 1;

        while(lo <= hi) {
            int mid = hi - (hi - lo) / 2; // to avoid overflow condition

            if(nums[mid] == target) {
                ans[0] = mid;

                // continue searching in left part
                hi = mid - 1;
            } else if(nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        lo = 0;
        hi = nums.length - 1;

        while(lo <= hi) {
            int mid = hi - (hi - lo) / 2;

            if(nums[mid] == target) {
                ans[1] = mid;

                // continue searching in right part
                lo = mid + 1;
            } else if(nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return ans;
    }
}
