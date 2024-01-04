package dsa.catalogueOrder.levelUp.arraysAndStrings;

public class _03SquaresOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        int i = 0;
        int j = nums.length - 1;

        int[] ans = new int[nums.length];
        int k = ans.length-1;

        while(i <= j && k >= 0) {
            int val1 = nums[i] * nums[i];
            int val2 = nums[j] * nums[j];

            if(val1 < val2) {
                ans[k--] = val2;
                j--;
            } else {
                ans[k--] = val1;
                i++;
            }
        }

        return ans;
    }
}
