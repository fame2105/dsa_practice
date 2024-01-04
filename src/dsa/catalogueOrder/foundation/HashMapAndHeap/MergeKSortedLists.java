package dsa.catalogueOrder.foundation.HashMapAndHeap;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    static class ListIndex implements Comparable<ListIndex> {
        int li; // list Index -> ith list
        int di; // Data Index -> dth index of that list
        int value; // value present in the ith list at dth index

        ListIndex(int li, int di, int value) {
            this.li = li;
            this.di = di;
            this.value = value;
        }

        public int compareTo(ListIndex o) {
            return this.value - o.value;
        }

        @Override
        public String toString() {
            return "ListIndex{" +
                    "li=" + li +
                    ", di=" + di +
                    ", value=" + value +
                    '}';
        }
    }

    public static ArrayList<Integer> mergeKSortedLists(ArrayList<ArrayList<Integer>> lists) {
        ArrayList<Integer> rv = new ArrayList<>();
        PriorityQueue<ListIndex> pq = new PriorityQueue<>();

        // Add the first Element of each list int the Priority Queue
        for (int i = 0; i < lists.size(); i++) {
            pq.add(new ListIndex(i, 0, lists.get(i).get(0)));
        }
        System.out.println(pq);

        while (pq.size() > 0) {
            ListIndex listIndex = pq.remove();
            rv.add(listIndex.value);
            listIndex.di++;

            if (listIndex.di < lists.get(listIndex.li).size()) {
                listIndex.value = lists.get(listIndex.li).get(listIndex.di);
                pq.add(listIndex);
            }
        }
        return rv;
    }

    public static void main(String[] args) {
        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(10);
        l1.add(20);
        l1.add(30);
        l1.add(40);
        l1.add(50);

        ArrayList<Integer> l2 = new ArrayList<>();
        l2.add(5);
        l2.add(7);
        l2.add(9);
        l2.add(11);
        l2.add(19);
        l2.add(55);
        l2.add(57);

        ArrayList<Integer> l3 = new ArrayList<>();
        l3.add(1);
        l3.add(2);
        l3.add(3);

        ArrayList<Integer> l4 = new ArrayList<>();
        l4.add(32);
        l4.add(39);

        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        lists.add(l4);

        System.out.println(mergeKSortedLists(lists));
    }
}
