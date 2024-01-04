package dsa.catalogueOrder.levelUp.arraysAndStrings;

public class _14ProductOfArrayExceptItselfWithoutDivision {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] leftProduct = new int[n];
        int[] rightProduct = new int[n];

        leftProduct[0] = nums[0];
        for (int i = 1; i < n; i++) {
            leftProduct[i] = leftProduct[i-1] * nums[i];
        }

        rightProduct[n-1] = nums[n-1];
        for (int i = n-2; i >= 0; i++) {
            leftProduct[i] = leftProduct[i+1] * nums[i];
        }

        int[] ans = new int[n];
        ans[0] = rightProduct[1];
        ans[n-1] = leftProduct[n-2];

        for(int i = 1; i< n-1; i++) {
            ans[i] = leftProduct[i-1] * rightProduct[i+1];
        }

        return ans;
    }
}
