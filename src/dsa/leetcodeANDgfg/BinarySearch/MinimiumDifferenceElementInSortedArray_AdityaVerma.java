package dsa.leetcodeANDgfg.BinarySearch;

/**
 * Given a sorted array, find the element in the array which has minimum difference with the given number. .
 */
public class MinimiumDifferenceElementInSortedArray_AdityaVerma {

    // if key is present then find and return key from the given sorted array
    // else find the lowerBound and upperBound Elements and return that element that has the smallest difference with key

    public int getMinAbsoluteDifference(int[] arr, int key) {
        int lo = 0, hi = arr.length - 1;

        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            if(arr[mid] == key) return 0;
            else if(arr[mid] > key) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        int minDifference = Math.min(Math.abs(arr[lo] - key), Math.abs(arr[hi] - key));
        return minDifference;
    }
}
