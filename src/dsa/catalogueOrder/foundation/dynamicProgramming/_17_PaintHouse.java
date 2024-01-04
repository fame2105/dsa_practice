package dsa.catalogueOrder.foundation.dynamicProgramming;

// https://leetcode.com/problems/paint-house/
// Max Sum Non Adjacent Elements
public class _17_PaintHouse {
    public static void main(String[] args) {
        // rows -> number of house
        // columns -> number of colors available to paint the houses with (3 -> given R, G, B)
        int[][] cost = new int[][]{
                {1, 5, 7},
                {5, 8, 4}
//                {3, 2, 9},
//                {1, 2, 4}
        };

        int minCostToPaintHousesWith3Colors = minCostToPaintTheHousesGreedyApproach(cost);
        System.out.println(minCostToPaintHousesWith3Colors);

        int minCost = minCostTOPaintTheHousesRecursiveApproach(cost, 0, -1);
        System.out.println(minCost);
    }

    // quite similar to greedy approach taken in maxSumNoConsecutiveElements
    private static int minCostToPaintTheHousesGreedyApproach(int[][] cost) {
        int rColorCost = 0;
        int bColorCost = 0;
        int gColorCost = 0;

        for (int i = 0; i < cost.length; i++) {
            int newRColorCost = Math.min(bColorCost, gColorCost) + cost[i][0];
            int newBColorCost = Math.min(rColorCost, gColorCost) + cost[i][1];
            int newGColorCost = Math.min(rColorCost, bColorCost) + cost[i][2];

            rColorCost = Math.min(newBColorCost, newGColorCost);
            bColorCost = Math.min(newRColorCost, newGColorCost);
            gColorCost = Math.min(newRColorCost, newBColorCost);
        }

        return Math.min(Math.min(rColorCost, bColorCost), gColorCost);
    }

    // put house on level and colors as options
    // each house can be painted with 2 different colors which are different from the prev. one..
    // except for the first house.. it will have the option to be painted with all the colors
    private static int minCostTOPaintTheHousesRecursiveApproach(int[][] cost, int houseIdx, int idxNotToUse) {
        if(houseIdx == cost.length) return 0;

        int minCost = (int)1e9;
        if(idxNotToUse != -1) { // Do not call for color that should be omitted
            for(int clr = 0; clr < cost[houseIdx].length; clr++) {
                if(clr == idxNotToUse) continue;
                minCost = Math.min(minCostTOPaintTheHousesRecursiveApproach(cost, houseIdx + 1, clr), minCost);
            }
            return minCost + cost[houseIdx][idxNotToUse];
        } else { // Call for every color
            for(int clr = 0; clr < cost[houseIdx].length; clr++) {
                minCost = Math.min(minCostTOPaintTheHousesRecursiveApproach(cost, houseIdx + 1, clr), minCost);
            }
            return minCost;
        }
    }


}
