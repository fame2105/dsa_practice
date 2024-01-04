package dsa.catalogueOrder.foundation.dynamicProgramming;

public class _29_HighwayBillboard {

    private static int maxRevenueFromBillboards(int miles, int countBillboard, int[] boardPlacement, int[] boardRevenues, int minDistance) {
        int[] dp = new int[countBillboard];
        dp[0] = boardRevenues[0];
        int maxRevenue = 0;
        for(int i = 1; i < countBillboard; i++) {
            int currBoardPosition = boardPlacement[i];
            int max = 0;

            for(int j = 0; j < i; j++) {
                int prevBoardPosition = boardPlacement[j];
                if(currBoardPosition - prevBoardPosition > minDistance) {
                    max = Math.max(max, dp[j]);
                }
            }

            dp[i] = boardRevenues[i] + max;
            maxRevenue = Math.max(maxRevenue, dp[i]);
        }

        return maxRevenue;
    }
}
