package dsa.catalogueOrder.foundation.dynamicProgramming;

public class _20_TileFloors {
    public static void main(String[] args) {
        System.out.println(waysToTileFloorMX1Recursive(39, 16));
        System.out.println(waysToTileFloorMX1DP(39, 16));
    }

    private static int waysToTileFloor2X1(int n) { // we can use recursive+dp approach but recursive function is (f(n-1) + f(n-2)).. this is fibonacci sequence
        int a = 1;
        int b = 2;

        for (int i = 1; i < n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return a;
    }

    private static int waysToTileFloorMX1Recursive(int n, int m) {
        if (n == 1) return 1;
        if (n == 0) return 1;

        int verticalWays = waysToTileFloorMX1Recursive(n - 1, m);
        int horizontalWays = 0;
        if (m <= n) {
            horizontalWays = waysToTileFloorMX1Recursive(n - m, m);
        }
        return verticalWays + horizontalWays;
    }

    private static int waysToTileFloorMX1DP(int n, int m) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (i < m) {
                dp[i] = 1; // you can only tile vertically if the length of the tiles is greater than the length of the floor
            } else if (i == m) { // you can either tile vertically or tile vertically ... not a combination of vertical and horizontal arrangements
                dp[i] = 2;
            } else {
                dp[i] = dp[i - 1] + dp[i - m];
            }
        }
        return dp[n];
    }
}
