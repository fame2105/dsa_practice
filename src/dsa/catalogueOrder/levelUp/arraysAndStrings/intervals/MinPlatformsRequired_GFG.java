package dsa.catalogueOrder.levelUp.arraysAndStrings.intervals;

import java.util.Arrays;

public class MinPlatformsRequired_GFG {

    // Using Chronological Method..... could also be solved using PriorityQueue
    public static int findPlatform(int arr[], int dep[]) {
        Arrays.sort(arr);
        Arrays.sort(dep);

        int i = 0;
        int j = 0;
        int currentMax = 0, overallMax = 0;

        while(i < arr.length) {
            if(arr[i] <= dep[j]) {
                currentMax++;
                i++;
            } else if(arr[i] > dep[j]){
                currentMax--;
                j++;
            }

            overallMax = Math.max(overallMax, currentMax);
        }
        return overallMax;
    }

}
