package dsa.leetcodeANDgfg;

public class _495_TeemoAttacking {
    public static void main(String[] args) {
        int[] arr = {1, 4};
        int duration = 3;
        System.out.println(findPoisonedDuration(arr, duration)); // expected 6
    }

    /*
    * Phrasing of the question is made as such to deliberately confuse .... run multiple testcases to get better understanding of the question and expected answer before solving it.
     */
    public static int findPoisonedDuration(int[] timeSeries, int duration) {

        int res = duration;
        for(int i = 1; i < timeSeries.length; i++) {
            int start = timeSeries[i];
            int prevPoisonEndAt = timeSeries[i-1] + duration;
            if(start < prevPoisonEndAt) {
                res = res - (prevPoisonEndAt - start);
            }
            res += duration;
        }
        return res;
    }
}
