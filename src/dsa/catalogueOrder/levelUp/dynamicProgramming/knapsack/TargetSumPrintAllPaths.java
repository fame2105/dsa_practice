package dsa.catalogueOrder.levelUp.dynamicProgramming.knapsack;

import java.util.LinkedList;
import java.util.Queue;

public class TargetSumPrintAllPaths {
    public static class Pair{
        int i;
        int j;
        String psf;

        public Pair(int i, int j, String psf){
            this.i = i;
            this.j = j;
            this.psf = psf;
        }
    }
    public static void targetSumPrintAllPaths(int[] arr, int tar){
        int n = arr.length;
        boolean[][] dp = new boolean[arr.length + 1][tar+1];

        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[0].length; j++) {
                if(i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if(i == 0) {
                    dp[i][j] = false;
                } else if(j == 0) {
                    dp[i][j] = true;
                } else {
                    if(dp[i-1][j] == true) {
                        dp[i][j] = true;
                    } else {
                        if(arr[i-1] <= j && dp[i-1][j - arr[i-1]] == true) {
                            dp[i][j] = true;
                        } else {
                            dp[i][j] = false;
                        }
                    }
                }
            }
        }

        System.out.println(dp[arr.length][tar]);

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(n, tar, ""));

        while(q.size() > 0) {
            Pair rem = q.remove();

            if(rem.i == 0 || rem.j == 0)
                System.out.println(rem.psf);
            else {
                if(rem.j >= arr[rem.i - 1]) {
                    boolean include = dp[rem.i - 1][rem.j - arr[rem.i - 1]];
                    if(include == true) {
                        q.add(new Pair(rem.i-1, rem.j - arr[rem.i - 1], rem.i-1 + " " + rem.psf));
                    }
                }

                boolean exclude = dp[rem.i - 1][rem.j];
                if(exclude == true) {
                    q.add(new Pair(rem.i-1, rem.j, rem.psf));
                }
            }
        }
    }
}
