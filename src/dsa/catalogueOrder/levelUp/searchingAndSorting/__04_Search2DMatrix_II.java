package dsa.catalogueOrder.levelUp.searchingAndSorting;

public class __04_Search2DMatrix_II {

    // We can start either from top right corner or bottom left corner
    public boolean searchMatrix(int[][] matrix, int target) {
        // Working through top right corner int this implementation
        int r = 0;
        int c = matrix[0].length - 1;

        // On each step, we re discarding either a row or a column
        while(r < matrix.length && c >= 0) {
            if(matrix[r][c] == target) {
                return true;
            } else if(matrix[r][c] < target) {
                    r++;
            } else {
                c--;
            }
        }

        return false;
    }

}
