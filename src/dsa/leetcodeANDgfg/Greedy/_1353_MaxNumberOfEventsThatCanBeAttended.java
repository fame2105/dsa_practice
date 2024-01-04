package dsa.leetcodeANDgfg.Greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

// https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/  #Greedy
public class _1353_MaxNumberOfEventsThatCanBeAttended {
    /**
     * Think of the given story like this:
     * 1. There are offer coupons that have a startDate and an expiryDate, which means you can't use a certain coupon
     *    before it was issued/startDate and since it expires after it's expiryDate, so it can't be used beyond it's
     *    expiryDate.
     * 2. As per the question, we want to be able to use/redeem max coupons with following constraints in place:
     *    a) Only one coupon can be used in a day
     *    b) coupon can be used in between startDate>= useDay <= expiryDate.
     *
     * Well naturally, we would want to use those coupons first that have the nearest expiryDate, so that we do not waste the coupons ... (Greedy Approach)...this is supposed to be the light bulb moment.
     * Algorithm :
     * Step 1: Sort the given events/copons by their startDate....why ? .
     * Well because there ain't no sense in considering to use a coupon that isn't even ready to be used..... in terms of question( how can you attend a certain event even before its startDate, ex : you shouldn't be considering to attend an event that is supposed to start on day 3 while you are on day 1.)
     * On day 1 I will plan to use the coupons that have startDate as day 1
     *
     * Step 2:
     */
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]); // sort based on start Date

        // push endDate of all the events that start today in PriorityQueue.
        // In Doing so, we will be able to fetch the NearestEndTime of an event and attend that event that has lowestEndTime thus far.
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int i = 0; // eventCounter;
        int ans = 0;
        for(int d = 1; d <= 100000; d++) { // dayNo will not exceed 10^5 .. mentioned in constraints

            // Remove all those coupons/events that have expired... if endDate of previously inserted events is less than today then they have expired, and hence cannot be used any longer
            while(pq.size() > 0 && pq.peek() < d) {
                pq.remove();
            }

            // Push endTime of all those events that start today in the priorityQueue
            while(i < events.length && events[i][0] == d) {
                pq.add(events[i][1]);
                i++;
            }

            // at this point, PriorityQueue contains endDate of only those events that have not yet expired and have already started, either previously or today
            // Attend one event with the shortest endDate in the PQ
            if(pq.size() > 0) {
                pq.remove();
                ans += 1;
            }


            // No events left to be processed and there aren't any carryForward events due to long expiryTime from previous iterations... end the process here
            if(pq.size() == 0 && i == events.length) break;
        }

        return ans;
    }
}
