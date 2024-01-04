package dsa.catalogueOrder.levelUp.arraysAndStrings;

import java.util.ArrayList;

public class _05MajorityElement_II {

    public static ArrayList<Integer> majorityElement2(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        int candidate_1 = nums[0];
        int candidate_1_count = 1;

        int candidate_2 = nums[0];
        int candidate_2_count = 0;

        int i = 1;
        while (i < nums.length) {
            int element = nums[i++];

            if (element == candidate_1) {
                candidate_1_count++;
            } else if (element == candidate_2) {
                candidate_2_count++;
            } else {
                if (candidate_1_count == 0) { // initialize candidate_1
                    candidate_1 = element;
                    candidate_1_count = 1;
                } else if (candidate_2_count == 0) { // initialize candidate_2
                    candidate_2 = element;
                    candidate_2_count = 1;
                } else {
                    candidate_1_count--;
                    candidate_2_count--;
                }
            }
        }

        candidate_1_count = 0;
        candidate_2_count = 0;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == candidate_1) candidate_1_count++;
            else if (nums[j] == candidate_2) candidate_2_count++;
        }

        if (candidate_1_count > nums.length / 3) ans.add(candidate_1);
        if (candidate_2_count > nums.length / 3) ans.add(candidate_2);

        return ans;
    }
}
