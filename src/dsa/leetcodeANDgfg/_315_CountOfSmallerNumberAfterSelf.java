package dsa.leetcodeANDgfg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/count-of-smaller-numbers-after-self/    #google
// Editorial : https://leetcode.com/problems/count-of-smaller-numbers-after-self/discuss/445769/merge-sort-CLEAR-simple-EXPLANATION-with-EXAMPLES-O(n-lg-n)
public class _315_CountOfSmallerNumberAfterSelf {

    public List<Integer> countSmaller(int[] nums) {
        if(nums.length == 1) return Arrays.asList(0);

        // don't use HashMap for storing the val:countOfElementsSmallerThanValTowardsRight   ... problem with that approach is we wil have duplicated elements in the nums[] and using HashMap will mess the counts of the elements which occur more than once.
        int[] result = new int[nums.length];

        ArrayList<Pair> numsList = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            numsList.add(new Pair(i, nums[i]));
        }

        mergeSort(numsList, 0, nums.length-1, result);

        List<Integer> resultList = new ArrayList<>();
        for(int val : result) {
            resultList.add(val);
        }
        return resultList;
    }

    private class Pair {
        int val;
        int idx;
        Pair(int idx, int val) {
            this.idx = idx;
            this.val = val;
        }
    }

    private ArrayList<Pair> mergeSort(ArrayList<Pair> nums, int left, int right, int[] result) {
        if(left >= right) {
            ArrayList<Pair> list = new ArrayList<>();
            list.add(nums.get(left));
            return list;
        }

        int mid = (left + right) / 2;
        ArrayList<Pair> llist = mergeSort(nums, left, mid, result);
        ArrayList<Pair> rlist = mergeSort(nums, mid + 1, right, result);

        return merge(llist, rlist, result);
    }

    private ArrayList<Pair> merge(ArrayList<Pair> nums1, ArrayList<Pair> nums2, int[] result) {
        int len1 = nums1.size();
        int len2 = nums2.size();

        ArrayList<Pair> nums3 = new ArrayList<>();

        int i = 0, j = 0;
        int count = 0;
        while(i < len1 && j < len2) {
            if(nums1.get(i).val > nums2.get(j).val) {
                Pair rem = nums2.get(j);
                count++; // for every number in the right array/list we increment count.
                nums3.add(new Pair(rem.idx, rem.val));
                j++;
            } else {
                Pair rem = nums1.get(i);
                nums3.add(new Pair(rem.idx, rem.val));
                result[rem.idx] += count; // if we are in else part then value in left subarray has to be smaller than right subarray, therefore make answer for previos iterations by incrementing the result for all respective elements in left subarray with count.
                i++;
            }
        }

        while(i < len1) {
            Pair rem = nums1.get(i);
            nums3.add(new Pair(rem.idx, rem.val));
            result[rem.idx] += count;
            i++;
        }

        while(j < len2) {
            Pair rem = nums2.get(j);
            count++;
            nums3.add(new Pair(rem.idx, rem.val));
            j++;
        }

        return nums3;
    }
}
