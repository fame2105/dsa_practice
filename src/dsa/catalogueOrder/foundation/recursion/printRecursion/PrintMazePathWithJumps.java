package dsa.catalogueOrder.foundation.recursion.printRecursion;

import java.util.Scanner;

public class PrintMazePathWithJumps {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int rows = s.nextInt();
        int columns = s.nextInt();

        printMazePathWithJumps(1, 1, rows, columns, "");

    }

    private static void printMazePathWithJumps(int sRow, int sColumn, int dRow, int dColumn, String path) {
        if (sRow == dRow && sColumn == dColumn) {
            System.out.print(path + "\t");
        } else if(sRow > dRow || sColumn > dColumn) {
            return;
        }

        // horizontalMoves
        for (int moveSize = 1; moveSize <= dColumn - sColumn; moveSize++) {
            printMazePathWithJumps(sRow, sColumn + moveSize, dRow, dColumn, "H" + moveSize + path);
        }

        // verticalMoves
        for (int moveSize = 1; moveSize <= dRow - sRow; moveSize++) {
            printMazePathWithJumps(sRow + moveSize, sColumn, dRow, dColumn, "V" + moveSize + path);

        }

        // diagonalMoves
        for (int moveSize = 1; moveSize <= dRow - sRow && moveSize <= dColumn - sColumn; moveSize++) {
            printMazePathWithJumps(sRow + moveSize, sColumn + moveSize, dRow, dColumn, "D" + moveSize + path);

        }
    }
}
