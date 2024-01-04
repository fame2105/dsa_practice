package dsa.catalogueOrder.levelUp.searchingAndSorting;

public class __24_CountZerosInSorted01Matrix {
    public static int countZeros(int[][] mat) {
        int r = 0;
        int c = mat[0].length - 1;
        int count = 0; // countOfZeros
        while (r < mat.length && c >= 0) {
            int element = mat[r][c];
            if (element == 1) { // ignore this column
                c--;
            } else {
                count += c + 1;
                r++;
            }
        }
        return count;
    }
    
}
