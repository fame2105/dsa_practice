package dsa.catalogueOrder.levelUp.dynamicProgramming;

public class UglyNumbers {

    private int nThUglyNumber(int n) {
        int[] dp = new int[n + 1];

        dp[1] = 1;
        int p2 = 1;
        int p3 = 1;
        int p5 = 1;

        for(int i = 2; i < n+1; i++) {
            int factor2 = 2 * dp[p2];
            int factor3 = 3 * dp[p3];
            int factor5 = 5 * dp[p5];

            int min = Math.min(factor2, Math.min(factor3, factor5));
            dp[i] = min;

            if(min == factor2) {
                p2++;
            }

            if(min == factor3) {
                p3++;
            }

            if(min == factor5) {
                p5++;
            }
        }

        return dp[n];
    }
}
