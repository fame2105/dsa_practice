package dsa.catalogueOrder.levelUp.arraysAndStrings.intervals;

import java.util.Arrays;
import java.util.PriorityQueue;

// Leetcode Premium question -> Lintcode link : https://www.lintcode.com/problem/919
public class MeetingRoomsII {

    // Method - 1 : Using PriorityQueue
    // interval[0] -> startTime
    // interval[1] -> endTime
    public static int meetingRooms_methodI(int intervals[][]) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] interval : intervals) {
            if (pq.size() == 0) {
                pq.add(interval[1]);
            } else {
                int prevMeetingEndTime = pq.peek();
                if(interval[0] < prevMeetingEndTime) {
                    pq.add(interval[1]);
                } else {
                    pq.remove();
                    pq.add(interval[1]);
                }
            }
        }

        return pq.size();
    }

    // Method - 2 : Using Chronological Method
    public static int meetingRooms_methodII(int intervals[][]) {
        int[] startTimes = new int[intervals.length];
        int[] endTimes = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int i = 0, j = 0, roomCount = 0;

        while(i < startTimes.length) {
            if(startTimes[i] < endTimes[j]) {
                roomCount++;
                i++;
            } else {
                i++;
                j++;
            }
        }
        return roomCount;
    }
}
