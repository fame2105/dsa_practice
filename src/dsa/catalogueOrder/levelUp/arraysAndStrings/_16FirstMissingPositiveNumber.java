package dsa.catalogueOrder.levelUp.arraysAndStrings;

public class _16FirstMissingPositiveNumber {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean one = false;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) one = true;

            if (nums[i] < 1 || nums[i] > n) nums[i] = 1;
        }

        if (one == false) return 1;

        for (int i = 0; i < n; i++) {
            int val = Math.abs(nums[i]);
            int idx = val - 1;
            nums[idx] = -Math.abs(nums[idx]);
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return n + 1;
    }
}
