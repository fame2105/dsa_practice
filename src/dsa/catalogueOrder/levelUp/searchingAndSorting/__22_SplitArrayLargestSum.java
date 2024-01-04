package dsa.catalogueOrder.levelUp.searchingAndSorting;

public class __22_SplitArrayLargestSum {
    public int splitArray(int[] nums, int m) {
        int max = 0;
        int sum = 0;
        for (int num : nums) {
            max = Math.max(max, num);
            sum += num;
        }

        int lo = max;
        int hi = sum;
        int ans = max;

        while (lo <= hi) {
            int mid = hi - (hi - lo) / 2;
            if (isSplitPossible(nums, mid, m) == true) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;

            }
        }

        return ans;
    }

    private boolean isSplitPossible(int[] nums, int mid, int m) {
        int sum = 0;
        int count = 1;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > mid) {
                sum = nums[i];
                count++;
            }
        }

        return count <= m;
    }
}
