package dsa.catalogueOrder.foundation.recursion.recursionWithArrayLists;

import java.util.ArrayList;
import java.util.Scanner;

public class GetMazePathsWithJumpsAllowed {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int rows = s.nextInt();
        int columns = s.nextInt();

        ArrayList<String> mazePaths = getMazePathsWithJumpsAllowed(1, 1, rows, columns);
        System.out.println(mazePaths);
    }

    private static ArrayList<String> getMazePathsWithJumpsAllowed(int sRow, int sColumn, int dRow, int dColumn) {
        if (sRow == dRow && sColumn == dColumn) {
            ArrayList arrayList = new ArrayList<String>();
            arrayList.add("");
            return arrayList;
        }

        ArrayList<String> allPaths = new ArrayList<>();
        // horizontalMoves
        for (int moveSize = 1; moveSize <= dColumn - sColumn; moveSize++) {
            ArrayList<String> horizontalMoves = getMazePathsWithJumpsAllowed(sRow, sColumn + moveSize, dRow, dColumn);
            for (String val : horizontalMoves) {
                allPaths.add("H" + moveSize + val);
            }
        }

        // verticalMoves
        for (int moveSize = 1; moveSize <= dRow - sRow; moveSize++) {
            ArrayList<String> verticalMoves = getMazePathsWithJumpsAllowed(sRow + moveSize, sColumn, dRow, dColumn);
            for (String val : verticalMoves) {
                allPaths.add("V" + moveSize + val);
            }
        }

        // diagonalMoves
        for (int moveSize = 1; moveSize <= dRow - sRow && moveSize <= dColumn - sColumn; moveSize++) {
            ArrayList<String> diagonalMoves = getMazePathsWithJumpsAllowed(sRow + moveSize, sColumn + moveSize, dRow, dColumn);
            for (String val : diagonalMoves) {
                allPaths.add("D" + moveSize + val);
            }
        }
        return allPaths;
    }
}
