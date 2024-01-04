package dsa.catalogueOrder.levelUp.arraysAndStrings;

public class TransposeMatrixInPlace {

    // Matrix Transpose without using extra space -> but only possible for square matrix
    public void transpose(int[][] matrix) {
        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix.length; c++) {
                if (r < c) {
                    int temp = matrix[r][c];
                    matrix[r][c] = matrix[c][r];
                    matrix[c][r] = temp;
                }
            }
        }
    }

}
