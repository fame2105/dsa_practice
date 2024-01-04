package dsa.catalogueOrder.levelUp.arraysAndStrings;

public class _09MaxChunksToMakeArraySorted_I {

    public int maxChunksToSorted(int[] arr) {
        int maxImpactIdx = 0;
        int idx = 0;
        int chunks = 0;
        while (idx < arr.length) {
            maxImpactIdx = Math.max(arr[idx], maxImpactIdx);

            if (maxImpactIdx == idx)
                chunks++;

            idx++;
        }

        return chunks;
    }
}
