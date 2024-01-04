package dsa.catalogueOrder.levelUp.searchingAndSorting;

public class __23_CapacityToShipPackagesWithinDDays {
    // Parent Problem : Allocate Min number of pages (GFG)
    // Similar Problem : Split Array Largest Sum
    public int shipWithinDays(int[] weights, int days) {
        int max = 0;
        int sum = 0;
        for (int weight : weights) {
            max = Math.max(max, weight);
            sum += weight;
        }

        int lo = max;
        int hi = sum;
        int ans = max;

        while (lo <= hi) {
            int mid = hi - (hi - lo) / 2;
            if (canShipThisLoad(weights, mid, days) == true) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }

    private static boolean canShipThisLoad(int[] weights, int mid, int days) {
        int sum = 0;
        int requiredDays = 1;
        for (int i = 0; i < weights.length; i++) {
            sum += weights[i];
            if (sum > mid) {
                sum = weights[i];
                requiredDays++;
            }
        }

        return requiredDays <= days;
    }
}
