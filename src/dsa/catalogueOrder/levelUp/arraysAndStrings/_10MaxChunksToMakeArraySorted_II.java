package dsa.catalogueOrder.levelUp.arraysAndStrings;

public class _10MaxChunksToMakeArraySorted_II {

    public int maxChunksToSorted_II(int[] arr) {
        int n = arr.length;
        int[] rightMin = new int[n];
        rightMin[n-1] = arr[n-1];

        for(int i = n-2; i >= 0; i--)
            rightMin[i] = Math.min(rightMin[i+1], arr[i]);

        int maxLeft = arr[0];
        int chunks = 1;

        for(int i = 0; i < n-1; i++) {
            maxLeft = Math.max(maxLeft, arr[i]);

            if(maxLeft <= rightMin[i+1])
                chunks++;
        }

        return chunks;
    }
}
