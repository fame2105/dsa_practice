package dsa.leetcodeANDgfg;

import java.util.TreeMap;

// https://leetcode.com/problems/my-calendar-i/  # intervals, #Use any balanced binary Tree
public class _729_MyCalendar_I {
    TreeMap<Integer, Integer> calendar;

    public _729_MyCalendar_I() {
        calendar = new TreeMap<>();
    }

    public boolean book(int currentEventStart, int currentEventEnd) {
        Integer prevEventStart = calendar.floorKey(currentEventStart); // event that started just before currentEvent
        Integer nextEventStart = calendar.ceilingKey(currentEventStart); // event that started just after currentEvent

        if((prevEventStart == null || calendar.get(prevEventStart) <= currentEventStart) && (nextEventStart == null || currentEventEnd <= nextEventStart)) {
            calendar.put(currentEventStart, currentEventEnd);
            return true;
        }

        return false;
    }
}
