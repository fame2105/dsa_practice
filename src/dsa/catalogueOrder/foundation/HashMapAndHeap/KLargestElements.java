package dsa.catalogueOrder.foundation.HashMapAndHeap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class KLargestElements {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int k = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // step 1: add k elements into priority queue
        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }

        // step 2: process remaining elements from array
        for (int i = k; i < arr.length; i++) {
            if(arr[i] > pq.peek()) {
                pq.remove();
                pq.add(arr[i]);
            }
        }

        // step 3: print k elements form priority queue
        while(pq.size() > 0) {
            System.out.println(pq.remove());
        }
    }
}
