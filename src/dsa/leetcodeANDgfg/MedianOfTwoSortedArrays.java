/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */

// @lc code=start
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] a, int[] b) {
        // Assume the smaller to be a
        if (b.length < a.length) {
            int[] temp = a;
            a = b;
            b = temp;
        }

        int lo = 0;
        int hi = a.length;
        int totalLength = a.length + b.length;

        while (lo <= hi) {
            int aLeft = (lo + hi) / 2;
            int bLeft = (totalLength + 1) / 2 - aLeft;

            // alM1 will range from (-inf to max(a))
            int alM1 = (aLeft == 0) ? Integer.MIN_VALUE : a[aLeft - 1];

            // al will range from (min(a) to inf)
            int al = (aLeft == a.length) ? Integer.MAX_VALUE : a[aLeft];

            // blM1 will range from (-inf to max(b))
            int blM1 = (bLeft == 0) ? Integer.MIN_VALUE : b[bLeft - 1];

            // bl will range from (min(b) to inf)
            int bl = (bLeft == b.length) ? Integer.MAX_VALUE : b[bLeft];

            // check if the seggregation is valid
            if (alM1 <= bl && blM1 <= al) {
                double median = 0.0;
                if (totalLength % 2 == 0) { // even length
                    int lMax = Math.max(alM1, blM1);
                    int rMin = Math.min(al, bl);
                    median = (lMax + rMin) / 2.0;
                } else { // odd length
                    int lMax = Math.max(alM1, blM1);
                    median = lMax;
                }
                return median;
            } else if (alM1 > bl) {
                hi = aLeft - 1;
            } else if (blM1 > al) {
                lo = aLeft + 1;
            }
        }
        return 0.0;
    }
}
// @lc code=end

