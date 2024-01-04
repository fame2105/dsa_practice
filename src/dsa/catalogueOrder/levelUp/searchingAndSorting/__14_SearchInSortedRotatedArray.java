package dsa.catalogueOrder.levelUp.searchingAndSorting;

public class __14_SearchInSortedRotatedArray {
    public static int find(int[] arr, int target) {
        int lo = 0;
        int hi = arr.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if(arr[mid] == target) {
                return mid;
            } else if (arr[lo] <= arr[mid]) { // lo to mid part is sorted
                if(arr[lo] <= target && target <= arr[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else if(arr[mid] <= arr[hi]){
                if(arr[mid] <= target && target <= arr[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }
}
