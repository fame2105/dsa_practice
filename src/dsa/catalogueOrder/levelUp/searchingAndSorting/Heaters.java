package dsa.catalogueOrder.levelUp.searchingAndSorting;

import java.util.Arrays;

public class Heaters {
    public static int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int ans = 0;
        for (int i = 0; i < houses.length; i++) {
            int house = houses[i];
            int[] distance = getDistanceFromHeater(heaters, house);

            int distFromLeft = distance[0] == -1 ? Integer.MAX_VALUE : house - distance[0];
            int distFromRight = distance[1] == -1 ? Integer.MAX_VALUE : distance[1] - house;

            int dist = Math.min(distFromLeft, distFromRight);
            ans = Math.max(ans, dist);            
        }
        return ans;
    }

    private static int[] getDistanceFromHeater(int[] heaters, int house) {
        int lo = 0;
        int hi = heaters.length - 1;
    
        int[] distance = new int[] { -1, -1 }; // distance[0] justSamller/floor  distance[1] justLarger/ceil

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int heater = heaters[mid];

            if (heater == house) {
                distance[0] = house;
                distance[1] = house;
                return distance;
            } else if (heater < house) {
                distance[0] = heater;
                lo = mid + 1;
            } else if (heater > house) {
                distance[1] = heater;
                lo = mid + 1;
            }
        }

        return distance;
    }
}
