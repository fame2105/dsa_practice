package dsa.leetcodeANDgfg.Greedy;

// https://leetcode.com/problems/find-peak-element/
public class _162_FindPeakElement {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        int lo = 0, hi = nums.length - 1;

        while(lo <= hi) {
            int mid = lo + (hi - lo)/2;
            if(mid > 0 && mid < nums.length - 1) { // If mid lies in between array, then check
                if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid + 1]){
                    return mid;
                } else if(nums[mid-1] > nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else if(mid == 0) { // check for 1st element explicitly
                if(nums[mid] > nums[mid + 1]) return mid;
                else return mid + 1;
            } else if(mid == nums.length - 1) { // check for last element explicitly
                if(nums[mid - 1] < nums[mid]) return mid;
                else return mid - 1;
            }
        }
        return -1;
    }
}
