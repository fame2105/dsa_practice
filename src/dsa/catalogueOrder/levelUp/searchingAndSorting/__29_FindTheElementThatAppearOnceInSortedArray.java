package dsa.catalogueOrder.levelUp.searchingAndSorting;

public class __29_FindTheElementThatAppearOnceInSortedArray {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        if (nums[0] != nums[1]) {
            return nums[0];
        }

        if (nums[n - 1] != nums[n - 2]) {
            return nums[n - 1];
        }

        int lo = 0;
        int hi = n - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1]) {
                return nums[mid];
            } else if (nums[mid] == nums[mid - 1]) {
                // low to mid element count
                int leftCount = mid - lo + 1;

                if (leftCount % 2 == 0) {
                    lo = mid + 1;
                } else {
                    hi = mid - 2;
                }
            } else if (nums[mid] == nums[mid + 1]) {
                // mid to hi element count
                int rightCount = hi - mid + 1;

                if (rightCount % 2 == 0) {
                    hi = mid - 1;
                } else {
                    lo = mid + 2;
                }
            }
        }
        return -1;
    }
}
