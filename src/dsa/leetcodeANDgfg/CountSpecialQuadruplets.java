package dsa.leetcodeANDgfg;

// EASY : https://leetcode.com/problems/count-special-quadruplets/
public class CountSpecialQuadruplets {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 3, 6, 4, 5};
    }

    // Generate all quadruplets first
    public int countQuadruplets(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 3; i++) {
            int val1 = nums[i];
            for (int j = i + 1; j < nums.length - 2; j++) {
                int val2 = nums[j];
                for (int k = j + 1; k < nums.length - 1; k++) {
                    int val3 = nums[k];
                    for(int m = k+1; m < nums.length; m++) {
                        int val4 = nums[m];
                        if(val1 + val2 + val3 == val4) {
                            count++;
                        }
                    }
                }
            }
        }

        return count;
    }

}
