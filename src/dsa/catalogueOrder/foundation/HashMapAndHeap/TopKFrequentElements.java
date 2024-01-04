package dsa.catalogueOrder.foundation.HashMapAndHeap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

    class Pair {
        int element;
        int count;

        Pair(int element, int count) {
            this.element = element;
            this.count = count;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        // Prepare frequency map
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            int freq = map.getOrDefault(nums[i], 0);
            map.put(nums[i], freq+1);
        }

        // insert all map entries in the priority queue
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair p1, Pair p2) {
                return p2.count - p1.count;
            }
        });

        for(int key : map.keySet()) {
            int freq = map.get(key);
            pq.add(new Pair(key, freq));
        }

        while(k > 0) {
            result[k-1] = pq.remove().element;
            k--;
        }

        return result;

    }
}

