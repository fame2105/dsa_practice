package dsa.catalogueOrder.foundation.dynamicProgramming;

import java.util.Scanner;

// exactly similar to CountBinaryStrings  or
// https://leetcode.com/problems/count-number-of-ways-to-place-houses/
public class _13_ArrangeBuildings {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        getBuildingArrangementCount(n);

    }

    private static long getBuildingArrangementCount(int n) {
        int space = 1; // initial case when n is 1
        int building = 1; // initial case when n is 1

        for (int i = 2; i <= n; i++) {
            int currentAllowedBuildings = space;
            int currentAllowedSpaces = building + space;

            space = currentAllowedSpaces;
            building = currentAllowedBuildings;
        }

        long totalArrangements = building + space;

        // Squaring because there are two sides and totalArrangements is only calculated for one side.
        return totalArrangements * totalArrangements;
    }
}
