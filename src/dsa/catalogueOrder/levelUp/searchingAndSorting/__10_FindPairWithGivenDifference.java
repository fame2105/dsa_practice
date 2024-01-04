package dsa.catalogueOrder.levelUp.searchingAndSorting;

import java.util.Arrays;

public class __10_FindPairWithGivenDifference {

    public static void findPair(int[]arr,int target) {
        Arrays.sort(arr);
        int i = 0;
        int j = 1;
        while(i < arr.length && j < arr.length) {
            if(arr[j] - arr[i] == target) {
                System.out.println(arr[i] + " " + arr[j]);
                return;
            } else if(arr[j] - arr[i] < target) {
                j++;
            } else  {
                i++;
            }
        }
        System.out.println("-1");
    }
}
