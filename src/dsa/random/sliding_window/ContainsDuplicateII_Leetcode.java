package dsa.random.sliding_window;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/contains-duplicate-ii/
public class ContainsDuplicateII_Leetcode {
    public static void main(String[] args) {
        int[] input = new int[]{99, 99};
        System.out.println(containsNearbyDuplicate(input, 2));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length <= 1) return false;
        k += 1;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            while (j < nums.length && j - i + 1 <= k) {

                if (i != j && nums[j] == nums[i]) return true;

                j++;
            }
        }
        return false;
    }
}
