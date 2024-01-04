package dsa.catalogueOrder.levelUp.arraysAndStrings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class _06MajorityElementGeneral {

    public static ArrayList<Integer> majorityElement(int[] nums, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        // create frequency map of nums
        Map<Integer, Integer> fmap = new HashMap<>();
        for (int num : nums) {
            if (fmap.containsKey(num)) {
                fmap.put(num, fmap.get(num) + 1);
            } else {
                fmap.put(num, 1);
            }
        }

        int requiredFrequency = nums.length / k;
        for (int num : nums) {
            if (fmap.containsKey(num) && fmap.get(num) > requiredFrequency){
                ans.add(num);
                fmap.remove(num);
            }
        }

        Collections.sort(ans);
        return ans;
    }
}
