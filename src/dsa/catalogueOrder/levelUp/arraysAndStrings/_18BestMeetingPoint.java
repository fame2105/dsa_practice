package dsa.catalogueOrder.levelUp.arraysAndStrings;

import java.util.ArrayList;

public class _18BestMeetingPoint {
    public static int minTotalDistance(int[][] grid) {

        // find x-coordinates by travelling row wise
        ArrayList<Integer> xCoordinates = new ArrayList<>();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == 1) xCoordinates.add(row);
            }
        }

        // find y-coordinates by travelling column wise
        ArrayList<Integer> yCoordinates = new ArrayList<>();
        for (int col = 0; col < grid[0].length; col++) {
            for (int row = 0; row < grid.length; row++) {
                if (grid[row][col] == 1) yCoordinates.add(col);
            }
        }

        // find Meeting Point : median
        int x = xCoordinates.get(xCoordinates.size() / 2);
        int y = yCoordinates.get(yCoordinates.size() / 2);

        // calculate sum of distance of each Person from meeting point
        int distance = 0;
        for (int i = 0; i < xCoordinates.size(); i++) {
            distance += Math.abs(xCoordinates.get(i) - x) + Math.abs(yCoordinates.get(i) - y);
        }
        return distance;
    }
}
