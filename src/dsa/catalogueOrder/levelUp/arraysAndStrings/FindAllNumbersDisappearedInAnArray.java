package dsa.catalogueOrder.levelUp.arraysAndStrings;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

public class FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int effectiveIdx = Math.abs(num) - 1;

            if(nums[effectiveIdx] > 0) {
                nums[effectiveIdx] = -nums[effectiveIdx];
            }
        }

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) ans.add(i+1);
        }

        return ans;
    }
}
