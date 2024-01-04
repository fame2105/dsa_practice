package dsa.catalogueOrder.foundation.HashMapAndHeap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class SortKSortedElements {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int k = Integer.parseInt(br.readLine());


    }

    private static void printKSorted (int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // step 1: add k elements into priority queue
        for (int i = 0; i < k; i++) {
            pq.add(nums[i]);
        }

        // step 2 : manage remaining elements
        for(int i = k; i< nums.length; i++) {
            // add
            pq.add(nums[i]);

            // remove
            System.out.println(pq.remove());
        }

        // print remaining elements in pq
        while(pq.size() > 0) {
            System.out.println(pq.remove());
        }
    }
}
