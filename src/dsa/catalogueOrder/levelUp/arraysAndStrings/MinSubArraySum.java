package dsa.catalogueOrder.levelUp.arraysAndStrings;

// 209: https://leetcode.com/problems/minimum-size-subarray-sum/
public class MinSubArraySum {
    public static void main(String[] args) {
        int target = 15;
        int[] nums = new int[]{5,1,3,5,10,7,4,9,2,8};
        System.out.println(minSubArrayLen(target, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int j = 0;
        int minWindowSize = (int) 1e5;
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            while (j < nums.length && sum < target) {
                sum += nums[j];
                j++;
            }
            if (sum >= target) {
                minWindowSize = Math.min(minWindowSize, j - i);
                sum -= nums[i];
            }
        }
        return minWindowSize == 1e5 ? 0 : minWindowSize;
    }
}
