package dsa.catalogueOrder.levelUp.arraysAndStrings;

public class MaxProductSubarray {
    public static int maxProduct(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int currentProduct = 1;

        for (int i = 0; i < nums.length; i++) {
            currentProduct = currentProduct * nums[i];

            ans = Math.max(ans, currentProduct); // update answer first and then check for 0
            // otherwise, we will could get minProduct to be 1, while expected is 0
            if (currentProduct == 0) {
                currentProduct = 1;
            }

        }

        currentProduct = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            currentProduct = currentProduct * nums[i];

            ans = Math.max(ans, currentProduct);

            if (currentProduct == 0) {
                currentProduct = 1;
            }

        }

        return ans;
    }
}
