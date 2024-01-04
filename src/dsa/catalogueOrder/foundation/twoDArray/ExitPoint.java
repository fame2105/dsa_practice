package dsa.catalogueOrder.foundation.twoDArray;

import java.util.Scanner;

public class ExitPoint {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int r = s.nextInt();
        int c = s.nextInt();
        int[][] a = new int[r][c];

        // Taking Input inside Matrix:

        for(int i = 0; i < r;i++) {
            for(int j = 0; j < c; j++) {
                a[i][j] = s.nextInt();
            }
        }

        printExitPoint(a);
    }

    private static void printExitPoint(int[][] a) {
        int cRow = 0;
        int cCol = 0;

        int rMax = a.length - 1;
        int cMax = a[0].length - 1;

        int dir = 1;
        while(cRow >= 0 && cCol >= 0 && cCol <= cMax && cRow <= rMax) {
            if(a[cRow][cCol] == 1) {
                if(dir == 1) {
                    cRow++;
                    dir = 2;
                } else if(dir == 2) {
                    cCol--;
                    dir = 3;
                }else if(dir == 3) {
                    cRow--;
                    dir = 4;
                } else {
                    cCol++;
                    dir = 1;
                }
            } else {
                if(dir == 1) {
                    cCol++;
                } else if(dir == 2) {
                    cRow++;
                }else if(dir == 3) {
                    cCol--;
                } else {
                    cRow--;
                }
            }
        }

        cRow = cRow > rMax ? rMax : cRow;
        cCol = cCol > cMax ? cMax : cCol;
        System.out.println(cRow + " " + cCol);
    }
}
