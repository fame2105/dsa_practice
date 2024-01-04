package dsa.catalogueOrder.levelUp.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class _4_BusRoutes {
    public static int numBusesToDestination(int[][] routes, int start, int destination) {
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                int busStopNo = routes[i][j];
                ArrayList<Integer> bus = map.getOrDefault(busStopNo, new ArrayList<>());
                bus.add(i);
                map.put(busStopNo, bus);
            }
        }

        /**
         * maintaining visitedBuses is an optimization step.. otherwise we will
         * be wasting a few iterations in checking that we are not adding already visited bus-stops
         */
        HashSet<Integer> visitedBuses = new HashSet<>();
        HashSet<Integer> visitedBusStops = new HashSet<>();

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visitedBusStops.add(start);
        int level = 0;

        while (q.size() > 0) {
            int size = q.size();
            while (size > 0) {
                int busStop = q.remove();

                if (busStop == destination) return level;

                for (int bus : map.get(busStop)) { // get buses for this bus stop
                    if (visitedBuses.contains(bus) == false) {
                        int[] busStops = routes[bus];
                        for (int busStopVar : busStops) { // add busStops for each this bus
                            if (visitedBusStops.contains(busStopVar) == false) {
                                q.add(busStopVar);
                                visitedBusStops.add(busStopVar);
                            }
                        }
                        visitedBuses.add(bus);
                    }
                }
                size--;
            }
            level++;
        }
        return -1;
    }
}
