package dsa.catalogueOrder.foundation.recursion.printRecursion;

import java.util.Scanner;

public class PrintStairPaths {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int stairNumber = s.nextInt();
        printStairPaths(stairNumber, "");
        System.out.println("\n" + counter);
    }

    static int counter = 0;
    private static void printStairPaths(int stairCaseNUmber, String path) {
        if(stairCaseNUmber == 0) {
            counter += 1;
            System.out.print(path + "\t");
            return;
        } else if(stairCaseNUmber < 0) {
            return;
        }

        printStairPaths(stairCaseNUmber-1, path + 1);
        printStairPaths(stairCaseNUmber-2, path + 2);
        printStairPaths(stairCaseNUmber-3, path + 3);
    }
}
