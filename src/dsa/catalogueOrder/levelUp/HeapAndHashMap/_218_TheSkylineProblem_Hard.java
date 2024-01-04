package dsa.catalogueOrder.levelUp.HeapAndHashMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class _218_TheSkylineProblem_Hard {
    public static void main(String[] args) {
        int[][] buildings = {
                {2, 4, 8},
                {2, 6, 10}
        };
        System.out.println(getSkyline(buildings));
    }
    private static class Pair implements Comparable<Pair>{
        int x;
        int ht;
        Pair(int x, int ht) {
            this.x = x;
            this.ht = ht;
        }

        public int compareTo(Pair o) {
            if(this.x != o.x) {
                return this.x - o.x;
            } else {
                return this.ht - o.ht;
            }
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", ht=" + ht +
                    '}';
        }
    }

    public static List<List<Integer>> getSkyline(int[][] buildings) {
        List<Pair> list = new ArrayList<>();
        /**
         * building[i] = {x, y, ht}
         * x : start coordinate of rectangle
         * x : start coordinate of rectangle
         * ht : height of rectangle
         *
         * in this loop, we are separating the given endpoint into {x, -ht} and {y, ht} into a list of coordinates
         * Push startingPoints with -ht.... this is done to identify that we have come cross a startingPoint of a rectangle
         * Consider a scenario where 2 rectangles have same height and they are overlapping...
         * we won't be able to identify the corresponding starting and ending points for two different rectangle.... therefore use -ht for starting points of rectangles
         */

        for(int i = 0; i < buildings.length; i++) {
            int sp = buildings[i][0];
            int ep = buildings[i][1];
            int ht = buildings[i][2];

            list.add(new Pair(sp, -ht));
            list.add(new Pair(ep, ht));
        }

        Collections.sort(list); // sort the list based on startingPoint of rectangles, if startingPoints are same, then their height

        System.out.println(list);

        List<List<Integer>> ans = new ArrayList<>();

        /** PriorityQueue will contain height of the rectangles and return the maxHeight first
        * Number of entries in the queue will also show how many active rectangles... the rectangles that we are currently processing.
        */
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        int cht = 0; // Current Height of the rectangle
        pq.add(0);

        /**
         * Idea is to capture all the heighest points of the rectangles whenever there is a change in the height
         */
        for(int i = 0; i < list.size(); i++) {
            int x = list.get(i).x;
            int ht = list.get(i).ht;

            if(ht < 0) { // push all heights of starting points(height in negative) in the queue
                pq.add(-ht);
            } else {
                /**
                 *  remove the heights whenever we come across the ending point(height in positive)
                 *  note that we are not removing the peek() element here, we are removing the entry which is equal to ht... internally kinda linear search
                 *  (Consider using a SegemntTree based approach in future)
                 */
                pq.remove(ht);
            }

            /**
             * // as soon we input or remove something from PriorityQueue,
             * there could potentially be a change in the height of the currently Highest point in terms of height
             * capture(Add to ans) the entry currently at the peak of the queue and change currentHeight to pq.peek()
             */
            if(pq.peek() != cht) {
                List<Integer> coordinate = new ArrayList<>();
                coordinate.add(x);
                coordinate.add(pq.peek());

                ans.add(coordinate);
                cht = pq.peek();
            }
        }

        return ans;
    }
}
