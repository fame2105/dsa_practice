package dsa.catalogueOrder.levelUp.searchingAndSorting;

public class __09_GuessNumber {
    public int guessNumber(int n) {
        int lo = 1;
        int hi = n;
        while(lo <= hi) {
            int mid = hi - (hi - lo) / 2;
            int ans = guess(mid);
            if(ans == 0) {
                return mid;
            } else if(ans == -1) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return lo;
    }

    //this function is provided in the Question
    private int guess(int n) {
        return 0;
    }
}
