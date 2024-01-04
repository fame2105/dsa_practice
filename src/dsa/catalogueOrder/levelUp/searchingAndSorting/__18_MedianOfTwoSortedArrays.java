package dsa.catalogueOrder.levelUp.searchingAndSorting;

public class __18_MedianOfTwoSortedArrays {
    /**
     * Approach- 01 : Merge the given sorted arrays and then find the median of that
     * merged sorted array.
     */
    /*
     * public double findMedianSortedArrays(int[] nums1, int[] nums2) { int[] merged
     * = new int[nums1.length + nums2.length]; int i = 0; int j = 0; int k = 0;
     * 
     * while (i < nums1.length && j < nums2.length) { if (nums1[i] <= nums2[j]) {
     * merged[k] = nums1[i]; i++; k++; } else { merged[k] = nums2[j]; j++; k++; } }
     * 
     * while (i < nums1.length) { merged[k] = nums1[i]; i++; k++; }
     * 
     * while (j < nums2.length) { merged[k] = nums2[j]; j++; k++; }
     * 
     * double median = 0.0; if (merged.length % 2 == 0) { int a = merged.length / 2;
     * int b = a - 1; median = (merged[a] + merged[b]) / 2.0; } else { median =
     * merged[merged.length / 2]; }
     * 
     * return median; }
     */

    /**
     * Approach- 02 :
     * 
     */
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
            if (alM1 < bl && blM1 < al) {
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
