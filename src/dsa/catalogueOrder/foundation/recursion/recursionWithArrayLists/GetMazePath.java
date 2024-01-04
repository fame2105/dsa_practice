package dsa.catalogueOrder.foundation.recursion.recursionWithArrayLists;

import java.util.ArrayList;
import java.util.Scanner;

public class GetMazePath {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int rows = s.nextInt();
        int columns = s.nextInt();

        int[][] arr = new int[rows][columns];

        ArrayList<String> mazePaths = getMazePaths(arr, 0,0,rows-1,columns-1);
        System.out.println(mazePaths);
    }

    private static ArrayList<String> getMazePaths(int[][] arr, int sRow, int sColumn, int dRow, int dColumn) {
        if(sRow == dRow && sColumn == dColumn) {
            ArrayList arrayList = new ArrayList<String>();
            arrayList.add("");
            return arrayList;
        } else if(sRow > dRow || sColumn > dColumn){
            ArrayList arrayList = new ArrayList<String>();
            return arrayList;
        }

        ArrayList<String> horizontalPaths = getMazePaths(arr, sRow, sColumn + 1, dRow, dColumn);
        ArrayList<String> verticalPaths = getMazePaths(arr, sRow + 1, sColumn, dRow, dColumn);

        ArrayList<String> allPaths = new ArrayList<String>();

        for(String val : horizontalPaths) {
            allPaths.add("H" + val);
        }

        for(String val : verticalPaths) {
            allPaths.add("V" + val);
        }

        return allPaths;
    }
}
