package dsa.catalogueOrder.levelUp.arraysAndStrings;

import java.util.ArrayList;
import java.util.List;

// 442 : https://leetcode.com/problems/find-all-duplicates-in-an-array/
public class FindAllDuplicatesInArray {

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int effectiveIdx = Math.abs(num) - 1;

            if(nums[effectiveIdx] < 0) {
                ans.add(effectiveIdx+1);
            } else {
                nums[effectiveIdx] = -nums[effectiveIdx];
            }
        }
        return ans;
    }
}
