package dsa.leetcodeANDgfg;

import java.util.Arrays;

// Link : https://leetcode.com/problems/zigzag-conversion/
// Editorial : https://leetcode.com/problems/zigzag-conversion/solutions/2868537/zigzag-conversion/

public class _006_ZigzagConversion_StringManipulation {
    public static String convert(String s, int numRows) {
        if(numRows == 1) return s;
        int len = s.length();
        int sections = (int) Math.ceil(len/(2*numRows - 2.0));
        int numColumns = sections * (numRows - 1);

        char[][] matrix = new char[numRows][numColumns];
        for(char[] row : matrix) // initializing the empty matrix
            Arrays.fill(row, ' ');

        int idx = 0;
        int rowIdx = 0, colIdx = 0;
        while(idx < len) {
            while(rowIdx < numRows && idx < len) {
                matrix[rowIdx][colIdx] = s.charAt(idx);
                rowIdx += 1;
                idx += 1;
            }
            rowIdx -= 2;
            colIdx += 1;
            while(rowIdx > 0 && idx < len) {
                matrix[rowIdx][colIdx] = s.charAt(idx);
                rowIdx -= 1;
                colIdx += 1;
            }
        }

        StringBuffer sb = new StringBuffer("");
        for(int i = 0; i < numRows; i++) {
            for(int j = 0; j < colIdx; j++) {
                if(matrix[i][j] != ' ')
                    sb.append(matrix[i][j]);
            }
        }
        return sb.toString();
    }
}
