package dsa.catalogueOrder.levelUp.dynamicProgramming.LongestIncreasingSubsequence;

import java.util.Arrays;
import java.util.Scanner;

public class _5_MaxNonOverlappingBridges {
    private static class Bridge implements Comparable<Bridge> {
        int north;
        int south;
        Bridge(int north, int south) {
            this.north = north;
            this.south = south;
        }

        public int compareTo(Bridge o) {
            if(this.north != o.north) {
                return this.north - o.north;
            } else {
                return this.south - o.south;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        int n = Integer.parseInt(s.nextLine());

        Bridge[] bridges = new Bridge[n];
        for(int i = 0; i < n; i++) {
            String str = s.nextLine();
            String[] parts = str.split(" ");

            Bridge bdg = new Bridge(Integer.parseInt(parts[0]), Integer.parseInt(parts[1]));
            bridges[i] = bdg;
        }

        Arrays.sort(bridges);

        int[] dp = new int[n];
        int maxOverlappingBridges = 0;

        for(int i = 0; i < n; i++) {
            Bridge currBridge = bridges[i];
            int prevMaxNonOverlappingBridges = 0;

            for(int j = 0; j < i; j++) {
                Bridge prevBridge = bridges[j];
                if(currBridge.south > prevBridge.south) {
                    prevMaxNonOverlappingBridges = Math.max(prevMaxNonOverlappingBridges, dp[j]);
                }
            }

            dp[i] = prevMaxNonOverlappingBridges + 1;
            maxOverlappingBridges = Math.max(maxOverlappingBridges, dp[i]);
        }

        System.out.println(maxOverlappingBridges);
    }
}
