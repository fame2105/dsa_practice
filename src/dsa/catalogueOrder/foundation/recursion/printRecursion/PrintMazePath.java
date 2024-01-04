package dsa.catalogueOrder.foundation.recursion.printRecursion;

import java.util.Scanner;

public class PrintMazePath {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int rows = s.nextInt();
        int columns = s.nextInt();

        printMazePath(1,1,rows, columns, "");
    }

    private static void printMazePath(int sRow, int sColumn, int dRow, int dColumn, String path) {
            if(sRow == dRow && sColumn == dColumn) {
                System.out.print(path + "\t");
            } else if(sRow > dRow || sColumn > dColumn) {
                return;
            }

        printMazePath(sRow, sColumn + 1, dRow, dColumn, "H" + path);
        printMazePath(sRow + 1, sColumn, dRow, dColumn, "V" + path);
    }
}
