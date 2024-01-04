package dsa.catalogueOrder.levelUp.arraysAndStrings;

import java.util.Arrays;

public class _15WiggleSort_II {

    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] duplicateArr = new int[n];

        for (int i = 0; i < n; i++) {
            duplicateArr[i] = nums[i];
        }

        Arrays.sort(duplicateArr);

        int j = n-1;
        int i = 1;

        // fill od indexes first
        while(i < n) {
            nums[i] = duplicateArr[j];
            i += 2;
            j--;
        }

        // fill Even index
        i = 0;
        while(i < n) {
            nums[i] = duplicateArr[j];
            i += 2;
            j--;
        }
    }
}
