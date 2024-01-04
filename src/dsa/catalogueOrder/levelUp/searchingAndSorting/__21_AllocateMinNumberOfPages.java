package dsa.catalogueOrder.levelUp.searchingAndSorting;

public class __21_AllocateMinNumberOfPages {
    public static int minPages(int[] arr, int m) {
        int sum = 0;
        int max = 0;
        for (int num : arr) {
            max = Math.max(max, num);
            sum += num;
        }

        int ans = max;
        int lo = max;
        int hi = sum;

        while (lo <= hi) {
            int mid = hi - (hi - lo) / 2;
            if (isDistributionPossible(arr, mid, m) == true) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    private static boolean isDistributionPossible(int[] arr, int mid, int m) {
        int sum = 0;
        int st = 1;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum > mid) {
                st++;
                sum = arr[i];
            }
        }
        return st <= m;
    }
    
}
