package dsa.catalogueOrder.levelUp.arraysAndStrings;

public class _04MajorityElement_I {
    // Moore's Voting Algorithm
    public int majorityElement(int[] nums) {
        int val = nums[0];
        int count = 1;

        int i = 1;
        while (i < nums.length) {
            if (val == nums[i]) {
                // increase the count of same element
                count++;
            } else {
                if (count > 0) { // pair distinct element
                    count--;
                } else {
                    val = nums[i];
                    count = 1;
                }
            }
            i++;
        }

        // val is the potential candidate to be a majority element
        int freq = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == val) freq++;
        }

        if (freq > nums.length / 2) return val;
        else return -1; // majority element does not exists
    }
}
