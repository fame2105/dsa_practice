package dsa.catalogueOrder.levelUp.searchingAndSorting;

public class __08_FirstBadVersion {
    public int firstBadVersion(int n) {
        if(n == 1) return 1;

        int lo = 1;
        int hi = n;

        while(lo <= hi) {
            int mid = hi - (hi - lo) / 2;
            if(isBadVersion(mid) == true) { // continue searching in the left
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    // this is provided in the question
    private boolean isBadVersion(int n) {
        return false;
    }
}
