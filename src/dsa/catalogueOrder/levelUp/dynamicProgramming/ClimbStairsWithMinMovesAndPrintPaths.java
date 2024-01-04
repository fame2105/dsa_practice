package dsa.catalogueOrder.levelUp.dynamicProgramming;

import java.util.ArrayDeque;
import java.util.Queue;

public class ClimbStairsWithMinMovesAndPrintPaths {
    public static void main(String[] args) {
        int[] steps = {3, 3, 0, 2, 1, 2, 4, 2, 0, 0};
        climbStairsWithMinPaths(steps);
    }

    private static class Pair {
        int idx;
        int stepSize;
        int moves;
        String path;

        public Pair(int idx, int stepSize, int moves, String path) {
            this.idx = idx;
            this.stepSize = stepSize;
            this.moves = moves;
            this.path = path;
        }
    }

    private static void climbStairsWithMinPaths(int[] steps) {
        int n = steps.length;
        Integer[] dp = new Integer[n];
        dp[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            int stepSize = steps[i];
            int minMoves = Integer.MAX_VALUE;

            for (int j = 1; j <= stepSize && i + j < n; j++) {
                if (dp[i + j] != null)
                    minMoves = Math.min(minMoves, dp[i + j]);
            }

            if (minMoves != Integer.MAX_VALUE) {
                dp[i] = minMoves + 1;
            }
        }

        System.out.println(dp[0]);

        Queue<Pair> q = new ArrayDeque<>();
        q.add(new Pair(0, steps[0], dp[0], "0"));

        while (q.size() > 0) {
            Pair rem = q.remove();
            if (rem.idx == n - 1) {
                System.out.println(rem.path);
            }

            for (int j = 1; j <= rem.stepSize && j + rem.idx < n; j++) {
                if (dp[j + rem.idx] != null && dp[j + rem.idx] == rem.moves - 1) {
                    q.add(new Pair(j + rem.idx, steps[j + rem.idx], dp[j + rem.idx], rem.path + " ->" + (j + rem.idx)));
                }
            }
        }
    }
}
