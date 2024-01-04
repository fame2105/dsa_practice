package dsa.catalogueOrder.levelUp.searchingAndSorting;

import java.util.Arrays;

public class __25_CountingElementInTwoArrays {

    // Approach - 01
    /* public static int[] find(int[] arr1, int[] arr2) {
        Arrays.sort(arr2);
        int[] ans = new int[arr1.length];
    
        for (int i = 0; i < arr1.length; i++) {
            int element = arr1[i];
            int count = search(arr2, element);
            ans[i] = count;
        }
        return ans;
    }
    
    private static int search(int[] arr2, int element) {
        int lo = 0;
        int hi = arr2.length - 1;
        int count = 0;
    
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (arr2[mid] <= element) {
                count += (mid - lo + 1);
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return count;
    } */
    
    // Approach - 02
    public static int[] find(int[] arr1, int[] arr2) {
        // Preprocessing ...
        int max1 = 0;
        int max2 = 0;
        for (int num : arr1) {
            max1 = Math.max(max1, num);
        }

        // Prepare frequency array for arr2
        int[] farr = new int[100000];
        for (int num : arr2) {
            max2 = Math.max(max2, num);
            farr[num]++;
        }

        int overallMax = Math.max(max1, max2);
        // Prepare prefix sum array of frequency array
        int[] psarr = new int[100000];
        
        psarr[0] = farr[0];
        for (int i = 1; i <= overallMax; i++) {
            psarr[i] = psarr[i - 1] + farr[i];
        }

        int[] ans = new int[arr1.length];
        
        for (int i = 0; i < ans.length; i++) {
            int key = arr1[i];
            ans[i] = psarr[key];
        }
        return ans;
    }
}
