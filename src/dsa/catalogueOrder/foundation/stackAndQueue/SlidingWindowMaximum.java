package dsa.catalogueOrder.foundation.stackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
    public static void main(String[] args) {
        int[] a = {1, 3, 1, 2, 0, 5};
        int k = 3;
        for (int i : maxInEveryWindowOfSizeK(a, k)) {
            System.out.print(i + " ");
        }

        sampleCodeForUnderstandingDequeFunctionality();
    }

    private static int[] maxInEveryWindowOfSizeK(int[] a, int k) {
        int[] result = new int[a.length - k + 1];
        int idx = 0;
        Deque<Integer> q = new ArrayDeque<>();
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            // Till window length is not achieved, keep adding elements in the queue such that largest element remains in the front of the queue
            while (j < a.length && j - i + 1 <= k) {
                if (q.isEmpty()) {
                    q.add(a[j]);
                } else {
                    // remove elements till the peek element in queue is greater than current element or q is empty then
                    while (!q.isEmpty() && a[j] > q.peekLast()) {
                        q.removeLast();
                    }
                    q.addLast(a[j]);
                }

                // windowLength == k (make answer and if a[i] == the element in front of the queue then remove that element from queue since that element cannot be part of the next window
                if (j < a.length && j - i + 1 == k) {
                    result[idx++] = q.peek();

                    if (q.peek() == a[i]) {
                        q.remove();
                    }
                }
                j++;
            }
        }
        return result;
    }

    private static void sampleCodeForUnderstandingDequeFunctionality() {
        Deque<Integer> deque = new ArrayDeque<>();

        deque.add(2); // adds the element in the LAST in the queue -> addLast()/append()
        deque.push(1);
        deque.push(3); // adds the element at the FIRST in the queue -> addFirst()
        System.out.println(deque); // output is [3, 1, 2]

        deque.removeLast(); // removes the LAST element in the queue
        System.out.println(deque); // output is [3,1]
        deque.remove(); // removeFirst -> removes the FIRST element in the queue
        System.out.println(deque); // output is [1]

        deque.add(2);
        deque.add(3);
        System.out.println(deque); // [1,2,3]

        System.out.println(deque.peek()); // 1 : peek() -> peekFirst() -> peeks at the FIRST element in the queue
        System.out.println(deque.peekLast()); // 3 : peeks at the LAST element in the queue
    }
}
