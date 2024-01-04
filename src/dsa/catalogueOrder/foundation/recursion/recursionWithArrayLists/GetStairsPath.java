package dsa.catalogueOrder.foundation.recursion.recursionWithArrayLists;

import java.util.ArrayList;
import java.util.Scanner;

public class GetStairsPath {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        ArrayList allPaths = getStairsPath(n);
        System.out.println(allPaths);

    }

    private static ArrayList getStairsPath(int n) {
        if (n == 0) {
            ArrayList arrayList = new ArrayList<String>();
            arrayList.add("");
            return arrayList;
        } else if (n < 0) {
            ArrayList arrayList = new ArrayList<String>();
            return arrayList;
        }


        ArrayList<String> path1 = getStairsPath(n - 1);
        ArrayList<String> path2 = getStairsPath(n - 2);
        ArrayList<String> path3 = getStairsPath(n - 3);

        ArrayList allPaths = new ArrayList<String>();

        for (String val : path1) {
            allPaths.add("1" + val);
        }

        for (String val : path2) {
            allPaths.add("2" + val);
        }

        for (String val : path3) {
            allPaths.add("3" + val);
        }

        return allPaths;
    }
}
