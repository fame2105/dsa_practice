package dsa.catalogueOrder.levelUp.arraysAndStrings;

public class _19SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
        int i = 0;
        int j = 0;
        while(i < nums.length) {
            if(nums[i] % 2 == 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            } else {
                i++;
            }
        }
        return nums;
    }
}
