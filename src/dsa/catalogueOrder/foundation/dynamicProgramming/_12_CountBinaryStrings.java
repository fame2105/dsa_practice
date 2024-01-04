package dsa.catalogueOrder.foundation.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class _12_CountBinaryStrings {
    public static void main(String[] args) {
        int n = 4;
        System.out.println("Preorder Solution to generating Binary Strings without consecutive 0's : ");
        binaryStringsRecursivePreOrder(n, '1', "");
        System.out.println(""); // printing empty space
        System.out.println("Postorder Solution to generating Binary Strings without consecutive 0's : ");
        System.out.println(binaryStringsRecursivePostOrder(n, '1'));
        System.out.println(countBinaryStringRecursivePostOrder(n, '1'));
        System.out.println(countBinaryStringRecursivePostOrder_memoization(n, '1', new int[2][n + 1]));

        System.out.println(countBinaryStrings_tabulation(n, new int[2][n+1]));
    }

    // we are generating as we move deep in the recursion
    private static void binaryStringsRecursivePreOrder(int n, char lastCharAdded, String psf) {
        if (n == 0) {
            System.out.print(psf + " ");
            return;
        }

        if (lastCharAdded == '1') {
            binaryStringsRecursivePreOrder(n - 1, '0', psf + '0');
        }

        binaryStringsRecursivePreOrder(n - 1, '1', psf + '1');
    }

    // we are generating answer while coming out of recursion at every level
    private static List<String> binaryStringsRecursivePostOrder(int n, char lastCharAdded) {
        if (n == 0) {
            ArrayList<String> res = new ArrayList<>();
            res.add("");
            return res;
        }

        List<String> result = new ArrayList<>();
        List<String> resultFromRemainingLengthString;
        if (lastCharAdded == '1') {

            resultFromRemainingLengthString = binaryStringsRecursivePostOrder(n - 1, '0');

            for (String str : resultFromRemainingLengthString)
                result.add(str + '0');
        }

        resultFromRemainingLengthString = binaryStringsRecursivePostOrder(n - 1, '1');
        for (String str : resultFromRemainingLengthString) {
            result.add(str + '1');
        }
        return result;
    }

    private static int countBinaryStringRecursivePostOrder(int n, char lastCharAdded) {
        if (n == 0) {
            return 1;
        }

        int count = 0;
        if (lastCharAdded == '1') {
            count += countBinaryStringRecursivePostOrder(n - 1, '0');
        }

        count += countBinaryStringRecursivePostOrder(n - 1, '1');

        return count;
    }

    private static int countBinaryStringRecursivePostOrder_memoization(int n, char lastCharAdded, int[][] dp) {
        if (n == 0) {
            return dp[lastCharAdded - '0'][n] = 1;
        }

        if (dp[lastCharAdded - '0'][n] != 0) return dp[lastCharAdded - '0'][n];

        int count = 0;
        if (lastCharAdded == '1') {
            count += countBinaryStringRecursivePostOrder_memoization(n - 1, '0', dp);
        }

        count += countBinaryStringRecursivePostOrder_memoization(n - 1, '1', dp);

        return dp[lastCharAdded - '0'][n] = count;
    }

    //    dp column -> length of the string
    //    dp row -> string ending in 0 or 1
    // dp will have only 2 rows(binary strings can end with either 0 or 1)
    private static int countBinaryStrings_tabulation(int n, int[][] dp) {
        for (int col = 0; col < dp[0].length; col++) {
            for (int row = 0; row <= 1; row++) {
                if (col == 0 || col == 1) {
                    dp[row][col] = col;
                } else {
                    if (row == 0) {
                        dp[row][col] = dp[1][col - 1];
                    } else if (row == 1) {
                        dp[row][col] = dp[0][col - 1] + dp[1][col - 1];
                    }
                }
            }
        }
        return dp[0][n] + dp[1][n];
    }

}
