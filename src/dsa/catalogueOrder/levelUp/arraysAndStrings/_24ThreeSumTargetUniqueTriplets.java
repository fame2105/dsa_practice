package dsa.catalogueOrder.levelUp.arraysAndStrings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _24ThreeSumTargetUniqueTriplets {

    public List<List<Integer>> threeSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();


        for(int i = 0; i <= nums.length - 3; i++) {
            if(i != 0 && nums[i] == nums[i-1]) continue;
            int val = nums[i];
            List<List<Integer>> pairs = twoSum(nums, i+1, target - nums[i]);
            for(List<Integer> pair : pairs){
                pair.add(0, val);
                // ans.add
                triplets.add(pair);
            }
        }

        return triplets;
    }

    private List<List<Integer>> twoSum(int[] nums, int start, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int left = start;
        int right = nums.length - 1;
        while(left < right) {
            if(left != start && nums[left] == nums[left-1]) {
                left++;
                continue;
            }
            if(nums[left] + nums[right] == target) {
                ArrayList<Integer> result = new ArrayList<>();
                result.add(nums[left]);
                result.add(nums[right]);
                ans.add(result);
                left++;
                right--;
            } else if(nums[left] + nums[right] > target) {
                right--;
            } else {
                left++;
            }
        }

        return ans;
    }
}
