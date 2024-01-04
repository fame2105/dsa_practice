package dsa.catalogueOrder.levelUp.dynamicProgramming;

public class BestSightSeeingPair {
    public int maxScoreSightseeingPair(int[] values) {
        int max = values[0];
        int result = Integer.MIN_VALUE;

        for(int j = 1; j < values.length; j++) {
            max = Math.max(max, values[j-1] + j-1);
            result = Math.max(result, max + values[j] - j);
        }

        return result;
    }
}
