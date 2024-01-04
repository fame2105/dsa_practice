package dsa.catalogueOrder.levelUp.dynamicProgramming;

public class TempleOffering {

    private static int totalOffering(int[] height) {
        int n = height.length;
        int[] leftPeaks = new int[n];
        leftPeaks[0] = 1;
        for(int i = 1; i < n; i++) {
            if(height[i] > height[i-1]) {
                leftPeaks[i] = leftPeaks[i-1] + 1;
            } else {
                leftPeaks[i] = 1;
            }
        }

        int[] rightPeaks = new int[n];
        rightPeaks[n-1] = 1;
        for(int i = n-2; i >= 0; i--) {
            if(height[i] > height[i+1]) {
                rightPeaks[i] = rightPeaks[i+1] + 1;
            } else {
                rightPeaks[i] = 1;
            }
        }

        int max = 0;
        for(int i = 0; i < n; i++) {
            max += Math.max(leftPeaks[i], rightPeaks[i]);
        }

        return max;
    }
}
