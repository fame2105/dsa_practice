package dsa.catalogueOrder.levelUp.HeapAndHashMap;

// https://leetcode.com/problems/max-consecutive-ones-ii/

/**
 * Max Consecutive 1's when only at most 1 zero is allowed to be flipped
 */
public class __15_MaxConsecutiveOnesI {

    public static int maxConsecutiveOnes(int[] arr){
        int ans = 0;
        int j = 0;
        int count = 0; // initial count of 0's considered in the answer subarray
        for(int i = 0; i < arr.length; i++) {
            while(j < arr.length && count < 2) {
                int element = arr[j++];
                if(element == 1) {
                    int subArrayLength = j - i;
                    ans = Math.max(ans, subArrayLength);
                } else {
                    count++;
                    if(count == 2) {
                        break;
                    } else {
                        int subArrayLength = j - i;
                        ans = Math.max(ans, subArrayLength);
                    }
                }
            }

            if(i < j && count == 2) {
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
