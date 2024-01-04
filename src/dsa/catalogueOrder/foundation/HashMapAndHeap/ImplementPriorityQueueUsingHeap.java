package dsa.catalogueOrder.foundation.HashMapAndHeap;

import java.util.ArrayList;
public class ImplementPriorityQueueUsingHeap {
    public static class PriorityQueue {
        ArrayList<Integer> data;

        public PriorityQueue() {
            data = new ArrayList<>();
        }

        private void swap(int left, int right) {
            int leftValue = data.get(left);
            int rightValue = data.get(right);
            data.set(left, rightValue);
            data.set(right, leftValue);
        }

        public void add(int val) {
            data.add(val);
            upHeapify(data.size() - 1);
        }

        private void upHeapify(int index) {
            if (index == 0) return;

            int parentIndex = (index - 1) / 2;
            if (data.get(index) < data.get(parentIndex)) {
                swap(index, parentIndex);
                upHeapify(parentIndex);
            }
        }

        public int remove() {
            if (data.size() == 0) {
                System.out.println("Underflow");
                return -1;
            }
            swap(0, data.size() - 1);
            int val = data.remove(data.size() - 1);
            downHeapify(0);
            return val;
        }

        private void downHeapify(int index) {
            int minIndex = index;

            int leftChildIndex = 2 * index + 1;
            if (leftChildIndex < data.size() && data.get(leftChildIndex) < data.get(minIndex)) {
                minIndex = leftChildIndex;
            }

            int rightChildIndex = 2 * index + 2;
            if (rightChildIndex < data.size() && data.get(rightChildIndex) < data.get(minIndex)) {
                minIndex = rightChildIndex;
            }

            if (minIndex != index) {
                swap(minIndex, index);
                downHeapify(minIndex);
            }
        }

        public int peek() {
            if (data.size() == 0) {
                System.out.println("Underflow");
                return -1;
            }

            return data.get(0);
        }

        public int size() {
            return data.size();
        }
    }
}
