package dsa.catalogueOrder.levelUp.searchingAndSorting;

import dsa.catalogueOrder.foundation.binarySearchTree.BinarySearchTree;

public class __20_FindSmallestGivenAThreshold {
    public int smallestDivisor(int[] nums, int threshold) {
        int maxDivisor = (int) -1e9;
        for (int num : nums) {
            maxDivisor = Math.max(maxDivisor, num);
        }

        int smallestPossibleDivisor = binarySearch(nums, maxDivisor, threshold);
        return smallestPossibleDivisor;
    }

    private int binarySearch(int[] nums, int maxDivisor, int threshold) {
        int minDivisor = maxDivisor;

        int lo = 1;
        int hi = maxDivisor;

        while (lo <= hi) {
            int divisor = hi - (hi - lo) / 2;
            if (canDivide(nums, threshold, divisor) == true) {
                minDivisor = divisor;
                hi = divisor - 1;
            } else {
                lo = divisor + 1;
            }
        }

        return minDivisor;
    }

    private boolean canDivide(int[] nums, int threshold, int divisor) {
        int sum = 0;
        for (int num : nums) {
            sum += (int) Math.ceil(num * 1.0 / divisor);
        }

        return sum <= threshold;
    }
}
