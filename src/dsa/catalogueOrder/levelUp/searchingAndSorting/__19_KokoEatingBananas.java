package dsa.catalogueOrder.levelUp.searchingAndSorting;

public class __19_KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {

        int maxSpeed = (int) -1e9;
        for (int i : piles) {
            maxSpeed = Math.max(maxSpeed, i);
        }

        if (h == piles.length)
            return maxSpeed;

        int minSpeedRequired = binarySearch(piles, maxSpeed, h);
        return minSpeedRequired;
    }

    private int binarySearch(int[] piles, int maxSpeed, int allowedTime) {
        int requiredSpeed = maxSpeed;
        int lo = 1;
        int hi = maxSpeed;

        while (lo <= hi) {
            int mid = hi - (hi - lo) / 2;
            if (canEatIn(piles, mid, allowedTime) == true) {
                requiredSpeed = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return requiredSpeed;
    }

    private boolean canEatIn(int[] piles, int currentSpeed, int allowedTime) {
        int timeTaken = 0;

        for (int banana : piles) {
            timeTaken += (int) Math.ceil(banana * 1.0 / currentSpeed);
        }

        boolean res = timeTaken <= allowedTime;

        return res;
    }
    
}
