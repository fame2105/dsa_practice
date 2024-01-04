package dsa.catalogueOrder.levelUp.arraysAndStrings;

public class _17RangeAddition {
    // unoptimized method -> queries should be pre processed for overlapping indexRange
    public static int[] getModifiedArray(int length, int[][] queries) {
        int[] ans = new int[length];

        for(int[] a: queries) {
            int stIdx = a[0];
            int enIdx = a[1];
            int inc = a[2];
            for(int i = stIdx; i<= enIdx; i++) {
                ans[i] += inc;
            }
        }

        return ans;
    }

    // optimized solution -> queries are pre processed.
    public int[] getModifiedArray_optimized(int length, int[][] queries) {
        int[] ans = new int[length];

        for(int[] a: queries) {
            int stIdx = a[0];
            int enIdx = a[1];
            int inc = a[2];

            ans[stIdx] += inc;
            if(enIdx + 1 < ans.length) {
                ans[enIdx+1] -= inc;
            }
        }

        int pSum = 0;
        for(int i = 0; i < length; i++) {
            pSum += ans[i];
            ans[i] = pSum;
        }

        return ans;
    }
}
