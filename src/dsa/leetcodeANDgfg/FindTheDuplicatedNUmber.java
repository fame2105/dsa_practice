package dsa.leetcodeANDgfg;

// https://leetcode.com/problems/find-the-duplicate-number/
public class FindTheDuplicatedNUmber {
    /**
     * Sample array : [1, 3, 4, 2, 2]
     */
    public int findDuplicate(int[] nums) {

        for(int i  = 0; i < nums.length; i++) {
            int val = nums[i]; // value at current index(i) is nums[i]
            int absVal = Math.abs(val); // get the absolute value at currentIndex

            // if this condition is true that means we have once processed the number kept at absVal position in this array, and we are
            // attempting to process it again, hence absVal is the repeated number
            if(nums[absVal] < 0) {
                return absVal;
            } else { // process the number by making it -ve
                nums[absVal] = -1 * nums[absVal];
            }
        }
        return -1;
    }

}
