package dsa.catalogueOrder.levelUp.HeapAndHashMap;

// https://leetcode.com/problems/max-consecutive-ones-iii/

/**
 * Max Consecutive 1's when only at most K zeros are allowed to be flipped
 */
public class __16_MaxConsecutiveOnesII {

    public static int longestOnes(int[] arr, int k){
        int ans = 0;
        int j = 0;
        int count = 0; // initial count of 0's considered in the answer subarray
        for(int i = 0; i < arr.length; i++) {
            while(j < arr.length && count <= k) {
                int element = arr[j++];
                if(element == 1) {
                    int subArrayLength = j - i;
                    ans = Math.max(ans, subArrayLength);
                } else {
                    count++;
                    if(count > k) {
                        break;
                    } else {
                        int subArrayLength = j - i;
                        ans = Math.max(ans, subArrayLength);
                    }
                }
            }

            if(i < j && count > k) {
                int element = arr[i];
                if(element == 1) {
                    continue;
                } else {
                    count--;
                }
            }
        }

        return ans;
    }
}
