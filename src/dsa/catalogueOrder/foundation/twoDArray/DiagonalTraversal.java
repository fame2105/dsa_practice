package dsa.catalogueOrder.foundation.twoDArray;

import dsa.utility.Util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiagonalTraversal {
    public static void main(String[] args) {
        int[][] mat1 = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] mat2 = new int[][]{{1, 2}, {3, 4}};

        Util.display(findDiagonalOrder(mat2), false);
    }

    // https://leetcode.com/problems/diagonal-traverse/    ... traversing on anti-diagonal
    public static int[] findDiagonalOrder(int[][] mat) {
        if (mat.length == 0) {
            return new int[0];
        }

        int m = mat.length, n = mat[0].length;
        int r = 0, c = 0;
        int[] result = new int[m * n];

        for (int i = 0; i < result.length; i++) {
            result[i] = mat[r][c];

            if ((r + c) % 2 == 0) { // move upwords
                if (c == n - 1) {
                    r++;
                } else if (r == 0) {
                    c++;
                } else {
                    r--;
                    c++;
                }
            } else { // move downwards
                if (r == m - 1) {
                    c++;
                } else if (c == 0) {
                    r++;
                } else {
                    r++;
                    c--;
                }
            }
        }

        return result;
    }

    // https://leetcode.com/problems/diagonal-traverse-ii/
    public static int[] findDiagonalOrderII(List<List<Integer>> nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int totalSize = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            List<Integer> currentList = nums.get(i);
            for (int j = 0; j < currentList.size(); j++) {
                int sum = i + j;
                List<Integer> list = map.getOrDefault(sum, new ArrayList<>());
                list.add(currentList.get(j));

                totalSize++;
                maxSum = Math.max(maxSum, sum);
            }
        }

        int[] result = new int[totalSize];
        int idx = 0;
            for(int j = 0; j <= maxSum; j++) {
                List<Integer> list = map.get(j);
                for(int k = list.size() - 1; k >= 0; k--) {
                    result[idx++] = list.get(k);
                }
            }
        return result;
    }

}
