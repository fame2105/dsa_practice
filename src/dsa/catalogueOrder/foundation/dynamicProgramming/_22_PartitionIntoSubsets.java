package dsa.catalogueOrder.foundation.dynamicProgramming;

import java.util.Scanner;

// https://www.geeksforgeeks.org/count-number-of-ways-to-partition-a-set-into-k-subsets/
public class _22_PartitionIntoSubsets {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int k = s.nextInt();
    }

    private static long partitionIntoSubsets_Recursive(int n, int k) {
        if (n < k) return 0;
        else if(n == 0) return 0;
        else if (n == k) return 1;
        else {
            long kParitions = partitionIntoSubsets_Recursive(n - 1, k); // n-1 items make k teams/partitions
            long k_1Partitions = partitionIntoSubsets_Recursive(n - 1, k - 1); // Nth item forms one team of single Nth item in that team.
            return k * kParitions + k_1Partitions;  // k * kPartitions means Nth item could attach with either of the teams and contribute k * KPartition new ways...
        }
    }

    private static long partitionIntoSubsets_Tabular(int n, int k) {
        long[][] dp = new long[n + 1][k + 1];
        for (int i = 1; i <= n; i++) { // n
            for (int j = 1; j <= k; j++) { // k
                if (i < j) dp[i][j] = 0;
                else if (i == j) dp[i][j] = 1;
                else {
                    dp[i][j] = j * dp[i - 1][j] + dp[i - 1][j - 1];
                }
            }
        }

        return dp[n][k];
    }
}
